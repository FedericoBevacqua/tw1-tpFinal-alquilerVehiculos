package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface AutoDao {
	Auto obtenerAuto(Long id);

	void guardarNuevoAuto(Auto auto);

	void guardarAuto(Auto auto);
}
