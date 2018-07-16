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
	
	//intento revacunacion
	public EstadoVacuna getIdEVDao(Long id);
	
	List<Mascota> mostrarMascotasDeUnoDao (Long idUsuario);
	
	void cargaDeMascotaDao (Mascota mascota);
	void editDeMascotaDao (Mascota mascota);
	void eliminarMascotaDao(Mascota mascota);
}
