package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorLoginTest {

	@Test
	public void siUsuarioNoExisteDeberiaRedirigirAlLoginYMostrarError() {
		
		//Preparacion
		ControladorLogin sut = new ControladorLogin();
		Usuario usuarioMock = mock(Usuario.class);
		ServicioLogin servicioMock = mock(ServicioLogin.class);
		when(servicioMock.consultarUsuario(any(Usuario.class))).thenReturn(null);
		sut.setServicioLogin(servicioMock);

		//Ejecucion
		ModelAndView mav = sut.validarLogin(usuarioMock, null);
		
		//Validacion
		assertThat(mav.getViewName()).isEqualTo("login");
		assertThat(mav.getModel().get("error")).isEqualTo("Usuario o clave incorrecta");
	}
	
	@Test
	public void siUsuarioExisteDeberiaRedirigirAlHomeYAsignarRolCorrespondiente() {
		
		//Preparacion
		ControladorLogin sut = new ControladorLogin();
		Usuario usuarioMock = mock(Usuario.class);
		ServicioLogin servicioMock = mock(ServicioLogin.class);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		when(usuarioMock.getRol()).thenReturn("ADMIN");
		sut.setServicioLogin(servicioMock);
		
		//Ejecucion
		ModelAndView mav = sut.validarLogin(usuarioMock, requestMock);
		
		//Validacion
		assertThat(mav.getViewName()).isEqualTo("redirect:/home");
		assertThat(usuarioMock.getRol()).isEqualTo("ADMIN");
		
		//Verificar que metodo consultarUsuario se consulto 1 vez
		verify(servicioMock, times(1)).consultarUsuario(usuarioMock);
	}
}