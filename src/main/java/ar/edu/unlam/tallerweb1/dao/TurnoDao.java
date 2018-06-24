package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;

public interface TurnoDao {

	//List<Veterinario> listaDeVeterinariosDao();

	List<Especialidad> consultarEspecialidadDao();

	List<Especialidad> consultarVeterinarioDao(Especialidad especialidad);

	List<Especialidad> consultarDisponibilidadDao(Especialidad especialidad);


	
	
}
