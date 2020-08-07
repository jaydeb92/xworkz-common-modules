package com.xworkz.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;
	@Autowired
	private MailService mailService;
	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

	public LoginServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String sendGeneratedPassword(String email) {
		try {
			LOGGER.info("invoked sendGeneratedPassword in LoginServiceImpl");
			if (email != null) {
				Long mailCount = dao.checkMailExistingForgeneratePassword(email);
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

}
