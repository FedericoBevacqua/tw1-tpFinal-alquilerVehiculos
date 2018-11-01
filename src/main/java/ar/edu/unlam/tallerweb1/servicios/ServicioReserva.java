package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface ServicioReserva {
	List<Auto> obtenerAutosDisponibles();
	
	boolean reservarAuto(Reserva reserva);
}
