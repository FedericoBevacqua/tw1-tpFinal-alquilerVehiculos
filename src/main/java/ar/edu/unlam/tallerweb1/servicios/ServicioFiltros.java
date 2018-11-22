package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface ServicioFiltros {
	
	List<Auto> filtroPorMarca(String marca);
	List<Auto> OrdenarPorMenorPrecio();
	List<Auto> OrdenarPorMayorPrecio();
}
