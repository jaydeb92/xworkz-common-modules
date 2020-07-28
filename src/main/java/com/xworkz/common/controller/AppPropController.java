package com.xworkz.common.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.common.dto.AppPropDTO;
import com.xworkz.common.service.AppPropService;

@Controller
@RequestMapping(value = "/")
public class AppPropController {
	@Autowired
	private AppPropService service;

	private static final Logger LOGGER = Logger.getLogger(AppPropController.class);

	private List<AppPropDTO> seList;
	private List<AppPropDTO> idList;

	@PostConstruct
	public void init() {
		LOGGER.info("invoked init method in\t" + this.getClass().getSimpleName());
		seList = service.fetchAllByType("SE");
		idList = service.fetchAllById("ID");
		LOGGER.info("SELIST: " + seList);
		LOGGER.info("IDLIST: " + idList);

	}

	public AppPropController() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/landing.do")
	public String loadWelcomePage(Model model) {
		try {
			LOGGER.info("invoked loadWelcomePage method in \t " + this.getClass().getSimpleName());
			model.addAttribute("SElist", seList);
			model.addAttribute("IDlist", idList);
			LOGGER.info("SELIST: " + seList);
			LOGGER.info("IDLIST: " + idList);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);

		}
		return "Register";

	}

}
