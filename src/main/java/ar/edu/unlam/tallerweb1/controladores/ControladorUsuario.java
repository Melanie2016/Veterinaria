package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorUsuario {
	
	//http://localhost:8080/veterinaria/perfil
		@RequestMapping("/perfil")
		public ModelAndView mostrarPerfilHumano() {
			
			ModelMap model =new ModelMap();
			Usuario usuario = new Usuario(); 
		
			model.put("usuario", usuario);
			
			return new ModelAndView ("perfil",model);
		}
		

}
