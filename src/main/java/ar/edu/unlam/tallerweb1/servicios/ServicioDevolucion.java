package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


public interface ServicioDevolucion {
	List<Reserva> obtenerReservasEntregadas();
	
	Long devolverAuto(Long devolucionId, Long kilometrajeDevolucion); 
	
	Devolucion obtenerDevolucion(Long id);
}
