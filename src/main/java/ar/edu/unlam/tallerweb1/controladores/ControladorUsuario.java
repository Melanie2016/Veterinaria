package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorUsuario {
	
	@Inject
	private ServicioMascota servicioMascota;
	/*
	//http://localhost:8080/veterinaria/perfil
		@RequestMapping("/perfil")
		public ModelAndView mostrarPerfilHumano() {
			
			ModelMap model =new ModelMap();
			Usuario usuario = new Usuario(); 
		
			model.put("usuario", usuario);
			
			return new ModelAndView ("perfil",model);
		}*/
		
		//perfil humano:carga todas las mascotas
		
			@RequestMapping(path="/perfil", method=RequestMethod.GET)
			public ModelAndView mostrarPerfilHumano() {
				
				ModelMap modelo = new ModelMap();
				List<Mascota> mList = servicioMascota.mostrarMascotas();
				modelo.put("mascota", mList);
				modelo.put("id", mList);
				return new ModelAndView("perfil",modelo);
			}
		

}
