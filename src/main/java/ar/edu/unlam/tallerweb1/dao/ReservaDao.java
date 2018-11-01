package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ReservaDao {
	List<Auto> obtenerAutosDisponibles();
	
	boolean reservarAuto(Reserva reserva);
}
