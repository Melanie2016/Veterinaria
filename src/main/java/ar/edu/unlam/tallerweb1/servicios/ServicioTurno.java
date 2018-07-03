package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Duracion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

public interface ServicioTurno {
	
	// List<Veterinario> listaDeVeterinarios();

	List<Especialidad> consultarEspecialidad();

	List<DiaAtencion> consultarVeterinario(Long especialidadId);
	
	List<DiaAtencion> consultarDisponibilidad(Long veterinarioId,Long especialidadId);

//	List<Veterinario> consultarDuracion(Long veterinarioId,Long especialidadId);
	
	Integer buscarDuracion(Long veterinarioId, Long especialidadId);
	

}
