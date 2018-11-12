package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;

@Repository("filtroDao")
public class FiltrosDaoImpl implements FiltrosDao{
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Auto> filtroPorMarca(String marca) {
		final Session session = sessionFactory.getCurrentSession();
		
		
		List<Auto> autosPorMarca=session.createCriteria(Auto.class)
				.add(Restrictions.eq("marca",marca))
				.list();
		return autosPorMarca ;
	}



}
