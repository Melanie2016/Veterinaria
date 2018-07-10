package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class TestMockitoUsuario {
	
	@Mock
	private Usuario cliente;
	
	@Test
    public void consultarUsuarioExistente () {
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuarioPrueba = mock(Usuario.class);
		HttpServletRequest req = mock(HttpServletRequest.class);
	
		ServicioLogin servicioLogin = mock(ServicioLogin.class);
		
		HttpSession sessionMock = mock(HttpSession.class);
		
		when(usuarioPrueba.getRol()).thenReturn("cliente");
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuarioPrueba);
		controlador.setServicioLogin(servicioLogin); 
		when(req.getSession()).thenReturn(sessionMock);
		
		ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba, req);
		
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/perfil");
		verify(sessionMock, times(1)).setAttribute("ROL", "cliente");	
      
    }
	
	  @Test// anda ok
	    public void consultarUsuarioInexistente () {
	        //Todas las instancias deben ser MOCK
	        Usuario usuarioPrueba = mock(Usuario.class);
	        HttpServletRequest req = mock (HttpServletRequest.class);
	        
	        ServicioLogin servicioLoginFake = mock(ServicioLogin.class);
	        //si aca retorna null es porque no existe
	        when(servicioLoginFake.consultarUsuario(usuarioPrueba)).thenReturn(null);
	        ControladorLogin controlador = new ControladorLogin();
	        //Setearle al controlador el servicio mockeado
	        controlador.setServicioLogin(servicioLoginFake);
	        ModelAndView modelAndView = controlador.validarLogin(usuarioPrueba,req);

	        verify(usuarioPrueba, times(0)).getEmail();
	        assertThat(modelAndView.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
	        assertThat(modelAndView.getViewName()).isEqualTo("login");
	    }
	 
	// este Test todavia no me salio.. porque el controlador tiene pathVAriable  
	/*  @Test
		public void testMostrarListadeVacunasDeUnaMascota() {		  
	  
		

		}

*/

}
