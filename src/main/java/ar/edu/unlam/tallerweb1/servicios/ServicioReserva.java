package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface ServicioReserva {
	List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta);
	 Double precioActualizado(Double precio,Boolean seguro,Boolean chofer,Boolean tanque);
	Long reservarAuto(Date fechaDesde, Date fechaHasta, Long autoId);
}
