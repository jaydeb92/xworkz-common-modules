package com.xworkz.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.PasswordSaveDAO;

@Service
public class PasswordSaveServiceImpl implements PasswordSaveService {
	@Autowired
	private PasswordSaveDAO passwordSaveDAO;
	private static final Logger LOGGER = Logger.getLogger(PasswordSaveServiceImpl.class);

	public PasswordSaveServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndsavePassword(String email, String password) {
		try {
			if (email != null && password != null) {
				LOGGER.debug("mail and password not null can update it");
				Integer result = passwordSaveDAO.savePassword(email, password);
				LOGGER.debug("result: " + result);
				return "password updated in database";
			} else {
				LOGGER.debug("mail and password is null can not update it");
				return "password not able to update in database";
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
