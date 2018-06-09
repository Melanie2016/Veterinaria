package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Turno;


@Controller
public class ControladorTurno {
	
	
	//http://localhost:8080/veterinaria/turno
	
	@RequestMapping("turno")
	public ModelAndView sacarTurno() {
		
		ModelMap model =new ModelMap();
		Turno turno = new Turno(); 
		model.put("turno", turno);
		return new ModelAndView ("turno",model);
	}
	

}



