package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AutoDao;
import ar.edu.unlam.tallerweb1.modelo.Auto;

@Service("servicioAuto")
@Transactional
public class ServicioAutoImpl implements ServicioAuto {

	@Inject
	private AutoDao autoDao;

	@Override
	public Auto obtenerAuto(Long id) {
		return autoDao.obtenerAuto(id);
	}
	
	@Override
	public Auto actualizarPuntajePromedio(Long id, Double puntajeActual) {
		Auto auto = autoDao.obtenerAuto(id);
		
		auto.setPuntajePromedio(puntajeActual);
		
		return auto;
	}

}