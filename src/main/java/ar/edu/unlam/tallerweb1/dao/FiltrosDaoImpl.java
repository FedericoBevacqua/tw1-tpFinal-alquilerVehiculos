package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;
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

	@Override
	public List<Auto> OrdenarPorMenorPrecio() {
		final Session session = sessionFactory.getCurrentSession();
		List<Auto> menorPrecio=session.createCriteria(Auto.class)
				.addOrder(Order.asc("precio"))
				.list();
		return menorPrecio ;
	}

	@Override
	public List<Auto> OrdenarPorMayorPrecio() {
		final Session session = sessionFactory.getCurrentSession();
		List<Auto> mayorPrecio=session.createCriteria(Auto.class)
				.addOrder(Order.desc("precio"))
				.list();
		return mayorPrecio ;
	}

}
