package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EstadoVacuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado; //ok:aplicada  //no: no aplicada
	private Date fecha_aplicacion;
	
	@ManyToOne
	private Vacuna vacuna;
	
	@ManyToOne
	private Mascota mascota;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}
	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public Date getFecha_aplicacion() {
		return fecha_aplicacion;
	}
	public void setFecha_aplicacion(Date fecha_aplicacion) {
		this.fecha_aplicacion = fecha_aplicacion;
	}

}
