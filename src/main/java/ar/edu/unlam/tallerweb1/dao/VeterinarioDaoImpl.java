package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Veterinario;



@Service("VeterinarioDao")
@Transactional
public class VeterinarioDaoImpl implements VeterinarioDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> findAll() {
		
		List<Veterinario> veterinario =  sessionFactory.getCurrentSession().createCriteria(Veterinario.class).list();
		return veterinario;
	}

	@Override
	public void save(Veterinario veterinario) {
		sessionFactory.getCurrentSession().save(veterinario);		
	}


	@Override
	public Veterinario findByMatch(Veterinario veterinario) {
		return (Veterinario) sessionFactory.getCurrentSession().createCriteria(Veterinario.class)
				.add(Restrictions.eq("apellido", veterinario.getApellido()))
				.uniqueResult();
	}

	@Override
	public void update(Veterinario veterinario) {
		
		
		sessionFactory.getCurrentSession().update(veterinario);
		
	}
	
	@Override
	public void delete(Veterinario veterinario) {
		
		
		sessionFactory.getCurrentSession().delete(veterinario);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> add(Veterinario veterinario) {
		List<Veterinario> veterinarios = sessionFactory.getCurrentSession().createCriteria(Veterinario.class)
				.add(Restrictions.eq("veterinarioId", veterinario.getVeterinarioId()))
				.add(Restrictions.eq("apellido", veterinario.getApellido()))
				.list();
		return veterinarios;
	}


}
