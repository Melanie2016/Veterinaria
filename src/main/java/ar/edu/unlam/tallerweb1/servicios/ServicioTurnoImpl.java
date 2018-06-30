package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
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
	public List<Veterinario> consultarDisponibilidad(Long veterinarioId){
		
		return turnoDao.consultarDisponibilidadDao(veterinarioId);
	
	}
	
	public List<Veterinario> consultarDuracion(Long veterinarioId,Long especialidadId){
		
		return turnoDao.consultarDuracionDao(veterinarioId,especialidadId);
	
	}
	
	
}
