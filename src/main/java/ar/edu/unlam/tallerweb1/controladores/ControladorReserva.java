package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Busqueda;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFiltros;
import ar.edu.unlam.tallerweb1.servicios.ServicioReserva;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Date;

@Controller
public class ControladorReserva {
	
	@Inject
	private ServicioReserva servicioReserva;
	
	@Inject
	private ServicioFiltros servicioFiltros;
	
	@GetMapping("/reserva-fecha")
	public ModelAndView irAReservaFecha() {
		ModelMap modelo = new ModelMap();
		modelo.put("busqueda", new Busqueda());
		return new ModelAndView("reserva-fecha", modelo);
	}
	
	@PostMapping(path = "/reserva-lista-autos")
	public ModelAndView irAReservaListaAutos(@ModelAttribute("busqueda") Busqueda busqueda ) {

		ModelMap modelo = new ModelMap();
		modelo.put("busqueda", busqueda);
		
		modelo.put("autosDisponibles", servicioReserva.obtenerAutosDisponibles(busqueda.getFechaDesde(), busqueda.getFechaHasta()));
		return new ModelAndView("reserva-lista-autos", modelo);
	}
	
	@GetMapping(path = "/reserva-lista-autos")
	public ModelAndView irAReservaListaAutos(
			@RequestParam("marca") String marca)  {

		ModelMap modelo = new ModelMap();
	
		
		modelo.put("filtroPorMarca",servicioFiltros.filtroPorMarca(marca) );
		return new ModelAndView("reserva-lista-autos", modelo);
		
		
	
	
	}
	
	
	@PostMapping("/reservar-auto")
	public ModelAndView reservarAuto(
			@RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
			@RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta,
			@RequestParam("autoId") Long autoId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		Long reservaId = servicioReserva.reservarAuto(fechaDesde, fechaHasta, autoId);
		
		modelo.put("reservaId", reservaId);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("reserva-resultado", modelo);
	}
	
	
	
}
