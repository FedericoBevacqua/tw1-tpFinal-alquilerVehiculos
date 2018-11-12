package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {
	List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta);
	
	Long reservarAuto(Reserva reserva);
	
	Reserva obtenerReserva(Long id);

}
