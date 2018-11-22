package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {
	List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta);

	Long reservarAuto(Date fechaDesde, Date fechaHasta, Long autoId,String tipoContrato);
	
	Reserva obtenerReserva(Long id);

}
