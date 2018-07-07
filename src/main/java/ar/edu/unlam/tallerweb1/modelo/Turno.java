package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;


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
	private Date fechaHoy;
	private Integer horaTurno;
	private Long fechaTurno;
	
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
		
	public Date getFechaHoy() {
		return fechaHoy;
	}
	public void setFechaHoy(Date fechaTurno) {
		this.fechaHoy = fechaTurno;
	}
	public Integer getHoraTurno() {
		return horaTurno;
	}
	public void setHoraTurno(Integer horaTurno) {
		this.horaTurno = horaTurno;
	}
	public Long getFechaTurno() {
		return fechaTurno;
	}
	public void setFechaTurno(Long fechaTurno) {
		this.fechaTurno = fechaTurno;
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