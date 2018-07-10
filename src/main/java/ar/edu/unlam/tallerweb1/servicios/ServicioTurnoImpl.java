package ar.edu.unlam.tallerweb1.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;

@Service("servicioTurno")
@Transactional
public class ServicioTurnoImpl implements ServicioTurno{




	@Inject
	private TurnoDao turnoDao;

	/*
	@Override
	public List<Veterinario> listaDeVeterinarios(){
		return turnoDao.listaDeVeterinariosDao();

	}
	 */

	@Override
	public List<Especialidad> consultarEspecialidad(){
		return turnoDao.consultarEspecialidadDao();

	}

	@Override
	public List<DiaAtencion> consultarVeterinario(Long especialidadId){
		return turnoDao.consultarVeterinarioDao(especialidadId);

	}


	@Override
	public DiaAtencion obtenerDiaDeAtencion(Long diaAtencionId){
		return turnoDao.obtenerDiaDeAtencion(diaAtencionId);
	}

	@Override
	public List<Turno> listaDeTurnos(Long diaAtencionId){
		return turnoDao.listaDeTurnosDao(diaAtencionId);
	}

	
	@Override
	public List<Turno> obtenerTurnosPosibles(Date fecha, Long diaAtencionId){
		
		Calendar inicioGC = GregorianCalendar.getInstance();
		Calendar finGC = GregorianCalendar.getInstance();
		finGC.add(Calendar.DAY_OF_WEEK_IN_MONTH,1);
	
		
		DiaAtencion diaAtencion = obtenerDiaDeAtencion(diaAtencionId);
		
		int diaSemana = 0;
		
		if(diaAtencion.getDia().equalsIgnoreCase("lunes")) {
			diaSemana = Calendar.MONDAY;		
		}else if (diaAtencion.getDia().equalsIgnoreCase("martes")){
			diaSemana = Calendar.TUESDAY;
		}else if (diaAtencion.getDia().equalsIgnoreCase("miercoles")){
			diaSemana = Calendar.WEDNESDAY;
		}else if (diaAtencion.getDia().equalsIgnoreCase("jueves")){
			diaSemana = Calendar.THURSDAY;
		}else if (diaAtencion.getDia().equalsIgnoreCase("viernes")){
			diaSemana = Calendar.FRIDAY;
		}else if (diaAtencion.getDia().equalsIgnoreCase("sabado")){
			diaSemana = Calendar.SATURDAY;
		}else if (diaAtencion.getDia().equalsIgnoreCase("domingo")){
			diaSemana = Calendar.SUNDAY;
		}
		
		Turno turno = new Turno();
		List<Turno> listaDeTurnos = new ArrayList<Turno>();
		List<Turno> turnosOcupados = turnoDao.listaDeTurnosDao(diaAtencionId);
		
		while ( inicioGC.before(finGC) ) {
			if ( inicioGC.get(Calendar.DAY_OF_WEEK) == diaSemana)
				// esta fecha sirve para saber a partir de cuando se pueden sacar los turnos
//				inicioGC.add(Calendar.WEEK_OF_MONTH,1);
				inicioGC.add(Calendar.MINUTE,10);
				turno.setFecha(inicioGC.getTime());
				turno.setDiaAtencion(diaAtencion);
				listaDeTurnos.add(turno);
				
				
				inicioGC.add(Calendar.DATE, 1);
			}
		
		
		
		return listaDeTurnos;
	}


















}
