package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface ServicioAuto {
	Auto obtenerAuto(Long id);

	Auto actualizarPuntajePromedio(Long id, Double puntajeActual);
}
