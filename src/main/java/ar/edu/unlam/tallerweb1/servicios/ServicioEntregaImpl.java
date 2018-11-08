package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EntregaDao;
import ar.edu.unlam.tallerweb1.modelo.Entrega;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioEntrega")
@Transactional
public class ServicioEntregaImpl implements ServicioEntrega {
	
	@Inject
	private EntregaDao entregaDao;
	
	@Inject
	private ServicioReserva servicioReserva;

	@Override
	public List<Reserva> obtenerReservasPendientes() {
		return entregaDao.obtenerReservasPendientes();
	}
	
	@Override
	public Long entregarAuto(Long reservaId) {
		Entrega entrega = new Entrega();
		
		Date date = new Date();
		entrega.setFechaEntrega(new java.sql.Date(date.getTime()));
		
		Reserva reserva = servicioReserva.obtenerReserva(reservaId);
		entrega.setReserva(reserva);
		
		return entregaDao.entregarAuto(entrega);
	}

	@Override
	public Entrega obtenerEntrega(Long reservaId) {
		return entregaDao.obtenerEntrega(reservaId);
	}
}