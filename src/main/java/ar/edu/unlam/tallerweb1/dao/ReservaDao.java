package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {
	Long reservarAuto(Reserva reserva);
	 Double precioActualizado(Double precio,Boolean seguro,Boolean chofer,Boolean tanque);
	List<Auto> obtenerAutosDisponibles(Date fechaDesde, Date fechaHasta);
}
