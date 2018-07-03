package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaTurno;
	private Integer horaTurno;
	private Date fechaActual;
	
	@ManyToOne
	private Mascota mascota;
	
	@ManyToOne
	private Veterinario veterinario;
	
	
	//getters y setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public Date getFechaTurno() {
		return fechaTurno;
	}
	public void setFechaTurno(Date fechaTurno) {
		this.fechaTurno = fechaTurno;
	}
	public Integer getHoraTurno() {
		return horaTurno;
	}
	public void setHoraTurno(Integer horaTurno) {
		this.horaTurno = horaTurno;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
    
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota= mascota;
	}
}