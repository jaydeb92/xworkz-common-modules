package com.xworkz.common.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.common.entity.PersonalInfoEntity;

@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO {
	private static final Logger LOGGER = Logger.getLogger(PersonalInfoDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public PersonalInfoDAOImpl() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	@Override
	public void savePersonalInfoEntity(PersonalInfoEntity entity) {
		Session session = null;
		try {
			LOGGER.info("start: savePersonalInfoEntity method in PersonalInfoDAOImpl class\t");
			session = factory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			LOGGER.info("PersonalInfoEntity saved");
			LOGGER.info("end: savePersonalInfoEntity method in PersonalInfoDAOImpl class\t" + entity);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("session closed");
		}

	}

	@Override
	public Long fetchCountByEmail(String email) {
		Session session = null;
		try {
			LOGGER.info("start: fetchCountByEmail method in PersonalInfoDAOImpl class\t" + email);
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchCountByEmail");
			Query query2 = query.setParameter("Email", email);
			LOGGER.info("Query of fetchCountByEmail:  " + query2);
			Long result = (Long) query.uniqueResult();
			return result;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("closed session in fetchCountByEmail in PersonalInfoDAOImpl class");
		}
		return (long) 0;
	}

	@Override
	public Long fetchCountByMobileNo(Long mobileNo) {
		Session session = null;
		try {
			LOGGER.info("start: fetchCountByEmail method in PersonalInfoDAOImpl class\t" + mobileNo);
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchCountByMobileNo");
			Query query2 = query.setParameter("MobileNO", mobileNo);
			LOGGER.info("Query of fetchCountByEmail:  " + query2);
			Long result = (Long) query.uniqueResult();
			return result;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("closed session in fetchCountByMobileNo in PersonalInfoDAOImpl class");
		}
		return (long) 0;
	}

	@Override
	public PersonalInfoEntity fetchPersonalInfoEntityByEmail(String email) {
		Session session = null;
		try {
			LOGGER.info("start: fetchPersonalInfoEntityByEmail method in PersonalInfoDAOImpl class\t" + email);
			session = factory.openSession();
			Query query = session.getNamedQuery("fetchPersonalInfoEntityByEmail");
			Query query2 = query.setParameter("Email", email);
			LOGGER.info("Query of fetchPersonalInfoEntityByEmail:  " + query2);
			PersonalInfoEntity personalInfoEntity = (PersonalInfoEntity) query.uniqueResult();
			LOGGER.info("personalInfoEntity:  " + personalInfoEntity);
			// VisitingInfoEntity visitingInfoEntity =
			// personalInfoEntity.getVisitingInfoEntity();
			// LOGGER.info("visitingInfoEntity: " + visitingInfoEntity);
			return personalInfoEntity;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			session.close();
			LOGGER.info("closed session in fetchPersonalInfoEntityByEmail in PersonalInfoDAOImpl class");
		}
		return null;
	}

}
