package ar.edu.unlam.tallerweb1.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
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
			@PathVariable Long diaAtencionId ,HttpServletRequest request) {
		
//		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		
		Calendar fechaGC = new GregorianCalendar();
		fechaGC.set(Calendar.DATE, dia);
		fechaGC.set(Calendar.MONTH, mes);
		fechaGC.set(Calendar.YEAR, anio);
		
		Date fecha = fechaGC.getTime();
		
		
		ModelMap model =new ModelMap();
		List<Date> listHorariosPosibles = servicioTurno.obtenerHorariosPosibles(fecha, diaAtencionId);
//		List<Date> listHorariosOcupados = servicioTurno.obtenerHorariosOcupados(fecha);
//		List<Turno> turnosPosibles = servicioTurno.generarTurnosPosibles(listHorariosPosibles,listHorariosOcupados,diaAtencionId);
		
		
		
		model.put("horarios", listHorariosPosibles);
		
		fechaGC.add(Calendar.MONTH, -1);
		fechaGC.set(Calendar.HOUR, 00);
		fechaGC.add(Calendar.MINUTE,00);
		fechaGC.add(Calendar.SECOND,00);
		fecha = fechaGC.getTime();
		model.put("fechaTurno", fecha);
		
		DiaAtencion diaAtencion = servicioTurno.obtenerDiaDeAtencion(diaAtencionId);
		
		
		Turno miTurno = new Turno();
		miTurno.setDiaAtencion(diaAtencion);
		model.put("turno", miTurno);		
		model.put("diaAtencion", diaAtencion);
		
				
		return new ModelAndView ("buscarHorarios",model);
	}
	
	
	
	
	@RequestMapping(path="validarTurno",method = RequestMethod.POST) 
	public ModelAndView irAConfirmarTurno(@ModelAttribute ("turno") Turno turno) {
		
		
		
		ModelMap model = new ModelMap();
		
		 servicioTurno.registrarTurno(turno);
		model.put("turnoARegistrar",servicioTurno);
		
		return new ModelAndView("felicitaciones",model);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}



