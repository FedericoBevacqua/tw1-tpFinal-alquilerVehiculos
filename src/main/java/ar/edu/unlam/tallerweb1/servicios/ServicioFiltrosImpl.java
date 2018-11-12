package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FiltrosDao;
import ar.edu.unlam.tallerweb1.modelo.Auto;

@Service("serviciosFiltros")
@Transactional
public class ServicioFiltrosImpl implements ServicioFiltros {

	
	@Inject
	private FiltrosDao filtrosDao;
	@Override
	public List<Auto> filtroPorMarca(String marca) {
		// TODO Auto-generated method stub
		return filtrosDao.filtroPorMarca(marca);
	}

}
