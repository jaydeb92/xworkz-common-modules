package com.xworkz.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.LoginDAO;
import com.xworkz.common.entity.PersonalInfoEntity;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;
	@Autowired
	private MailService mailService;
	@Autowired
	private PasswordCryptionService passwordCryptionService;
	@Autowired
	private LoginCountService loginCountService;
	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

	public LoginServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String login(String email, String password) {
		boolean valid = false;
		int loginCount = 0;
		boolean isLock = false;
		try {
			LOGGER.info("invoked login method in LoginServiceImpl ");
			if (email != null) {
				PersonalInfoEntity personalInfoEntity = dao.fetchEntityByEmail(email);

				Integer loginCountFromDB = personalInfoEntity.getLoginCount();

				Boolean isLockFromDB = personalInfoEntity.getIsLock();
				if (personalInfoEntity != null && isLockFromDB == isLock) {
					String mail = personalInfoEntity.getEmail();
					String pwd = personalInfoEntity.getPassword();
					String decryptedPwd = passwordCryptionService.decrypt(pwd);
					LOGGER.info("decryptedPwd: " + decryptedPwd);
					valid = true;

					if (valid && mail.equals(email)) {
						LOGGER.info("mail id registered can login");
						valid = true;

					} else {
						LOGGER.info("mail id not registered can't login");
						valid = false;
					}
					if (valid && decryptedPwd.equals(password)) {
						LOGGER.info("password is valid  can login");
						loginCount = 0;
						loginCountService.loginCount(personalInfoEntity, loginCount);
						LOGGER.info("loginCount: " + loginCount);
						valid = true;

					} else {
						LOGGER.info("password is not valid  can't login");

						if (loginCountFromDB < 3) {
							loginCount = loginCountFromDB + 1;
							loginCountService.loginCount(personalInfoEntity, loginCount);
							LOGGER.info("loginCount: " + loginCount);
							if (loginCount == 3) {
								isLock = true;
								loginCountService.disableLogin(personalInfoEntity, isLock);
								LOGGER.info("Account has been locked..");
							}
						}

						valid = false;
					}
					if (valid && loginCountFromDB < 3) {
						loginCount = 0;
						loginCountService.loginCount(personalInfoEntity, loginCount);
						
						return "You have logged in successfully..";

					} else {
						return "Email ID or Password is incorrect..";

					}
				} else {
					LOGGER.info("Your account is locked reset password for login..");
					return "Your account is locked reset password for login..";
				}

			} else {
				LOGGER.info("email is null");

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
