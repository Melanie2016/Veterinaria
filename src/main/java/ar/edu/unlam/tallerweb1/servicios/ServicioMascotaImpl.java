package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MascotaDao;
import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
@Service("servicioMascota")
@Transactional
public class ServicioMascotaImpl implements ServicioMascota{
	
	@Inject
	private MascotaDao servicioMascotaDao;
	
	
	@Override
	public List<Mascota> mostrarMascotas(){
		return servicioMascotaDao.mostrarMascotasDao();
		
	}
		
	//que me muestre por el id ingresado
	public Mascota getId(Long id) {
        return servicioMascotaDao.getIdDao(id);
    }
	
	@Override
	public List<EstadoVacuna> mostrarEstadoVacunas(Long idMascota){
		return servicioMascotaDao.mostrarEstadoVacunasDao(idMascota);
		
	}
	//para el stock
	@Override
	public List<Vacuna> mostrarVacunas(){
		return servicioMascotaDao.mostrarVacunasDao();	
	}
	
	public Vacuna getIdVac(Long id) {
        return servicioMascotaDao.getIdVacDao(id);
    }
	
	 public int consultarStock(){ 
	 List<Vacuna> listaVacunas= servicioMascotaDao.mostrarVacunasDao();	 
		for (Vacuna vacuna : listaVacunas) {
			if (vacuna.getCantStock() < 20) 
			return 0;				
	 }
	return 1;
  }	
}
