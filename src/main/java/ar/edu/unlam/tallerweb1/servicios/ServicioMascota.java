package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;

public interface ServicioMascota {
	
	List<Mascota> mostrarMascotas();
	Mascota getId(Long id); 
	List<EstadoVacuna> mostrarEstadoVacunas(Long idMascota);
	 
	//vacunas en el perfil admin
	List<Vacuna> mostrarVacunas(); 
	Vacuna getIdVac(Long id);
	 
	int consultarStock();
	int consultarEstado(Long idUsuario);
	int contarMascotas();
	
     List<Mascota> mostrarMascotasDeUno(Long idUsuario);
          
    //abm mascota
 	void cargaDeMascota(Mascota mascota);
 	void editDeMascota(Mascota mascota);
 	void eliminarMascota(Mascota mascota);
 		
 	// para revacurar 
 	EstadoVacuna consultaEstadoVacuna(Long idEstadoVacuna);
 	
 	Date mostrarRevacunacion(EstadoVacuna estadoVacuna);
	

	
	
	
}
