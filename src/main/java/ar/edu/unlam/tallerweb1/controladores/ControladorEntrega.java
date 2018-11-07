package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEntrega;

@Controller
public class ControladorEntrega {
	
	@Inject
	private ServicioEntrega servicioEntrega;
	
	@GetMapping("/entrega-lista-autos")
	public ModelAndView irAEntregaListaAutos() {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("listaReservasPendientes", servicioEntrega.obtenerReservasPendientes());
		
		return new ModelAndView("entrega-lista-autos", modelo);
	}
	
	@PostMapping("/entregar-auto")
	public ModelAndView reservarAuto(
			@RequestParam("reservaId") Long reservaId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		
		modelo.put("usuario", usuario);
		
		Long entregaId = servicioEntrega.entregarAuto(reservaId);
		
		modelo.put("entregaId", entregaId);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("entrega-resultado", modelo);
	}
}
