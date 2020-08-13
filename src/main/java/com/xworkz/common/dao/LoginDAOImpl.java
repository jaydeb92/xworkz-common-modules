package com.xworkz.common.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.common.entity.PersonalInfoEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory factory;
	private static final Logger LOGGER = Logger.getLogger(LoginDAOImpl.class);

	public LoginDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public Long checkMailExistingForgeneratePassword(String email) {
		Session session = null;
		try {
			LOGGER.info("invoked checkMailExistingForgeneratePassword in LoginDAOImpl class ");
			session = factory.openSession();
			Query query = session.getNamedQuery("checkMailExistingForgeneratePassword");
			query.setParameter("Email", email);
			Long countEmail = (Long) query.uniqueResult();
			LOGGER.info("countEmail: " + countEmail);
			return countEmail;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}
		return null;
	}

	@Override
	public PersonalInfoEntity fetchEntityByEmail(String email) {
		Session session = null;
		try {
			LOGGER.info("invoked fetchEntityByEmail in LoginDAOImpl class ");
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchEntityByEmail");
			query.setParameter("Email", email);
			PersonalInfoEntity entity = (PersonalInfoEntity) query.uniqueResult();
			LOGGER.info("PersonalInfoEntity: " + entity);
			return entity;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}
		return null;
	}

}
