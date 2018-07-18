package ar.edu.unlam.tallerweb1.modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DiaAtencion {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String dia;
	private Date horaAtencionInicio;
	private Date horaAtencionFinalizacion;
	
	
	
	@ManyToOne
	private Veterinario veterinario;
	
	@ManyToOne
	private Especialidad especialidad;

	
	
	
	//getter y setter
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHoraAtencionInicio() {
		return horaAtencionInicio;
	}

	public void setHoraAtencionInicio(Date horaAtencionInicio) {
		this.horaAtencionInicio = horaAtencionInicio;
	}

	public Date getHoraAtencionFinalizacion() {
		return horaAtencionFinalizacion;
	}

	public void setHoraAtencionFinalizacion(Date horaAtencionFinalizacion) {
		this.horaAtencionFinalizacion = horaAtencionFinalizacion;
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
