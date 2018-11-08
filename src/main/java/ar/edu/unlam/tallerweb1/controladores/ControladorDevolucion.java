package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Devolucion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioDevolucion;

@Controller
public class ControladorDevolucion {
	
	@Inject
	private ServicioDevolucion servicioDevolucion;
	
	@GetMapping("/devolucion-lista-reservas")
	public ModelAndView irAEntregaListaAutos() {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("listaReservasEntregadas", servicioDevolucion.obtenerReservasEntregadas());
		
		return new ModelAndView("devolucion-lista-reservas", modelo);
	}
	
	@PostMapping("/devolver-auto")
	public ModelAndView devolverAuto(
			@RequestParam("reservaId") Long reservaId) {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		//TODO: Corregir cuando este correcto el login
		Usuario usuario = new Usuario();
		
		modelo.put("usuario", usuario);
		
		Long devolucionId = servicioDevolucion.devolverAuto(reservaId);
		
		//TODO: Verificar Obtener precioExtra Devolucion
		Devolucion devolucion = servicioDevolucion.obtenerDevolucion(devolucionId);
		Double precioExtra = devolucion.getPrecioExtra();
		
		
		modelo.put("devolucionId", devolucionId);
		
		modelo.put("precioExtra",precioExtra);
		
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("devolucion-resultado", modelo);
	}
}
