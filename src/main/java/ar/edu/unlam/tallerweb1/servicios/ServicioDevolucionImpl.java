package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AutoDao;
import ar.edu.unlam.tallerweb1.dao.DevolucionDao;
import ar.edu.unlam.tallerweb1.dao.ReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioDevolucion")
@Transactional
public class ServicioDevolucionImpl implements ServicioDevolucion {
	
	@Inject
	private DevolucionDao devolucionDao;
	
	@Inject
	private ReservaDao reservaDao;
	
	@Inject
	private AutoDao autoDao;
	
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
		
		//TODO: Arreglar precioExtra
		//TODO: Ver que hacer con fechaEntrega
		//Entrega entrega = servicioEntrega.obtenerEntrega(reservaId);
		
		//Date fechaEntrega = entrega.getFechaEntrega();
		Date fechaHasta = reserva.getFechaHasta();
		Date fechaActual = new java.sql.Date(date.getTime());
		
		//TODO: Hacer Por cada dia extra se le cobrara mas monto y no uno fijo solamente
		if(fechaHasta.compareTo(fechaActual)>0 ) {
			//System.out.println("fechaHasta is after fechaActual");
			Double precioExtra= 0D;
			devolucion.setPrecioExtra(precioExtra);
		}else {
			//Precio extra al pasarse la fecha de entrega.
			//System.out.println("fechaHasta is before fechaActual");
			Double precioExtra= 1500D;
			devolucion.setPrecioExtra(precioExtra);
		}

		return devolucionDao.devolverAuto(devolucion);
	}

	@Override
	public Devolucion obtenerDevolucion(Long id) {
		return devolucionDao.obtenerDevolucion(id);
	}
	
	@Override
	public void puntuarAuto(Long id, Long puntos) {
		//Inicializo objetos
		Reserva reserva = reservaDao.obtenerReserva(id);
		Auto auto = reserva.getAuto();
		Double puntajePromedioActual = auto.getPuntajePromedio();
		
		//Seteo puntaje a la reserva
		reserva.setPuntaje(puntos);
		
		//Calculo promedio y seteo al auto de la reserva
		Double puntajeActualizado = puntajePromedioActual + puntos.doubleValue();
		puntajeActualizado = puntajeActualizado / 2.0;
		auto.setPuntajePromedio(puntajeActualizado);
		
		//Guardo objetos actualizados
		reservaDao.actualizarDatosReserva(reserva);
		autoDao.guardarAuto(auto);
		
		return;
	}
}