package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioVeterinario;


@Controller
public class ControladorVeterinarioAbm {

	
	@Inject
	private ServicioVeterinario servicioVeterinario;
	
	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping(path = "veterinario-Abm")
	public ModelAndView mostrarEquipo(HttpServletRequest request) {

		
		if(request.getSession().getAttribute("admin") == null) {
			return new ModelAndView("redirect:/");
			
		}
		
		ModelMap modelo = new ModelMap();
		
		Veterinario veterinario= new Veterinario();
		modelo.put("veterinario",veterinario);
		
		List<Veterinario> veterinarios = servicioVeterinario.listarTodosLosVeterinarios();
		modelo.put("veterinarios", veterinarios);
		
		Usuario consultarUsuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("admin"));
		modelo.put("usuario",consultarUsuario);
		modelo.put("email",consultarUsuario.getEmail());
		
		
		return new ModelAndView("veterinario-Abm",modelo);
	}

	
	@RequestMapping(path = "crear-veterinario" , method = RequestMethod.POST)
	public ModelAndView crearVeterinario(@ModelAttribute("veterinario") Veterinario veterinario , HttpServletRequest request) {

		
		if(request.getSession().getAttribute("admin") == null) {
			return new ModelAndView("redirect:/");
			
		}
		
		ModelMap modelo = new ModelMap();
		
		Usuario consultarUsuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("admin"));
		modelo.put("usuario",consultarUsuario);
		modelo.put("email",consultarUsuario.getEmail());
		
		if(servicioVeterinario.consultarVeterinario(veterinario) == null) {
			
			servicioVeterinario.guardarVeterinario(veterinario);
			modelo.put("aviso", "Se creo correctamente");
		
		} else {
			modelo.put("aviso", "No se pudo crear correctamente");
			
		}
		
		Veterinario veterinarioNuevo= new Veterinario();
		modelo.put("veterinario", veterinarioNuevo);
		
		
		List<Veterinario> veterinarios = servicioVeterinario.listarTodosLosVeterinarios();
		modelo.put("veterinarios", veterinarios);

		return new ModelAndView("veterinario-Abm",modelo);
	}
	
	@RequestMapping(path = "actualizar-veterinario" , method = RequestMethod.POST)
	public ModelAndView actualizarVeterinario(@ModelAttribute("veterinario") Veterinario veterinario , HttpServletRequest request) {
		
		if(request.getSession().getAttribute("admin") == null) {
			return new ModelAndView("redirect:/");
		}
		
		
		ModelMap modelo = new ModelMap();
		
		Usuario consultarUsuario = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("AdminId"));
		modelo.put("usuario",consultarUsuario);
		modelo.put("email",consultarUsuario.getEmail());
		
		
		if(servicioVeterinario.consultarVeterinario(veterinario) == null) {
	
			
			servicioVeterinario.actualizarVeterinario(veterinario);
		
			modelo.put("aviso", "Se actualizo correctamente");
			
		} else {
			modelo.put("aviso", "El nombre se encuentra en uso");
		}
		
		Veterinario veterinarioCreado = new Veterinario();
		modelo.put("veterinario",veterinarioCreado);

		List<Veterinario> veterinarios = servicioVeterinario.listarTodosLosVeterinarios();
		modelo.put("veterinarios", veterinarios);

		return new ModelAndView("veterinario-Abm" , modelo);
	}
}
