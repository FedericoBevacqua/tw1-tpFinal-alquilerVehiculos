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
	public ModelAndView irAReservaListaAutos(
			@ModelAttribute("busqueda") Busqueda busqueda,
			@RequestParam("tipoContrato") String tipoContrato,
			@RequestParam(defaultValue = "false") boolean Ford,
			@RequestParam(defaultValue = "false") boolean Chevrolet,
			@RequestParam(defaultValue = "false") boolean Toyota,
			@RequestParam(defaultValue = "false") boolean menorPrecio,
			@RequestParam(defaultValue = "false") boolean mayorPrecio){
			
			ModelMap modelo = new ModelMap();
		/*if (Ford) {
	  
			{modelo.put("autosDisponibles",servicioFiltros.filtroPorMarca("ford"));}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }*/
		
		if (Chevrolet) {
	    
			{modelo.put("autosDisponibles",servicioFiltros.filtroPorMarca("chevrolet"));}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }
		
		if (Toyota) {
	      
			{modelo.put("autosDisponibles",servicioFiltros.filtroPorMarca("toyota"));}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }
		
		if (menorPrecio) {
	    
			{modelo.put("autosDisponibles", servicioFiltros.OrdenarPorMenorPrecio());}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }
		
		if (mayorPrecio) {
		    
			{modelo.put("autosDisponibles", servicioFiltros.OrdenarPorMayorPrecio());}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }
	
		modelo.put("busqueda", busqueda);
		
		modelo.put("tipoContrato", tipoContrato);
		
		modelo.put("autosDisponibles", servicioReserva.obtenerAutosDisponibles(busqueda.getFechaDesde(), busqueda.getFechaHasta()));
		return new ModelAndView("reserva-lista-autos", modelo);
	}

	@PostMapping("/reservar-auto")
	public ModelAndView reservarAuto(
			@RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
			@RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta,
			@RequestParam("tipoContrato") String tipoContrato,
			@RequestParam("autoId") Long autoId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		Long reservaId = servicioReserva.reservarAuto(fechaDesde, fechaHasta, autoId, tipoContrato);
		
		modelo.put("reservaId", reservaId);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("reserva-resultado", modelo);
	}

	@PostMapping("/reserva-pagar")
	public ModelAndView reservaPagar(
			@RequestParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
			@RequestParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta,
			@RequestParam("tipoContrato") String tipoContrato,
			@RequestParam("importe") Double importe,
			@RequestParam("autoId") Long autoId) {

		ModelMap modelo = new ModelMap();

		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);

		modelo.put("importe", importe);
		modelo.put("fechaDesde", fechaDesde);
		modelo.put("fechaHasta", fechaHasta);
		modelo.put("tipoContrato", tipoContrato);
		modelo.put("autoId", autoId);

		return new ModelAndView("reserva-pagar", modelo);
	}
	
}
