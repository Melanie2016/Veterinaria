package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MascotaDao;
import ar.edu.unlam.tallerweb1.dao.VacunaDao;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;

@Service("servicioVacuna")
@Transactional
public class ServicioVacunaImpl implements ServicioVacuna{
	
	@Inject
	private VacunaDao servicioVacunaDao;
	
	
	@Override
	public List<Vacuna> mostrarVacunas(){
		return servicioVacunaDao.mostrarVacunasDao();
		
	}

}
