package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

public interface TurnoDao {

	//List<Veterinario> listaDeVeterinariosDao();

	List<Especialidad> consultarEspecialidadDao();

	List<DiaAtencion> consultarVeterinarioDao(Long especialidadId);

	List<Veterinario> consultarDisponibilidadDao(Long veterinarioId);


	
	
}
