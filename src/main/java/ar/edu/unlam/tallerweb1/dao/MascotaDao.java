package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;

public interface MascotaDao {

	List<Mascota> mostrarMascotasDao ();
	Mascota getIdDao(Long id);
	List<EstadoVacuna> mostrarEstadoVacunasDao (Long idMascota);
	
	
	//para mostrar vacunas // para el stock
	List<Vacuna> mostrarVacunasDao ();
	Vacuna getIdVacDao(Long id);
}
