package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;
import ar.edu.unlam.tallerweb1.servicios.ServicioVeterinario;

@Controller
public class ControladorAdmin {
	
	@Inject
	private ServicioMascota servicioMascota;
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioVeterinario servicioVeterinario;
	
	
	
	@RequestMapping("/perfilAdmin")
	public ModelAndView mostrarPerfilAdmin(HttpServletRequest request) {		
		//se obtiene el usuario con su ssesion
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model =new ModelMap();
		
		if (idUsuario != null) {
			if (servicioLogin.buscarPorId(idUsuario).getRol().equals("admin")) {
				//estas lineas hacen k muestre l nombre de quein se logueo
				Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
				model.put("usuario", usuarioLogueado);
				model.put("id", usuarioLogueado);
				model.put("email", usuarioLogueado);	
			
		Integer aviso =servicioMascota.consultarStock();
			if(aviso==0){
				model.put("aviso", "Revisar el Stock de Vacunas, quedan pocas");
			}else
			{ model.put("aviso", ">>No hay notificaciones para mostrar<<");}
		
	 return new ModelAndView ("perfilAdmin",model);
			}//por rol
			else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para acceder usted debe tener rol ADMINISTRADOR");
			return new ModelAndView("mensaje", model);}
	}//usuario null	
		else {
			return new ModelAndView("redirect:/login");}
		
	}
	
	
	@RequestMapping(path="/stockVacunas", method=RequestMethod.GET)
	public ModelAndView mostrarStock() {			
		ModelMap model =new ModelMap();
		List<Vacuna> list =servicioMascota.mostrarVacunas(); 
		model.put("vacuna", list);
		model.put("id", list);
		model.put("nombreVacuna", list);
		model.put("vencimiento", list);
		model.put("animal", list);
		model.put("cantStock", list);

		    return new ModelAndView ("stockVacunas",model);
		
	}
	
	//solapa veterinarios
	
	@RequestMapping("/veterinarios")
	public ModelAndView irAlistadoDeVeterinarios() {
		
		ModelMap modelo = new ModelMap();
		List<Veterinario> listVet=servicioVeterinario.listarTodosLosVeterinarios();
		modelo.put("vet", listVet);
		return new ModelAndView("veterinarios",modelo);
	}

}
