package com.xworkz.common.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.PersonalInfoDAO;
import com.xworkz.common.dto.TempleRegistrationDTO;
import com.xworkz.common.entity.PersonalInfoEntity;
import com.xworkz.common.entity.VisitingInfoEntity;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
	@Autowired
	private PersonalInfoDAO personalInfoDAO;
	@Autowired
	private MailService mailService;

	private static final Logger LOGGER = Logger.getLogger(PersonalInfoServiceImpl.class);

	public PersonalInfoServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public String saveAndValidatePersonalInfoEntity(TempleRegistrationDTO dto) {
		try {

			LOGGER.info("start:saveAndValidatePersonalInfoEntity method in PersonalInfoServiceImpl class" + dto);
			if (Objects.nonNull(dto)) {
				LOGGER.info("PersonalInfoEntity not null can save.");
				PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();

				VisitingInfoEntity visitingInfoEntity = new VisitingInfoEntity();

				LOGGER.info("copying data from registrationDTO to personalInfoEntity");

				BeanUtils.copyProperties(dto, personalInfoEntity);

				BeanUtils.copyProperties(dto, visitingInfoEntity);

				personalInfoEntity.setVisitingInfoEntity(visitingInfoEntity);

				visitingInfoEntity.setPersonalInfoEntity(personalInfoEntity);
				LOGGER.info("PersonalInfoEntity Value: " + personalInfoEntity);

				// validating email & mobile no..

				Long emailCount = personalInfoDAO.fetchCountByEmail(dto.getEmail());
				Long mobileNoCount = personalInfoDAO.fetchCountByMobileNo(dto.getMobileNo());

				LOGGER.info("No. of emailCount " + emailCount);
				LOGGER.info("No. of mobileNoCount " + mobileNoCount);

				if (emailCount == 0 && mobileNoCount == 0) {

					personalInfoDAO.savePersonalInfoEntity(personalInfoEntity);
					try {
						mailService.sendMail(dto);
						LOGGER.info("mail sent successfully.");
					} catch (Exception e) {
						LOGGER.error(e.getMessage(), e);
					}

					return "Registration Successfull..";

				} else {
					return "Email or Mobile No already exists..";

				}

			} else {
				LOGGER.info("PersonalInfoEntity is null can not save.");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;

	}

	@Override
	public String validateAndfetchPersonalInfoEntityByEmail(String email) {
		try {
			LOGGER.info(" invoked validateAndfetchPersonalInfoEntityByEmail method" + email);

			if (email != null) {
				PersonalInfoEntity personalInfoEntity = personalInfoDAO.fetchPersonalInfoEntityByEmail(email);
				LOGGER.info("personalInfoEntity: " + personalInfoEntity);
				if (personalInfoEntity != null) {
					TempleRegistrationDTO registrationDTO = new TempleRegistrationDTO();
					BeanUtils.copyProperties(personalInfoEntity, registrationDTO);
					VisitingInfoEntity visitingInfoEntity = personalInfoEntity.getVisitingInfoEntity();
					LOGGER.info("visitingInfoEntity: " + visitingInfoEntity);
					BeanUtils.copyProperties(visitingInfoEntity, registrationDTO);
					try {
						mailService.sendMail(registrationDTO);
						LOGGER.info("mail sent successfully.");

					} catch (Exception e) {
						LOGGER.error(e.getMessage(), e);
					}

					return "Details has been sent..";
				} else {
					return "Email id not in registered..";
				}

			} else {
				LOGGER.info("Email id is null");
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
