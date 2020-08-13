package com.xworkz.common.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.LoginDAO;
import com.xworkz.common.dto.TempleRegistrationDTO;
import com.xworkz.common.entity.PersonalInfoEntity;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private GeneratePasswordService generatePasswordService;
	@Autowired
	private MailSender mailSender;
	@Autowired
	private PasswordSaveService passwordSaveService;
	@Autowired
	private PasswordCryptionService cryptionService;

	@Autowired
	private LoginDAO dao;
	@Autowired
	private LoginCountService loginCountService;
	private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

	public MailServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public void sendMail(TempleRegistrationDTO dto) {
		try {
			String mail = dto.getEmail();
			if (mail != null) {
				LOGGER.info("Mail not null can send mail..");

				LOGGER.info("creating SimpleMailMessage object..");
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(dto.getEmail());
				mailMessage.setSubject(
						"Hi" + " " + dto.getName() + " " + "you have registered successfully for visiting temple..");
				mailMessage.setText("Your visiting date is: " + dto.getDate());
				mailSender.send(mailMessage);
				LOGGER.info("mail sent..");

			} else {
				LOGGER.info("Mailid is  null can't send mail..");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	@Override
	public void sendPasswordByMail(String email) {
		try {

			if (email != null) {
				LOGGER.info("Mail not null can send mail..");

				LOGGER.info("creating SimpleMailMessage object..");
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(email);
				mailMessage.setSubject("You have generated password..");
				String password = generatePasswordService.generatePassword();
				// calling password encrypt method..
				String cryptedPassword = cryptionService.encrypt(password);
				LOGGER.info("cryptedPassword: " + cryptedPassword);
				// for saving password
				String updatePasswordInfoMessage = passwordSaveService.validateAndsavePassword(email, cryptedPassword);
				LOGGER.info("updatePasswordInfoMessage: " + updatePasswordInfoMessage);

				mailMessage.setText("Your Password is: " + password);
				mailSender.send(mailMessage);
				LOGGER.info("mail sent..");

			} else {
				LOGGER.info("Mailid is  null can't send mail..");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	@Override
	public void reSendPasswordByMail(String email) {
		int count = 0;
		boolean isLock = false;
		try {

			if (email != null) {
				LOGGER.info("Mail not null can send mail..");

				LOGGER.info("creating SimpleMailMessage object..");
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(email);
				mailMessage.setSubject("You have generated password..");

				// for resetting login count as zero
				PersonalInfoEntity personalInfoEntity = dao.fetchEntityByEmail(email);
				LOGGER.info("personalInfoEntity: " + personalInfoEntity);

				loginCountService.loginCount(personalInfoEntity, count);
				loginCountService.disableLogin(personalInfoEntity, isLock);

				String password = generatePasswordService.generatePassword();
				// calling password encrypt method..
				String cryptedPassword = cryptionService.encrypt(password);
				LOGGER.info("cryptedPassword: " + cryptedPassword);
				// for saving password
				String updatePasswordInfoMessage = passwordSaveService.validateAndsavePassword(email, cryptedPassword);
				LOGGER.info("updatePasswordInfoMessage: " + updatePasswordInfoMessage);

				mailMessage.setText("Your Password is: " + password);
				mailSender.send(mailMessage);
				LOGGER.info("mail sent..");

			} else {
				LOGGER.info("Mailid is  null can't send mail..");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

}
