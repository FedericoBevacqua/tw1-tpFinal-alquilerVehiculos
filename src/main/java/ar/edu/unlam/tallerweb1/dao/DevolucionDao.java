package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface DevolucionDao {
	List<Reserva> obtenerReservasEntregadas();

	Long devolverAuto(Devolucion devolucion); 
}
