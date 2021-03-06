package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Veterinario;


public interface ServicioVeterinario {
	
	List<Veterinario> listarTodosLosVeterinarios();
	List<Veterinario> insertarVeterinario(Veterinario veterinario);
	void guardarVeterinario(Veterinario veterinario);
	void eliminarVeterinario(Veterinario veterinario);
	Veterinario getVeterinarioId(Long veterinarioId);
	void editDeVeterinario(Veterinario veterinario);

}