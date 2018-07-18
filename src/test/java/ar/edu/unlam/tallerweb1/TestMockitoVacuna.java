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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorAdmin;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorMascota;
import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;


public class TestMockitoVacuna {
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
	private List<EstadoVacuna> listaVacunas;
	@Mock
	private EstadoVacuna estadoVacuna;
	@InjectMocks
	private ControladorMascota controlador;
	
	@InjectMocks
	private ControladorAdmin controladorAdmin;
		 
	@Before
	public void inyeccionAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testListaDeVacunas() {
		
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioMascota.getId(any(Long.class))).thenReturn(mascota);
		when(servicioMascota.mostrarEstadoVacunas(any(Long.class))).thenReturn(listaVacunas);
		//ejecucion			
		ModelAndView mav7 = controlador.irAvacunas(1L,request);
		
	
		//verificacion	
		assertThat(mav7.getModelMap()).isNotEmpty();
		verify(servicioMascota,times(1)).getId(1L);
		verify(servicioMascota,times(1)).mostrarEstadoVacunas(1L);
		
	}
	
	

}
