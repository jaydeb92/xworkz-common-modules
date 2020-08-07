package com.xworkz.common.service;

import java.util.Random;

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

	@Override
	public char[] generatePassword() {
		try {
			LOGGER.info("invoked generatePassword method in LoginServiceImpl");
			String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
			String specialCharacters = "!@#$";
			String numbers = "1234567890";
			String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
			Random random = new Random();
			int length = 8;
			char[] password = new char[length];

			password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
			password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
			password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
			password[3] = numbers.charAt(random.nextInt(numbers.length()));

			for (int i = 4; i < length; i++) {
				password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
			}
			LOGGER.info("password : " + password);
			return password;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;

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
				char[] password = generatePassword();
				String str = new String(password);
				mailMessage.setText("Your Password is: " + str);
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
