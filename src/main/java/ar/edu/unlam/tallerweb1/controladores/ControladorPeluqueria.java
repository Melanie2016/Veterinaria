package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Peluqueria;

@Controller
public class ControladorPeluqueria {
	
			@RequestMapping("/peluqueria")
			public ModelAndView mostrarPeluqueria() {
				
				ModelMap model =new ModelMap();
				Peluqueria peluqueria = new Peluqueria(); 
			
				model.put("peluqueria", peluqueria);
				
				return new ModelAndView ("peluqueria",model);
			}
}
