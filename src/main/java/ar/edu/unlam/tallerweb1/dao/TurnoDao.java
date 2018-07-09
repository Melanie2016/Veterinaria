package ar.edu.unlam.tallerweb1.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

public interface TurnoDao {

	//List<Veterinario> listaDeVeterinariosDao();

	List<Especialidad> consultarEspecialidadDao();

	List<DiaAtencion> consultarVeterinarioDao(Long especialidadId);

	List<Turno> listaDeTurnosDao(Long diaAtencionId);
	
	DiaAtencion obtenerDiaDeAtencion(Long diaAtencionId);

	List<Turno> obtenerTurnosPosiblesDao(Date fecha, Long diaAtencionId);
}
