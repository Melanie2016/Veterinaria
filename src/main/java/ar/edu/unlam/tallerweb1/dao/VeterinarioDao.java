package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Veterinario;


public interface VeterinarioDao {

	List<Veterinario> findAll();
	List<Veterinario> add(Veterinario veterinario);
	void save(Veterinario veterinario);
	void eliminar(Veterinario veterinario);
	Veterinario getVeterinarioId(Long veterinarioId);
	void editDeVeterinarioDao(Veterinario veterinario);
}