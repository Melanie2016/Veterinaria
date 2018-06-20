package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurno;


@Controller
public class ControladorTurno {
	
	@Inject
	private ServicioTurno servicioTurno;
	
	//http://localhost:8080/veterinaria/turno
	@RequestMapping("/turno")
	public ModelAndView sacarTurno() {
		ModelMap model =new ModelMap();

		List<Especialidad> especialidadList = servicioTurno.consultarEspecialidad();
	
		model.put("especialidades", especialidadList);
		
		return new ModelAndView ("turno",model);
	}
	
	@RequestMapping(path="/consultarDisp",method=RequestMethod.POST)
	public ModelAndView irAConsultarDisp(@ModelAttribute ("especialidades") Especialidad especialidad) {
				
		ModelMap model =new ModelMap();
		List<Especialidad> especialidadList = servicioTurno.consultarDisponibilidad(especialidad);

		model.put("especialidades", especialidadList);
				
		return new ModelAndView ("disponibilidad",model);
	}
	
	
	@RequestMapping(path="/consultarFecha",method=RequestMethod.POST)
	public ModelAndView irAConsultarFecha(@ModelAttribute ("especialidades") Especialidad especialidad) {
				
		ModelMap model =new ModelMap();
		model.put("especialidades", especialidad);
				
		return new ModelAndView ("buscarFechas",model);
	}
	
	
	

}



