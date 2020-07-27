package com.xworkz.common.service;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.common.dao.AppPropDAO;
import com.xworkz.common.dto.AppPropDTO;
import com.xworkz.common.entity.AppPropEntity;

@Service
public class AppPropServiceImpl implements AppPropService {

	private static final Logger LOGGER = Logger.getLogger(AppPropServiceImpl.class);
	@Autowired
	private AppPropDAO appPropDAO;

	public AppPropServiceImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());

	}

	public List<AppPropDTO> fetchAllByType(String type) {
		try {
			if (Objects.nonNull(type)) {
				LOGGER.info("invoked fetchAllByType method in \t" + this.getClass().getSimpleName());
				LOGGER.info("type not null can fetch properties.." + type);
				AppPropEntity entity = new AppPropEntity();
				LOGGER.info("created AppPropEntity object");
				AppPropDTO dto = new AppPropDTO();
				LOGGER.info("created AppPropDTO object");
				LOGGER.info("copying data from entity to dto");
				BeanUtils.copyProperties(entity, dto);
				List<AppPropEntity> entities = appPropDAO.fetchAllByType(type);
				//return (List<AppPropDTO>) dto;

			} else {
				LOGGER.info("type  null can not fetch properties.." + type);

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return null;
	}

	public List<AppPropDTO> fetchAllById(String id) {
		try {
			if (Objects.nonNull(id)) {
				LOGGER.info("invoked fetchAllById method in \t" + this.getClass().getSimpleName());
				LOGGER.info("type not null can fetch properties.." + id);
				AppPropEntity entity = new AppPropEntity();
				LOGGER.info("created AppPropEntity object");
				AppPropDTO dto = new AppPropDTO();
				LOGGER.info("created AppPropDTO object");
				LOGGER.info("copying data from entity to dto");
				BeanUtils.copyProperties(entity, dto);
				List<AppPropEntity> entities = appPropDAO.fetchAllById(id);
				//return (List<AppPropDTO>) dto;

			} else {
				LOGGER.info("type  null can not fetch properties.." + id);

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
