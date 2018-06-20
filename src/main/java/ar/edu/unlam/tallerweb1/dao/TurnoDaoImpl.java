package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> listaDeVeterinariosDao(){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Veterinario.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> consultarEspecialidadDao(){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Especialidad.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> consultarDisponibilidadDao(Especialidad especialidad){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Veterinario.class,"vetBuscado")
				.createAlias("vetBuscado.especialidad", "espBuscada")
				.add(Restrictions.eq("espBuscada.descripcion", especialidad.getDescripcion()))
				.list();
	}
	
	
	
}
