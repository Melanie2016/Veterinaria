package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorMascota;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

public class TestMockitoMascota {
	@Mock
	private ServicioLogin servicioLogin;
	@Mock
	private ServicioMascota servicioMascota;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpSession session;
	@Mock
	private Mascota mascota;
	@Mock
	private BindingResult bindingResult;
	@InjectMocks
	private ControladorMascota controlador;
		 
	
	@Before
	public void inyeccionMocksInicializada() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQueVerificaQueLaMascotaSeaValido() {
		when(request.getSession()).thenReturn(session);
		when(servicioMascota.getId(any(Long.class))).thenReturn(mascota);
		
		when(mascota.getNombre()).thenCallRealMethod();
		when(mascota.getEdad()).thenCallRealMethod();
		when(mascota.getDuenio()).thenCallRealMethod();
		
		ModelAndView modelo = controlador.irAValidarMascota(mascota, bindingResult, request);    
		
		assertThat(modelo.getViewName()).isEqualTo("correcto");
		
		verify(session , times(0)).setAttribute("nombre", "mascota");
		verify(session , times(0)).setAttribute("tipo", "mascota");
		verify(session , times(0)).setAttribute("edad", "mascota");
		
	}
	
	@Test
	public void testQueSePuedaEliminarUnaMascota() {
		when(request.getSession()).thenReturn(session);
		when(servicioMascota.getId(any(Long.class))).thenReturn(mascota);
		
		ModelAndView modelo = controlador.irAeliminar(mascota);   
		
		assertThat(modelo.getViewName()).isEqualTo("correcto");
		
		verify(session , times(0)).setAttribute("nombre", "mascota");
		verify(session , times(0)).setAttribute("tipo", "mascota");
		verify(session , times(0)).setAttribute("edad", "mascota");
	}
	
	
}
