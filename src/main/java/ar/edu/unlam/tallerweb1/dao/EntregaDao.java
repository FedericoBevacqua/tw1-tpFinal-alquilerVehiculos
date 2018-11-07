package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Entrega;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface EntregaDao {
	List<Reserva> obtenerReservasPendientes();

	Long entregarAuto(Entrega entrega); 
}
