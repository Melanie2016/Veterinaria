package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.sql.Time;

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
	private Date dia;
	private Time horaAtencionInicio;
	private Time horaAtencionFinalizacion;
	
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

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHoraAtencionInicio() {
		return horaAtencionInicio;
	}

	public void setHoraAtencionInicio(Time horaAtencionInicio) {
		this.horaAtencionInicio = horaAtencionInicio;
	}

	public Time getHoraAtencionFinalizacion() {
		return horaAtencionFinalizacion;
	}

	public void setHoraAtencionFinalizacion(Time horaAtencionFinalizacion) {
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
