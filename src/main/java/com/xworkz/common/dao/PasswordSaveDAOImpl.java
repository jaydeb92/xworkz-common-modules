package com.xworkz.common.dao;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordSaveDAOImpl implements PasswordSaveDAO {
	@Autowired
	private SessionFactory factory;
	private static final Logger LOGGER = Logger.getLogger(PasswordSaveDAOImpl.class);

	public PasswordSaveDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public Integer savePassword(String email, String password) {
		Session session = null;
		try {
			LOGGER.info("start: savePassword method in PasswordSaveDAOImpl class\t" + email + " " + password);
			session = factory.openSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("update temple_reg_personal_info_table set PASSWORD=:Password where EMAIL=:Email");
			sqlQuery.setParameter("Email", email);
			sqlQuery.setParameter("Password", password);
			LOGGER.info("Query of fetchCountByEmail:  " + sqlQuery);
			Integer result = sqlQuery.executeUpdate();
			LOGGER.info("result: " + result);
			return result;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}
		return null;
	}

}
