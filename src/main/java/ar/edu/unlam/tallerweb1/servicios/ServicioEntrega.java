package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Entrega;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


public interface ServicioEntrega {
	List<Reserva> obtenerReservasPendientes();
	
	Long entregarAuto(Long reservaId); 
	
	Entrega obtenerEntrega(Long reservaId);
}
