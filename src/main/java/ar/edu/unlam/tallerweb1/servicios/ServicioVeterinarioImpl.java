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
	private VeterinarioDao veterinarioDao;
	
	@Override
	public List<Veterinario> listarTodosLosVeterinarios() {
		return veterinarioDao.findAll();
	}

	@Transactional
	@Override
	public void guardarVeterinario(Veterinario veterinario) {
		veterinarioDao.save(veterinario);
		
	}

	@Override
	public Veterinario consultarVeterinario(Veterinario veterinario) {
		return veterinarioDao.findByMatch(veterinario);
	}

	@Transactional
	@Override
	public void actualizarVeterinario(Veterinario veterinario) {
		veterinarioDao.update(veterinario);
		
	}

	@Transactional
	@Override
	public List<Veterinario> insertarVeterinario(Veterinario veterinario) {
		return veterinarioDao.add(veterinario);
	}
}

