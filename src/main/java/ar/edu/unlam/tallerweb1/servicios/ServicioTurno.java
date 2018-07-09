package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

public interface ServicioTurno {
	
	// List<Veterinario> listaDeVeterinarios();

	List<Especialidad> consultarEspecialidad();

	List<DiaAtencion> consultarVeterinario(Long especialidadId);
	
	List<Turno> listaDeTurnos(Long diaAtencionId);

	DiaAtencion obtenerDiaDeAtencion(Long diaAtencionId);

	List<Turno> obtenerTurnosPosibles(Date fecha, Long diaAtencionId);
	
	

}
