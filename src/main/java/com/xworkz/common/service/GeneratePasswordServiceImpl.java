package com.xworkz.common.service;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.LoginDAO;

@Service
public class GeneratePasswordServiceImpl implements GeneratePasswordService {

	@Autowired
	private MailService mailService;
	@Autowired
	private LoginDAO loginDAO;
	private static final Logger LOGGER = Logger.getLogger(GeneratePasswordServiceImpl.class);

	public GeneratePasswordServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String generatePassword() {
		try {
			LOGGER.info("invoked generatePassword method in GeneratePasswordServiceImpl");
			String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
			String specialCharacters = "!@#$";
			String numbers = "1234567890";
			String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
			Random random = new Random();
			int length = 8;
			char[] password = new char[length];
			String passwords = null;
			password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
			password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
			password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
			password[3] = numbers.charAt(random.nextInt(numbers.length()));

			for (int i = 4; i < length; i++) {
				password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
				passwords = new String(password);
			}
			LOGGER.info("password : " + passwords);
			return passwords;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public String sendGeneratedPassword(String email) {
		try {
			LOGGER.info("invoked sendGeneratedPassword in LoginServiceImpl");
			if (email != null) {
				Long mailCount = loginDAO.checkMailExistingForgeneratePassword(email);
				if (mailCount != 0) {
					mailService.sendPasswordByMail(email);
					LOGGER.info("mail has been sent");
					return "Your password has been sent to your mail id";
				} else {
					LOGGER.info("mail id not registered");
					return "Your mail id not in registered";
				}
			} else {
				LOGGER.info("mail id null");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return null;
	}

	@Override
	public String reSendGeneratedPassword(String email) {
		try {
			LOGGER.info("invoked reSendGeneratedPassword in LoginServiceImpl");
			if (email != null) {
				Long mailCount = loginDAO.checkMailExistingForgeneratePassword(email);
				if (mailCount != 0) {
					mailService.reSendPasswordByMail(email);
					LOGGER.info("mail has been sent");
					return "Your password has been sent to your mail id";
				} else {
					LOGGER.info("mail id not registered");
					return "Your mail id not in registered";
				}
			} else {
				LOGGER.info("mail id null");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
