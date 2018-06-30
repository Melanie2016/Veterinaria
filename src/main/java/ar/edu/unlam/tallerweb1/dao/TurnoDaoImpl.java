package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import org.hibernate.criterion.*;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;

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
	public List<DiaAtencion> consultarVeterinarioDao(Long especialidadId){
		final Session session = sessionFactory.getCurrentSession();
	
		return session.createCriteria(DiaAtencion.class,"classGral")
				.createAlias("classGral.especialidad", "espBuscada")
				.createAlias("classGral.veterinario","vetBuscado")
				.add(Restrictions.eq("espBuscada.especialidadId",especialidadId))
				.setProjection(Projections.distinct(Projections.property("veterinario")))

//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
//				.setProjection(Projections.projectionList() // para hacer un group by y muestre una vez cada nombre 
//					.add(Projections.groupProperty("classGral.veterinario.veterinarioId"))
//                ) // el problema con esto es q solo devuelve una lista de nombres . y si necesito otro dato del vet no lo puedo obtener
				.list();
				

		
			}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> consultarDisponibilidadDao(Long veterinarioId){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(DiaAtencion.class,"classGral")
				.createAlias("classGral.veterinario","vetBuscado")
				.add(Restrictions.eq("vetBuscado.veterinarioId",veterinarioId)) 
				.list();
		
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
