package ar.edu.unlam.tallerweb1.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	
	
	@RequestMapping(path="/fechas/{diaAtencionId}") 
	public ModelAndView irAConsultarFecha(@PathVariable Long diaAtencionId ) {
		
		
		ModelMap model =new ModelMap();
		List<Date> fechasADosMeses = servicioTurno.consultarFechaDeElDiaSeleccionadoADosMeses(diaAtencionId);
		
		model.put("fechas",fechasADosMeses);
		model.put("diaAtencion", diaAtencionId);
		
		
		return new ModelAndView ("buscarFechas",model);
	}
	
	
	
	
	@RequestMapping(path="/horarios/{dia}/{mes}/{anio}/{diaAtencionId}") 
	public ModelAndView irAConsultarHorarios(
			@PathVariable int dia,
			@PathVariable int mes,
			@PathVariable int anio,
			@PathVariable Long diaAtencionId) {
		
		Calendar fechaGC = new GregorianCalendar();
		fechaGC.set(Calendar.DATE, dia);
		fechaGC.set(Calendar.MONTH, mes);
		fechaGC.set(Calendar.YEAR, anio);
		
		Date fecha = fechaGC.getTime();
		
		
		ModelMap model =new ModelMap();
		List<Date> listHorariosPosibles = servicioTurno.obtenerHorariosPosibles(fecha, diaAtencionId);
//		List<Date> listHorariosOcupados = servicioTurno.obtenerHorariosOcupados(fecha);
//		List<Turno> turnosPosibles = servicioTurno.generarTurnosPosibles(listHorariosPosibles,listHorariosOcupados,diaAtencionId);
		fechaGC.add(Calendar.MONTH, -1);
		model.put("horarios", listHorariosPosibles);
		model.put("fecha", fechaGC.getTime());
		model.put("diaAtencion", diaAtencionId);

				
		return new ModelAndView ("buscarHorarios",model);
	}
	
	
	
	
	@RequestMapping(path="/formResumen") 
	public ModelAndView irAConsultarHorarios() {
		// pendiente
		
		ModelMap model = new ModelMap();
		
		return new ModelAndView("resumenDeTurno",model);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}



