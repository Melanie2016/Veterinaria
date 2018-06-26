package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;

public interface ServicioMascota {
	List<Mascota> mostrarMascotas();
	 Mascota getId(Long id);
	 
	 List<EstadoVacuna> mostrarEstadoVacunas(Long idMascota);

}
