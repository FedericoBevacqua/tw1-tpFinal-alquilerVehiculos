package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("reservaDao")
public class ReservaDaoImpl implements ReservaDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Auto> obtenerAutosDisponibles() {
		final Session session = sessionFactory.getCurrentSession();
		List<Auto> resultado;
		resultado = session.createCriteria(Auto.class)
				.add(Restrictions.eq("disponible", true))
				.list();
		return resultado;
	}

	@Override
	public boolean reservarAuto(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		Auto autoAReservar;
		
		autoAReservar = (Auto) session.createCriteria(Auto.class)
				.add(Restrictions.eq("id", reserva.getAuto().getId()))
				.uniqueResult();
		
		if (autoAReservar == null) {
			return false;
		}
		
		autoAReservar.setDisponible(false);
		session.update(autoAReservar);
		
		session.save(reserva);
		return true;
	}

}
