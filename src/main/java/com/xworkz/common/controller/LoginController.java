package com.xworkz.common.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.common.service.LoginService;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	LoginService loginService;
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	public LoginController() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/sendPassword.do", method = RequestMethod.POST)
	public String sendPassword(@RequestParam String email, Model model) {
		try {
			LOGGER.info("invoked sendPassword method in LoginController class");
			String passwordInfoMessage = loginService.sendGeneratedPassword(email);
			model.addAttribute("message", passwordInfoMessage);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return "Register";

	}

}
