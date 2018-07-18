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


	
	@Override
	public List<Date> obtenerHorariosOcupados(Date fecha){
		// setear la hora a 00:00:00 para q coincidan las fechas exactamente en el criteria 
		Calendar fechaC = new GregorianCalendar();
		fechaC.setTime(fecha);
		fechaC.add(Calendar.MONTH, -1);
		fechaC.set(Calendar.HOUR, 00);
		fechaC.set(Calendar.MINUTE, 00);
		fechaC.set(Calendar.SECOND,	00);
		
		
		
		fecha = fechaC.getTime();
		System.out.println("la fecha q se va a pasar al dao es "+fecha);
		System.out.println("la fechaC q se va a pasar al dao es "+fechaC.getTime());
		
//		List<Date> turnos = 
//		System.out.println("turnooooo : "+turnos);
//		List<Date> horarios = new ArrayList<>();
		return turnoDao.obtenerHorariosOcupadosDao(fecha) ;
	}
	
	
	
//	fechas de hoy a dos meses 
	@Override
	public List<Date> consultarFechaDeElDiaSeleccionadoADosMeses(Long diaAtencionId){
			
		DiaAtencion dia = turnoDao.obtenerDiaDeAtencion(diaAtencionId);
		dia.getDia() ; // dia de atencion , ejemplo LUNES
			
//		List<Turno> listResultado = new ArrayList<Date>();
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


	
	@Override
	public List<Date> obtenerHorariosPosibles(Date fecha, Long diaAtencionId){
		
//		Juan atiende 8 a 12
//		           desde hasta
//		obtenes DiaSelccionado
//		obtenes Duracion
//		hora de inicio (8) y hora de fin (12) 
//		 MiTurno con la hora de inicio (8) que atienede el veterinario
//		agregas a la lista turno
//		while preguntando hora de finalizacion del dia > Hora de Miturno
//		       12 				>	8
//		 hora de turno con  + duracion
//		  mi turno 8 + 10min
//		          8:10  + 10
//		          
//		 agregas a la lista
//		 fin del while
//			 
//
//			 return listaDe turnos
					 
		
		Calendar fechaC = new GregorianCalendar();
		fechaC.setTime(fecha);
		fechaC.add(Calendar.MONTH, -1);
		
//		System.out.println("FECHA PASADA POR PARAMETRO: " + fechaC.getTime());
		
		DiaAtencion dia = turnoDao.obtenerDiaDeAtencion(diaAtencionId);
		dia.getVeterinario().getNombre(); // ejemplo juan
		dia.getHoraAtencionInicio(); // desde
		dia.getHoraAtencionFinalizacion(); // hasta
		
	
		Especialidad especialidad = dia.getEspecialidad() ;
		especialidad.getDuracion(); // duracion
		
		Turno miTurno = new Turno(); 
		// MiTurno con la hora de inicio (8) que atienede el veterinario
		miTurno.setFechaTurno(fecha);
		miTurno.setDiaAtencion(dia);
		miTurno.setHoraTurno(dia.getHoraAtencionInicio());
		
		
//		System.out.println("hora de atencion inicia" +dia.getHoraAtencionInicio());
//		System.out.println("fecha del turno"+miTurno.getFechaTurno());
//		System.out.println("hora del turno"+miTurno.getHoraTurno());
		
		// agregas a la lista turno
		List<Date> listHorariosPosibles = new ArrayList<>();
		listHorariosPosibles.add(miTurno.getHoraTurno());
		

		Calendar fechaDesde = new GregorianCalendar();
		fechaDesde.setTime(miTurno.getHoraTurno());
		
		// agregar una fecha de fin para que el bucle termine en el mismo dia 
		Calendar fechaHasta = new GregorianCalendar();
		fechaHasta.setTime(dia.getHoraAtencionFinalizacion());
	
//		System.out.println("/n /n");
//		System.out.println("fecha desde: "+fechaDesde.getTime());
//		System.out.println("fecha hasta: "+fechaHasta.getTime());
		
		while (fechaHasta.after(fechaDesde)) {
//			System.out.println("La fecha menor es: "+fechaDesde.getTime());
			fechaDesde.add(Calendar.MINUTE, especialidad.getDuracion());
			
			miTurno.setHoraTurno(fechaDesde.getTime());
//			System.out.println("hora de turno: "+miTurno.getHoraTurno());
	
			listHorariosPosibles.add(miTurno.getHoraTurno());
		}
		
		List<Date> horariosOcupados = turnoDao.obtenerHorariosOcupadosDao(miTurno.getFechaTurno());

		listHorariosPosibles.removeAll(horariosOcupados);


		return listHorariosPosibles;
	}
















}
