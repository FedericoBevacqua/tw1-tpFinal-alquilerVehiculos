package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Entrega;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Repository("devolucionDao")
public class DevolucionDaoImpl implements DevolucionDao {

    @Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Reserva> obtenerReservasEntregadas() {
		
		 final Session session = sessionFactory.getCurrentSession();
		 
        DetachedCriteria devolucionesRealizadas = DetachedCriteria.forClass(Devolucion.class)
                .setProjection(Projections.property("reserva"));

        List<Reserva> listaEntregasRealizadas = session
                .createCriteria(Entrega.class)
                .add(Property.forName("id").notIn(devolucionesRealizadas))
                
                .list();
		 
		return listaEntregasRealizadas;
	}

	@Override
	public Long devolverAuto(Devolucion devolucion) {
		
		final Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(devolucion);
	}
}
