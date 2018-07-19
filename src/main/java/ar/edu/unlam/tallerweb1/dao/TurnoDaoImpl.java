package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.DiaAtencion;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;

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
	
	// http://www.mballem.com/post/hibernate-projections-com-api-criteria/?i=1
	@SuppressWarnings("unchecked")
	@Override
	public List<DiaAtencion> consultarVeterinarioDao(Long especialidadId){
		final Session session = sessionFactory.getCurrentSession();
	
		return session.createCriteria(DiaAtencion.class,"classGral")
				.createAlias("classGral.especialidad", "espBuscada")
				.createAlias("classGral.veterinario","vetBuscado")
				.add(Restrictions.eq("espBuscada.especialidadId",especialidadId))
//				.setProjection(Projections.distinct(Projections.property("veterinario"))) //si funca
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
//				.setProjection(Projections.projectionList() // para hacer un group by y muestre una vez cada nombre 
//					.add(Projections.groupProperty("classGral.veterinario.veterinarioId"))
//                ) // el problema con esto es q solo devuelve una lista de nombres . y si necesito otro dato del vet no lo puedo obtener
				.list();
				

		
			}
	

	
//	@SuppressWarnings("unchecked")
//	@Override
//	public Integer buscarDuracionDao(Long veterinarioId,Long especialidadId) {
//		final Session session = sessionFactory.getCurrentSession();
//		
//		Criteria criteria = session.createCriteria(Duracion.class,"classGral")
//				.createAlias("classGral.veterinario","vetBuscado")
//				.createAlias("classGral.especialidad","espBuscada")
//				.add(Restrictions.eq("vetBuscado.veterinarioId",veterinarioId))
//				.add(Restrictions.eq("espBuscada.especialidadId",especialidadId))
//				.setProjection(Projections.projectionList() // para hacer un group by y muestre una vez cada nombre 
//						.add(Projections.groupProperty("classGral.tiempo"))
//	                );
//		
//		Integer duracion = (Integer) criteria.uniqueResult();
//				
//		return duracion;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turno> listaDeTurnosDao(Long diaAtencionId){
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Turno.class,"classGral")
				.createAlias("classGral.diaAtencion", "diaBuscado")
				.add(Restrictions.eq("diaBuscado.id", diaAtencionId))
				.list();
	}
	
	
	
	
	@Override
	public DiaAtencion obtenerDiaDeAtencion(Long diaAtencionId){
	
		final Session session = sessionFactory.getCurrentSession();
	
		return (DiaAtencion) session.createCriteria(DiaAtencion.class)
				.add(Restrictions.eq("id", diaAtencionId))
				.uniqueResult();
	}
	

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Date> obtenerHorariosOcupadosDao(Date fecha){
		final Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Fecha que llega al dao: "+fecha);
		
		Criteria criteria = session.createCriteria(Turno.class)
				 .add(Restrictions.isNotNull("id"))
				;
		List<Date> listC = criteria.list();
				
				 
		return listC ;
//		Criteria criteria = (Criteria) session.createCriteria(Turno.class)
//				.add(Restrictions.eq("fechaTurno", fecha));
//		List<Date> listC = criteria.list();
//		
//		System.out.println("resultado del CRITERIA: "+ listC);
		
//		Query query =session.createQuery(
//						"SELECT t.fechaTurno FROM Turno t WHERE fechaTurno = :fecha");
//		query.setParameter("fecha", "%"+fecha+"%");
//		List<Turno> listQ = query.list();
//	
//		System.out.println("resultado del QUERY: "+ listQ);
		
	
//	return listQ;
		
		
	}
	
	
	@Override
	public List<Turno> obtenerTurnosPosiblesDao(Date fecha, Long diaAtencionId){

		return null;
	}
	
	
	@Override
	public void registrarTurnoDao(Turno turno) {
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(turno);
	}
}
