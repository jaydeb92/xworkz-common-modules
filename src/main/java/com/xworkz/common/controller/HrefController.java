package com.xworkz.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HrefController {
	private static final Logger LOGGER = Logger.getLogger(HrefController.class);

	public HrefController() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/loginPage.do")
	public String doNavigateForLoginPage() {
		LOGGER.info("invoked doNavigateForLoginPage");
		return "Login";

	}

	@RequestMapping(value = "/resend.do")
	public String doNavigateForSendDetailsPage() {
		LOGGER.info("invoked doNavigateForSendDetailsPage");
		return "SendDetails";

	}

	@RequestMapping(value = "/registration.do")
	public String doNavigateForRegisterPage() {
		LOGGER.info("invoked doNavigateForRegisterPage");
		return "Register";

	}

	@RequestMapping(value = "/generatePassword.do")
	public String doNavigateForGeneratePasswordPage() {
		LOGGER.info("invoked doNavigateForRegisterPage");
		return "GeneratePassword";

	}

	@RequestMapping(value = "/reSend.do")
	public String doNavigateForReSendPasswordPage() {
		LOGGER.info("invoked doNavigateForReSendPasswordPage");
		return "ResendPassword";

	}
}
