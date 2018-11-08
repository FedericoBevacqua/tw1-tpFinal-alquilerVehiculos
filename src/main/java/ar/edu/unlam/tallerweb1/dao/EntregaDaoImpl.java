package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Entrega;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("entregaDao")
public class EntregaDaoImpl implements EntregaDao {

    @Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Reserva> obtenerReservasPendientes() {
		
		 final Session session = sessionFactory.getCurrentSession();
		
//		 List<Reserva> listaReservasPendientes = session
//				 .createCriteria(Reserva.class)
//				 .createAlias("entrega", "E", JoinType.LEFT_OUTER_JOIN)
//				 .add(Restrictions.isNull("E.id"))
//				 .list();
		 
        DetachedCriteria entregasRealizadas = DetachedCriteria.forClass(Entrega.class)
                .setProjection(Projections.property("reserva"));

        List<Reserva> listaReservasPendientes = session
                .createCriteria(Reserva.class)
                .add(Property.forName("id").notIn(entregasRealizadas))
                .list();
		 
		return listaReservasPendientes;
	}

	@Override
	public Long entregarAuto(Entrega entrega) {
		
		final Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(entrega);
	}

	@Override
	public Entrega obtenerEntrega(Long reservaId) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Entrega) session.createCriteria(Entrega.class)
				.add(Restrictions.eq("id",reservaId))
				.uniqueResult(); 
	}
}
