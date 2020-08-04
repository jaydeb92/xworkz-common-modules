package com.xworkz.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.common.dto.TempleRegistrationDTO;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender mailSender;
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

}
