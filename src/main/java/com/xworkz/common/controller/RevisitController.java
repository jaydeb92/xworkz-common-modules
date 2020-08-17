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

import com.xworkz.common.dto.TempleRegistrationDTO;
import com.xworkz.common.service.RevisitService;

@Controller
@RequestMapping(value = "/")
public class RevisitController {
	private static final Logger LOGGER = Logger.getLogger(RevisitController.class);
	@Autowired
	private RevisitService revisitService;

	public RevisitController() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "/bookingVisit.do", method = RequestMethod.POST)
	public String doRevisit(TempleRegistrationDTO dto, Model model) {
		try {
			String messageForRevisit = revisitService.reVisit(dto);
			model.addAttribute("message", messageForRevisit);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return "BookingVisit";

	}

}
