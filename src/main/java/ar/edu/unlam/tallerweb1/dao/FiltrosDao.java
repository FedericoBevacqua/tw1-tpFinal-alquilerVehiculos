package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface FiltrosDao {
	
	List<Auto> filtroPorMarca(String marca);
}
