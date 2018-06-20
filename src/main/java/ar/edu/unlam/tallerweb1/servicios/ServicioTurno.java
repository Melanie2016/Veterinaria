package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

public interface ServicioTurno {
	
	List<Veterinario> listaDeVeterinarios();

	List<Especialidad> consultarEspecialidad();

	List<Especialidad> consultarDisponibilidad(Especialidad especialidad);

}
