package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Duracion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

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
	public Integer buscarDuracion(Long veterinarioId,Long especialidadId){
		return turnoDao.buscarDuracionDao(veterinarioId, especialidadId);
	
	}
	
//	@Override
//	public List<Veterinario> consultarDuracion(Long veterinarioId,Long especialidadId){
//		
//		return turnoDao.consultarDuracionDao(veterinarioId,especialidadId);
//	
//	}

	
	@Override
	public List<Turno> listaDeTurnos(Long veterinarioId){
		return turnoDao.listaDeTurnosDao(veterinarioId);
	}
	
	@Override
	public List<Turno> consultarDisponibilidad(Long veterinarioId, Long especialidadId, Integer duracion){
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaHoy = new Date();
		
		Turno turno = new Turno();
		turno.setFechaTurno((Long.parseLong(formateador.format(fechaHoy))));
		
		List<Turno> turnos = turnoDao.consultarDisponibilidadDao(veterinarioId, turno);	// traigoLosTurnosDeHoy
		
		List<Turno> turnosDisp = new ArrayList<Turno>();
		
	
		for(Turno misT : turnos) {
			turno.setHoraTurno(800);
			if (turno.getHoraTurno().equals(misT.getHoraTurno()) ) {
				 System.out.println("No es posible dar turnos para esa hora");
			}else {
				Integer hora = duracion ++;
				turno.setHoraTurno(hora);
				turnosDisp.add(turno);
			}
			
		}
		
		
		
//		List<Turno> listTurnos = new ArrayList<>();
//		
//		listTurnos.add(turno);
//		turnos.removeAll(turnosDisp);
//		
		return turnosDisp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
