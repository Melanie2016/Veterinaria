package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;

@Repository("mascotaDao")
public class MascotaDaoImpl implements MascotaDao{
	@Inject
	private SessionFactory sessionFactory;
	
	
	//mustra la lista sacando info de la bd
		@SuppressWarnings("unchecked")
		@Override
		public List<Mascota> mostrarMascotasDao(){
			
			final Session session = sessionFactory.getCurrentSession();
			return session.createCriteria(Mascota.class)
					.add(Restrictions.isNotNull("id"))
					.list();
		}
		
			@Override
		public Mascota getIdDao(Long id){
			final Session session = sessionFactory.getCurrentSession();
			return (Mascota) session.createCriteria(Mascota.class)				
					.add(Restrictions.eq("id",id))
					.uniqueResult();

		}
			
			@SuppressWarnings("unchecked")
			@Override
			public List<EstadoVacuna> mostrarEstadoVacunasDao(Long idMascota){
				final Session session = sessionFactory.getCurrentSession();
				return session.createCriteria(EstadoVacuna.class,"estado")
						.createAlias("estado.mascota", "mascotaBuscado")
						.add(Restrictions.eq("mascotaBuscado.id",idMascota))
						.list();
			}
			
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Vacuna> mostrarVacunasDao(){
				
				final Session session = sessionFactory.getCurrentSession();
				return session.createCriteria(Vacuna.class)
						.add(Restrictions.isNotNull("id"))
						.list();
			}
			
			// para el stock
			@Override
			public Vacuna getIdVacDao(Long id){
				final Session session = sessionFactory.getCurrentSession();
				return (Vacuna) session.createCriteria(Vacuna.class)				
						.add(Restrictions.eq("id",id))
						.uniqueResult();
			}

			//intento revacunacion
			@Override
			public EstadoVacuna getIdEVDao(Long id){
				final Session session = sessionFactory.getCurrentSession();
				return (EstadoVacuna) session.createCriteria(EstadoVacuna.class)				
						.add(Restrictions.eq("id",id))
						.uniqueResult();

			}
}
