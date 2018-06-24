package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import org.hibernate.criterion.*;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {

	@Inject 
	private SessionFactory sessionFactory;
	
	/*
	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> listaDeVeterinariosDao(){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Veterinario.class)
				.add(Restrictions.isNotNull("id"))
				.list();
	}*/
	
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
	public List<Especialidad> consultarVeterinarioDao(Especialidad especialidad){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(DiaAtencion.class,"classGral")
				.createAlias("classGral.veterinario","vetBuscado")
				.createAlias("classGral.especialidad","espBuscado")
				.add(Restrictions.eq("espBuscado.descripcion",especialidad.getDescripcion()))
				.setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("vetBuscado.nombre"))
                        )
				.list();

		
			}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidad> consultarDisponibilidadDao(Especialidad especialidad){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(DiaAtencion.class,"classGral")
				.createAlias("classGral.veterinario","vetBuscado")
				.createAlias("classGral.especialidad","espBuscado")
				.add(Restrictions.eq("espBuscado.descripcion",especialidad.getDescripcion()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)// supuestamente para hacer el distinct 
				.list();
		
			}
	
	
	
}
