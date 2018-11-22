package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
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
	
	@Inject
	private ServicioAuto servicioAuto;
	
	@Override
	public List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta) {
		//TODO: Agregar validacion Date
		return reservaDao.obtenerAutosDisponibles(fechaDesde, fechaHasta);
	}

	@Override
	public Long reservarAuto(Date fechaDesde, Date fechaHasta, Long autoId, String tipoContrato) {
		Reserva reserva = new Reserva();
		reserva.setFechaDesde(fechaDesde);
		reserva.setFechaHasta(fechaHasta);
		reserva.setTipoContrato(tipoContrato);
	
		Auto auto = servicioAuto.obtenerAuto(autoId);
		reserva.setAuto(auto);
		
		return reservaDao.reservarAuto(reserva);
	}

	@Override
	public Reserva obtenerReserva(Long id) {
		return reservaDao.obtenerReserva(id);
	}

}