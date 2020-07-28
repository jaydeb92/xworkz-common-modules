package com.xworkz.common.service;

import java.util.ArrayList;
import java.util.LinkedList;
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
			LOGGER.info("invoked fetchAllByType method in \t" + this.getClass().getSimpleName() + type);
			List<AppPropEntity> fetchEntities = appPropDAO.fetchAllByType(type);
			LOGGER.info("fetchEntities\t" + fetchEntities);

			if (Objects.nonNull(fetchEntities)) {

				LOGGER.info("fetchEntities not null can fetch properties.." + type);

				List<AppPropDTO> listDTO = new LinkedList<AppPropDTO>();

				for (AppPropEntity fetchEntities1 : fetchEntities) {

					AppPropDTO dto = new AppPropDTO();
					LOGGER.info("created AppPropDTO object");
					LOGGER.info("copying data from entity to dto");
					BeanUtils.copyProperties(fetchEntities1, dto);
					listDTO.add(dto);
					LOGGER.info("listDTO\t" + listDTO);
				}

				/*
				 * fetchEntities.forEach(e -> { AppPropDTO dto = new
				 * AppPropDTO(); LOGGER.info("created AppPropDTO object");
				 * LOGGER.info("copying data from entity to dto");
				 * BeanUtils.copyProperties(dto, fetchEntities);
				 * listDTO.add(dto); LOGGER.info("listDTO\t" + listDTO);
				 * 
				 * });
				 */
				return listDTO;
			} else {
				LOGGER.info("fetchEntities  null can not fetch properties.." + type);
				return null;

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return null;
	}

	public List<AppPropDTO> fetchAllById(String id) {
		try {
			LOGGER.info("invoked fetchAllByType method in \t" + this.getClass().getSimpleName() + id);
			List<AppPropEntity> fetchEntities = appPropDAO.fetchAllByType(id);
			LOGGER.info("fetchEntities\t" + fetchEntities);

			if (Objects.nonNull(fetchEntities)) {

				LOGGER.info("fetchEntities not null can fetch properties.." + id);

				List<AppPropDTO> listDTO = new ArrayList<AppPropDTO>();

				for (AppPropEntity fetchEntities1 : fetchEntities) {

					AppPropDTO dto = new AppPropDTO();
					LOGGER.info("created AppPropDTO object");
					LOGGER.info("copying data from entity to dto");
					BeanUtils.copyProperties(fetchEntities1, dto);
					listDTO.add(dto);
					LOGGER.info("listDTO\t" + listDTO);
				}

				/*
				 * fetchEntities.forEach(e -> { AppPropDTO dto = new
				 * AppPropDTO(); LOGGER.info("created AppPropDTO object");
				 * LOGGER.info("copying data from entity to dto");
				 * BeanUtils.copyProperties(fetchEntities, dto);
				 * listDTO.add(dto); LOGGER.info("listDTO\t" + listDTO); });
				 */
				return listDTO;
			} else {
				LOGGER.info("fetchEntities  null can not fetch properties.." + id);
				return null;

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

}
