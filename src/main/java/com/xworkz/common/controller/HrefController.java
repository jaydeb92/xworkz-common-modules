package com.xworkz.common.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.common.dto.AppPropDTO;
import com.xworkz.common.service.AppPropService;

@Controller
@RequestMapping("/")
public class HrefController {
	@Autowired
	private AppPropService service;
	private List<AppPropDTO> seList;
	private List<AppPropDTO> idList;
	private static final Logger LOGGER = Logger.getLogger(HrefController.class);

	@PostConstruct
	public void init() {
		LOGGER.info("invoked init method in\t" + this.getClass().getSimpleName());
		seList = service.fetchAllByType("SE");
		idList = service.fetchAllById("ID");
		LOGGER.info("SELIST: " + seList);
		LOGGER.info("IDLIST: " + idList);

	}

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

	@RequestMapping(value = "/booking.do")
	public String doNavigateForBookingPage(Model model) {
		LOGGER.info("invoked doNavigateForBookingPage");
		model.addAttribute("SElist", seList);
		model.addAttribute("IDlist", idList);
		LOGGER.info("SELIST: " + seList);
		LOGGER.info("IDLIST: " + idList);
		return "BookingVisit";

	}
}
