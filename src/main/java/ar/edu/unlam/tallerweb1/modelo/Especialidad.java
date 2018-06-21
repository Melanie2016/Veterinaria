package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Especialidad {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long especialidadId;
	private String descripcion;
	
	
	@ManyToOne
	private Veterinario veterinario; 
	
	
	
	
	
	// getters y setters 
	public Long getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(Long especialidadId) {
		this.especialidadId = especialidadId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
