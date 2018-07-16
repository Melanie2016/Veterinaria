package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long veterinarioId;
	private String nombre;
	private String apellido;
	private String especialidad;

//	Date hoy = new Date();
//	hoy.
	
	//getters y setters
	public Long getVeterinarioId() {

		return veterinarioId;
	}
	public void setVeterinarioId(Long veterinarioId) {
		this.veterinarioId = veterinarioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	//Use hashCode para que devuelva el veterinario en forma consistente
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinario other = (Veterinario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		return true;
	}
	
}
