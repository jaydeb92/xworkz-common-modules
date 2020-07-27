package com.xworkz.common.dao;

import java.util.List;

import org.hibernate.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.common.entity.AppPropEntity;

@Repository
public class AppPropDAOImpl implements AppPropDAO {

	private static final Logger LOGGER = Logger.getLogger(AppPropDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public AppPropDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());

	}

	public List<AppPropEntity> fetchAllByType(String type) {
		Session session = null;
		try {
			LOGGER.info("invoked fetchAllByType method in\t" + this.getClass().getSimpleName());
			LOGGER.info("creating Session object");
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchAllByType");
			Query query2 = query.setParameter("types", type);
			LOGGER.info("Query\t" + query2);
			List<AppPropEntity> entities = query.list();
			LOGGER.info("END: fetchAllByType in AppPropDAOImpl " + entities);
			return entities;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}
		return null;
	}

	public List<AppPropEntity> fetchAllById(String id) {

		Session session = null;
		try {
			LOGGER.info("invoked fetchAllById method in\t" + this.getClass().getSimpleName());
			LOGGER.info("creating Session object");
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchAllById");
			Query query2 = query.setParameter("ids", id);
			LOGGER.info("Query\t" + query2);
			List<AppPropEntity> entities = query.list();
			LOGGER.info("END: fetchAllByType in AppPropDAOImpl " + entities);
			return entities;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}
		return null;
	}

}
