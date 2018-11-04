package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {
	
	// Escucha la URL /home por GET, y redirige a una vista.
	@GetMapping(path = "/home")
	public ModelAndView irAHome() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("home", modelo);
	}

}
