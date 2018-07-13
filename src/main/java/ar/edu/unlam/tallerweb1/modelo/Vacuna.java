package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacuna {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreVacuna;
	private String animal;

	private Integer vencimiento; // expresado en meses para calcular al revacunacion
	private Integer cantStock;

	
	
	//getters y setters

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNombreVacuna() {
			return nombreVacuna;
		}


		public void setNombreVacuna(String nombreVacuna) {
			this.nombreVacuna = nombreVacuna;
		}
		
		
		public Integer getVencimiento() {
			return vencimiento;
		}


		public void setVencimiento(Integer vencimiento) {
			this.vencimiento = vencimiento;
		}

		
		public Integer getCantStock() {
			return cantStock;
		}


		public void setCantStock(Integer cantStock) {
			this.cantStock = cantStock;
		}
		
		public String getAnimal() {
			return animal;
		}


		public void setAnimal(String animal) {
			this.animal = animal;
		}
}
