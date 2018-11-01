package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("servicioReserva")
@Transactional
public class ServicioReservaImpl implements ServicioReserva {

	@Inject
	private ReservaDao reservaDao;
	
	@Override
	public List<Auto> obtenerAutosDisponibles() {
		return reservaDao.obtenerAutosDisponibles();
	}

	@Override
	public boolean reservarAuto(Reserva reserva) {
		return reservaDao.reservarAuto(reserva);
	}

}
