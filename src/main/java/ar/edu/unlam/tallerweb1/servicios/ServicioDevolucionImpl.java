package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.DevolucionDao;
import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioDevolucion")
@Transactional
public class ServicioDevolucionImpl implements ServicioDevolucion {
	
	@Inject
	private DevolucionDao devolucionDao;
	
	@Inject
	private ServicioReserva servicioReserva;

	@Override
	public List<Reserva> obtenerReservasEntregadas() {
		return devolucionDao.obtenerReservasEntregadas();
	}
	
	@Override
	public Long devolverAuto(Long reservaId) {
		Devolucion devolucion = new Devolucion();
		
		Date date = new Date();
		devolucion.setFechaDevolucion(new java.sql.Date(date.getTime()));
		
		Reserva reserva = servicioReserva.obtenerReserva(reservaId);
		devolucion.setReserva(reserva);
		
		return devolucionDao.devolverAuto(devolucion);
	}
}