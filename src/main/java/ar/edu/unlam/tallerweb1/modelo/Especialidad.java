package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Especialidad {
	
	

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long especialidadId;
	private String descripcion;
	private Float duracion;
	private String diaDeAtencion;
	private Time turnoMa�anaInicio;
	private Time turnoMa�anaFinaliza;
	private Time turnoTardeInicio;
	private Time turnoTardeFinaliza;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name="especialidad_veterinario",
    joinColumns = {@JoinColumn(name = "especialidad_id")},
    inverseJoinColumns = {@JoinColumn(name = "veterinario_id")})
    private List<Veterinario> veterinario = new ArrayList<>();
	
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
	
	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	public String getDiaDeAtencion() {
		return diaDeAtencion;
	}

	public void setDiaDeAtencion(String diaDeAtencion) {
		this.diaDeAtencion = diaDeAtencion;
	}

	public Time getTurnoMa�anaInicio() {
		return turnoMa�anaInicio;
	}

	public void setTurnoMa�anaInicio(Time turnoMa�anaInicio) {
		this.turnoMa�anaInicio = turnoMa�anaInicio;
	}

	public Time getTurnoMa�anaFinaliza() {
		return turnoMa�anaFinaliza;
	}

	public void setTurnoMa�anaFinaliza(Time turnoMa�anaFinaliza) {
		this.turnoMa�anaFinaliza = turnoMa�anaFinaliza;
	}

	public Time getTurnoTardeInicio() {
		return turnoTardeInicio;
	}

	public void setTurnoTardeInicio(Time turnoTardeInicio) {
		this.turnoTardeInicio = turnoTardeInicio;
	}

	public Time getTurnoTardeFinaliza() {
		return turnoTardeFinaliza;
	}

	public void setTurnoTardeFinaliza(Time turnoTardeFinaliza) {
		this.turnoTardeFinaliza = turnoTardeFinaliza;
	}

	public List<Veterinario> getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(List<Veterinario> veterinario) {
		this.veterinario = veterinario;
	}

	
	
}
