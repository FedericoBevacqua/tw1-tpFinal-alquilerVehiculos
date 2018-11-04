package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;

@Repository("autoDao")
public class AutoDaoImpl implements AutoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Auto obtenerAuto(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Auto) session.createCriteria(Auto.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
