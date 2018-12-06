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
import javax.ws.rs.QueryParam;
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
			@ModelAttribute("busqueda") Busqueda busqueda, //Objeto que contiene fechaDesde y fechaHasta - No se guarda en BD.
			@RequestParam("tipoContrato") String tipoContrato,
			@RequestParam(defaultValue = "false") boolean Ford, //Filtro si es True, entra al IF.
			@RequestParam(defaultValue = "false") boolean Chevrolet,
			@RequestParam(defaultValue = "false") boolean Toyota,
			@RequestParam(defaultValue = "false") boolean menorPrecio,
			@RequestParam(defaultValue = "false") boolean mayorPrecio){
			
			ModelMap modelo = new ModelMap();
			
		//Cada if hace un criteria que trae todos los autos de tales marca o precios
		if (Ford) {
	  
			{modelo.put("autosDisponibles",servicioFiltros.filtroPorMarca("ford"));}
			return new ModelAndView("reserva-lista-autos", modelo);
	    }
		
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
			@RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
			@RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta,
			@RequestParam("tipoContrato") String tipoContrato,
			@RequestParam("autoId") Long autoId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		//Utiliza servicio para reservar auto y guardar en la BD.
		Long reservaId = servicioReserva.reservarAuto(fechaDesde, fechaHasta, autoId, tipoContrato);
		
		modelo.put("reservaId", reservaId);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("reserva-resultado", modelo);
	}
	//Paso anterior al pago en efectivo o mercadoPago
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
	//Paso posterior al pago en efectivo o mercadoPago
	@GetMapping("/procesar-pago")
	public ModelAndView procesarPago(
			@QueryParam("result") String result, //String de mercadoPago success, failure o pending
			@QueryParam("fechaDesde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDesde,
			@QueryParam("fechaHasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaHasta,
			@QueryParam("tipoContrato") String tipoContrato,
			@QueryParam("autoId") Long autoId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);

		//Muestra y valida el resultado de la operacion por mercadoPago
		System.out.print("Resultado de la operacion: " + result);
		if (result == null && fechaDesde == null || fechaHasta == null || tipoContrato == null || autoId == null) {
			return new ModelAndView("redirect:/error-pago");
		}
		//Si lo valida lo de mercado pago o es en efectivo reserva el auto
		Long reservaId = servicioReserva.reservarAuto(fechaDesde, fechaHasta, autoId, tipoContrato);

		modelo.put("reservaId", reservaId);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("reserva-resultado", modelo);
	}
	//Si hay un error en la compra de mercadoPago redirecciona a vista error.
	@GetMapping("error-pago")
	public ModelAndView errorPago() {
		return new ModelAndView("error-pago");
	}
	
}
