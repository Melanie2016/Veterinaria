package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
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
	
	
	@RequestMapping(path="/consultarVet/{especialidadId}")
	public ModelAndView irAConsultarVet(@PathVariable Long especialidadId) {
				
		ModelMap model =new ModelMap();
		
		List<DiaAtencion> vetList = servicioTurno.consultarVeterinario(especialidadId);
		
		model.put("veterinarios", vetList);
				
		return new ModelAndView ("disponibilidad",model);
	}
	
	
	@RequestMapping(path="/horarios/{diaAtencionId}")
	public ModelAndView irAConsultarHs(@PathVariable Long diaAtencionId ) {

		Date fecha = new Date();
		
		// hacer un servicio q me traiga la duracion en int  y mandarla 
		// en el servicio obtenerTurnosPosibles en lugar de fecha
		ModelMap model =new ModelMap();
		model.put("diaAtencion", servicioTurno.obtenerDiaDeAtencion(diaAtencionId));
		model.put("turnos", servicioTurno.obtenerTurnosPosibles(fecha, diaAtencionId));
		

				
		return new ModelAndView ("buscarFechas",model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}



