package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Duracion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
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
	public List<DiaAtencion> consultarDisponibilidad(Long veterinarioId, Long especialidadId){
		
//		Veterinario vet = new Veterinario();
//		vet.setVeterinarioId(veterinarioId);
//		
//		Especialidad esp = new Especialidad();
//		esp.setEspecialidadId(especialidadId);
		
		DiaAtencion diaA = new DiaAtencion();
//		diaA.setVeterinario(vet);
//		diaA.setEspecialidad(esp);
		
		List<DiaAtencion> miList = new ArrayList<>();
		miList.add(diaA);
		
		Integer horaTurno = 8 ;
		
		
			
			while(((DiaAtencion) miList).getHoraAtencionInicio() != null) {
				Integer duracion = turnoDao.buscarDuracionDao(veterinarioId, especialidadId);
				miList = turnoDao.consultarDisponibilidadDao(veterinarioId, horaTurno);
				horaTurno = horaTurno + duracion;
			
			}
			
		
		
		return miList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
