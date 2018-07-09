package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;

@Repository("vacunaDao")
public class VacunaDaoImpl implements VacunaDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	//mostrar la lista sacando info de la bd
			@SuppressWarnings("unchecked")
			@Override
			public List<Vacuna> mostrarVacunasDao(){
				
				final Session session = sessionFactory.getCurrentSession();
				return session.createCriteria(Vacuna.class)
						.add(Restrictions.isNotNull("id"))
						.list();
			}

}
