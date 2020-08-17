package com.xworkz.common.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.common.entity.VisitingInfoEntity;
@Repository
public class RevisitDAOImpl implements RevisitDAO {
	@Autowired
	private SessionFactory factory;
	private static final Logger LOGGER = Logger.getLogger(RevisitDAOImpl.class);

	public RevisitDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public void saveVisitinfInfo(VisitingInfoEntity visitingInfoEntity, int id) {
		Session session = null;
		try {
			LOGGER.info("invoked saveVisitinfInfo method in RevisitDAOImpl class");
			session = factory.openSession();
			visitingInfoEntity.setId(id);
			session.beginTransaction().begin();
			session.save(visitingInfoEntity);
			session.getTransaction().commit();
			LOGGER.info("visitingInfoEntity saved");

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}

	}

}
