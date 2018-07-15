package ar.edu.unlam.tallerweb1.servicios;

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

	
//	fechas de hoy a dos meses 
	@Override
	public List<Date> consultarFechaASeleccionar(Long diaAtencionId){
			
		DiaAtencion dia = turnoDao.obtenerDiaDeAtencion(diaAtencionId);
		dia.getDia() ; // dia de atencion , ejemplo LUNES
			
		List<Date> listResultado = new ArrayList<Date>();
					
			
		// https://www.discoduroderoer.es/clase-calendar-en-java/
		// https://dosideas.com/wiki/Fechas_En_Java
			
		Calendar inicioGC = GregorianCalendar.getInstance();
		Calendar finGC = GregorianCalendar.getInstance();
		finGC.add(Calendar.MONTH,2);
			
		
		int diaSemana = 0;
			
		if(dia.getDia().equalsIgnoreCase("lunes")) {
			diaSemana = Calendar.MONDAY;		
		}else if (dia.getDia().equalsIgnoreCase("martes")){
			diaSemana = Calendar.TUESDAY;
		}else if (dia.getDia().equalsIgnoreCase("miercoles")){
			diaSemana = Calendar.WEDNESDAY;
		}else if (dia.getDia().equalsIgnoreCase("jueves")){
			diaSemana = Calendar.THURSDAY;
		}else if (dia.getDia().equalsIgnoreCase("viernes")){
			diaSemana = Calendar.FRIDAY;
		}else if (dia.getDia().equalsIgnoreCase("sabado")){
			diaSemana = Calendar.SATURDAY;
		}else if (dia.getDia().equalsIgnoreCase("domingo")){
			diaSemana = Calendar.SUNDAY;
		}
			
		inicioGC.set(Calendar.DAY_OF_WEEK, diaSemana);

			
		// fechas de hoy a dos meses 
		while ( inicioGC.before(finGC) ) {
			inicioGC.add(Calendar.DAY_OF_WEEK,7 ); 	
			listResultado.add(inicioGC.getTime());
		}
			
			
		return listResultado;
	}


















}
