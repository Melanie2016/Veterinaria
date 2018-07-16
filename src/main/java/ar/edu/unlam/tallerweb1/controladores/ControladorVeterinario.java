package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorVeterinario {
	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping("/perfilVet")
	public ModelAndView mostrarPerfilVet(HttpServletRequest request) {		
		
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model =new ModelMap();
		
		if (idUsuario != null) {
			if (servicioLogin.buscarPorId(idUsuario).getRol().equals("vet")) {
		
		//estas lineas hacen k muestre el nombre de quien se logueo
		Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
		model.put("usuario", usuarioLogueado);
		model.put("id", usuarioLogueado);
		model.put("email", usuarioLogueado);
		
		Usuario vet = new Usuario();
		model.put("vet", vet);	
		    return new ModelAndView ("perfilVet",model);
			}//por rol
			else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para acceder usted debe tener rol VETERINARIO");
			return new ModelAndView("mensaje", model);}
	}//usuario null	
		else {
			return new ModelAndView("redirect:/login");}
	}

}
