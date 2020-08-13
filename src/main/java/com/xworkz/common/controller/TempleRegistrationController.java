package com.xworkz.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.common.dto.TempleRegistrationDTO;
import com.xworkz.common.service.PersonalInfoService;

@Controller
@RequestMapping(value = "/")
public class TempleRegistrationController {
	@Autowired
	private PersonalInfoService personalInfoService;

	private static final Logger LOGGER = Logger.getLogger(TempleRegistrationController.class);

	public TempleRegistrationController() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)

	public String doTempleRegistration(TempleRegistrationDTO dto, Model model) {
		try {
			LOGGER.info("invoked doTempleRegistration method in TempleRegistrationController class");

			String regInfoMessage = personalInfoService.saveAndValidatePersonalInfoEntity(dto);

			model.addAttribute("message", regInfoMessage);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "Register";

	}

	@RequestMapping(value = "/sendDetails.do", method = RequestMethod.POST)
	public String sendMailAfterRegister(@RequestParam String email, Model model) {
		try {
			LOGGER.info("invoked sendMailAfterRegister method in TempleRegistrationController class");
			String mailInfoMessage = personalInfoService.validateAndfetchPersonalInfoEntityByEmail(email);
			model.addAttribute("message", mailInfoMessage);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "SendDetails";

	}

}
