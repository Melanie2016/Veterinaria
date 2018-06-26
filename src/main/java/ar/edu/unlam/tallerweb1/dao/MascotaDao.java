package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;

public interface MascotaDao {

	List<Mascota> mostrarMascotasDao ();
	Mascota getIdDao(Long id);
	List<EstadoVacuna> mostrarEstadoVacunasDao (Long idMascota);
}
