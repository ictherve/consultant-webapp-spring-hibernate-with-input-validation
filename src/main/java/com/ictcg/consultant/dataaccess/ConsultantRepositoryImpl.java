package com.ictcg.consultant.dataaccess;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ConsultantRepositoryImpl implements ConsultantRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ConsultantEntity> findAll() {
		return getCurrentSession().createQuery("from ConsultantEntity").getResultList();
	}

	@Override
	public ConsultantEntity findById(Integer id) {
		return getCurrentSession().get(ConsultantEntity.class, id);
	}

	@Override
	public void save(ConsultantEntity customerEntity) {
		getCurrentSession().saveOrUpdate(customerEntity);
	}

	@Override
	public void delete(ConsultantEntity consultantEntity) {
		getCurrentSession().delete(consultantEntity);
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
