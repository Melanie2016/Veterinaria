package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TurnoDao;
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
	public List<Especialidad> consultarVeterinario(Especialidad especialidad){
		return turnoDao.consultarVeterinarioDao(especialidad);
	
	}
	
	@Override
	public List<Veterinario> consultarDisponibilidad(Veterinario veterinarios){
		return turnoDao.consultarDisponibilidadDao(veterinarios);
	
	}
	
	
	
}
