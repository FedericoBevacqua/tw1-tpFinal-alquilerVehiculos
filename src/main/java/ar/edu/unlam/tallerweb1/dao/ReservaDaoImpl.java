package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Repository("reservaDao")
public class ReservaDaoImpl implements ReservaDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta) {
        final Session session = sessionFactory.getCurrentSession();

        DetachedCriteria autosReservados = DetachedCriteria.forClass(Reserva.class)//Trae todas las Reservas
                .add(Restrictions.or(
                        Restrictions.between("fechaDesde", fechaDesde, fechaHasta),
                        Restrictions.between("fechaHasta", fechaDesde, fechaHasta)
                ))//Filtra: Trae reservas solo entre esas fechas pedidas
                .setProjection(Projections.property("auto")); //Solo se queda con el atributo auto (id) de reserva

        List<Auto> autosDisponibles = session
                .createCriteria(Auto.class)
                .add(Property.forName("id").notIn(autosReservados))//Trae todos los autos y filtra que no esten en una reserva de las fechas pedidas anteriormente
                .list();

        return autosDisponibles;
    }

    @Override
    public Long reservarAuto(Reserva reserva) {
        final Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(reserva);
    }
    
    //En principio, uso este metodo para agregar el puntaje de la reserva, pero puede tener otros usos
    @Override
    public void actualizarDatosReserva(Reserva reserva) {
    	final Session session = sessionFactory.getCurrentSession();
    	session.update(reserva);
    }

	@Override
	public Reserva obtenerReserva(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Reserva) session.createCriteria(Reserva.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
