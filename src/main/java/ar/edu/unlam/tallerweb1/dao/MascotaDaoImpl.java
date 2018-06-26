package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Mascota;

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
		
		/*	@Override
		public Mascota getIdDao(Long id){
			final Session session = sessionFactory.getCurrentSession();
			return (Mascota) session.createCriteria(Mascota.class)				
					.add(Restrictions.eq("id",id))
					.uniqueResult();

		}*/

}
