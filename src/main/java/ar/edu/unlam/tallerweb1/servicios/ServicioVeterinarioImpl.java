package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.VeterinarioDao;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;


@Service("servicioVeterinario")
@Transactional
public class ServicioVeterinarioImpl implements ServicioVeterinario{
	
	@Inject
	private VeterinarioDao servicioVeterinarioDao;
	
	@Override
	public List<Veterinario> listarTodosLosVeterinarios() {
		return servicioVeterinarioDao.findAll();
	}

	@Transactional
	@Override
	public void guardarVeterinario(Veterinario veterinario) {
		servicioVeterinarioDao.save(veterinario);
		
	}

	@Transactional
	@Override
	public List<Veterinario> insertarVeterinario(Veterinario veterinario) {
		return servicioVeterinarioDao.add(veterinario);
	}
	
	@Override	
	//que me muestre por el id ingresado
	public Veterinario getVeterinarioId(Long veterinarioId) {
        return servicioVeterinarioDao.getVeterinarioId(veterinarioId);
    }
	
	@Override 
	public void editDeVeterinario(Veterinario veterinario) {
		servicioVeterinarioDao.editDeVeterinarioDao(veterinario);
	}

	@Override
	public void eliminarVeterinario(Veterinario veterinario) {
		servicioVeterinarioDao.eliminar(veterinario);
		
	}

}

