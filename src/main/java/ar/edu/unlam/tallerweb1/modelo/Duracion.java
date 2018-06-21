package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Duracion {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long duracionId;
	private Integer tiempo;
	
	@ManyToOne
	private Veterinario veterinario;
	
	@ManyToOne
	private Especialidad especialidad;

	
	//getter y setter
	public Long getDuracionId() {
		return duracionId;
	}

	public void setDuracionId(Long duracionId) {
		this.duracionId = duracionId;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

}
