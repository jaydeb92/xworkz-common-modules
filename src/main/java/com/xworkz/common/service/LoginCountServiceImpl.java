package com.xworkz.common.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.LoginCountDAO;
import com.xworkz.common.entity.PersonalInfoEntity;

@Service
public class LoginCountServiceImpl implements LoginCountService {
	private static final Logger LOGGER = Logger.getLogger(LoginCountServiceImpl.class);
	@Autowired
	private LoginCountDAO loginCountDAO;

	@Override
	public String loginCount(PersonalInfoEntity personalInfoEntity, int count) {
		try {
			if (Objects.nonNull(personalInfoEntity)) {
				LOGGER.info("personalInfoEntity not null can update");
				loginCountDAO.loginCountUpdate(personalInfoEntity, count);
			} else {
				LOGGER.info("personalInfoEntity is null can't update");
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public String disableLogin(PersonalInfoEntity personalInfoEntity, boolean isLock) {
		try {
			if (Objects.nonNull(personalInfoEntity)) {
				LOGGER.info("personalInfoEntity not null can update");
				loginCountDAO.disableAccountUpdate(personalInfoEntity, isLock);
			} else {
				LOGGER.info("personalInfoEntity is null can't update");
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
