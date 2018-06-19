package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mascota;

@Controller
public class ControladorMascota {
	
	//http://localhost:8080/veterinaria/perfilMascota
			@RequestMapping("/perfilMascota")
			public ModelAndView mostrarPerfilMascota() {
				
				ModelMap model =new ModelMap();
				Mascota mascota = new Mascota(); 
			
				model.put("mascota", mascota);
				
				return new ModelAndView ("perfilMascota",model);
			}
			

	}



