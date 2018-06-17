package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String descripcion;
	
	///nan
	private Integer duracion;
	private String diaAtencion;
	private Date horarioTurnoManianaInicio;
	private Date horarioTurnoManianaFinal;
	private Date horarioTurnoNocheInicio;
	private Date horarioTurnoNocheFinal;
	
	
	
	
}
