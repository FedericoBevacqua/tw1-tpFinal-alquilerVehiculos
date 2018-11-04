package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Repository("reservaDao")
public class ReservaDaoImpl implements ReservaDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta) {
		final Session session = sessionFactory.getCurrentSession();
		
		List<Reserva> reservas = session.createCriteria(Reserva.class)
				.add(Restrictions.between("fechaDesde", fechaDesde, fechaHasta))
				.add(Restrictions.between("fechaHasta", fechaDesde, fechaHasta))
				.list();
		
//		List<Reserva> reservas = session.createCriteria(Reserva.class)
//				.add(Restrictions.ge("fechaDesde", fechaDesde))
//				.add(Restrictions.le("fechaHasta", fechaHasta))
//				.list();
		
		List<Auto> autosReservados = reservas.stream()
							.map(r -> r.getAuto())
							.collect(Collectors.toList());
		
		List<Auto> autos = session.createCriteria(Auto.class)
							.list();
		
		List<Auto> autosDisponibles = autos.stream()
				.filter(a -> !autosReservados.contains(a))
				.collect(Collectors.toList());
		
		return autosDisponibles;
	}

	@Override
	public Long reservarAuto(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		reserva.setId(null);
		return (Long) session.save(reserva);
	}

}
