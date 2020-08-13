package com.xworkz.common.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.common.entity.PersonalInfoEntity;

@Repository
public class LoginCountDAOImpl implements LoginCountDAO {
	@Autowired
	private SessionFactory factory;
	private static final Logger LOGGER = Logger.getLogger(LoginCountDAOImpl.class);

	public LoginCountDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public void loginCountUpdate(PersonalInfoEntity entity, int count) {
		Session session = null;
		try {
			LOGGER.info("start: loginCountUpdate method in LoginCountDAOImpl class\t" + entity);
			session = factory.openSession();
			session.beginTransaction().begin();
			entity.setLoginCount(count);
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
			LOGGER.info("PersonalInfoEntity updated");

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}

	}

	@Override
	public void disableAccountUpdate(PersonalInfoEntity entity, boolean isLock) {
		Session session = null;
		try {
			LOGGER.info("start: disableAccountUpdate method in LoginCountDAOImpl class\t" + entity);
			session = factory.openSession();
			session.beginTransaction().begin();
			entity.setIsLock(isLock);
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
			LOGGER.info("PersonalInfoEntity updated");

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}

	}

}
