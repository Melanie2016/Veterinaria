package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MascotaDao;
import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
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

}
