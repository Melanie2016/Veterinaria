package ar.edu.unlam.tallerweb1.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MascotaDao;
import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
@Service("servicioMascota")
@Transactional
public class ServicioMascotaImpl implements ServicioMascota{
	
	@Inject
	private MascotaDao servicioMascotaDao;
	
	
	@Override
	public List<Mascota> mostrarMascotas(){
		return servicioMascotaDao.mostrarMascotasDao();
		
	}
	
	@Override	
	//que me muestre por el id ingresado
	public Mascota getId(Long id) {
        return servicioMascotaDao.getIdDao(id);
    }
	
	@Override
	public List<EstadoVacuna> mostrarEstadoVacunas(Long idMascota){
		return servicioMascotaDao.mostrarEstadoVacunasDao(idMascota);
		
	}	
	
	//para el stock
	@Override
	public List<Vacuna> mostrarVacunas(){
		return servicioMascotaDao.mostrarVacunasDao();	
	}
	
	public Vacuna getIdVac(Long id) {
        return servicioMascotaDao.getIdVacDao(id);
    }
	
	 public int consultarStock(){ 
	 List<Vacuna> listaVacunas= servicioMascotaDao.mostrarVacunasDao();	 
		for (Vacuna vacuna : listaVacunas) {
			if (vacuna.getCantStock() < 20) 
			return 0;				
	 }
	return 1;
  }	
	 
	 
	//que me muestre por el id ingresado estado vacuna
		public EstadoVacuna getIdEV(Long id) {
	        return servicioMascotaDao.getIdEVDao(id);
	    }
	 
	 
	 @Override
		public List<Mascota> mostrarMascotasDeUno(Long idUsuario){
			return servicioMascotaDao.mostrarMascotasDeUnoDao(idUsuario);		
		}
	 
	 
	 @Override 
		public void cargaDeMascota(Mascota mascota) {
			 servicioMascotaDao.cargaDeMascotaDao(mascota);
		}
		
		@Override 
		public void editDeMascota(Mascota mascota) {
			servicioMascotaDao.editDeMascotaDao(mascota);
		}
		
		@Override 
		public void eliminarMascota(Mascota mascota) {
			servicioMascotaDao.eliminarMascotaDao(mascota);
		}
			
		
	// para revacunar
	@Override
	public EstadoVacuna consultaEstadoVacuna(Long idEstadoVacuna) {
		return  servicioMascotaDao.consultaEstadoVacunaDao(idEstadoVacuna);
	}
	
	
	@Override
	public Date mostrarRevacunacion(EstadoVacuna estadoVacuna){
		
//		estadoVacuna.getId();
		
		Calendar fechaGC = new GregorianCalendar();
		fechaGC.setTime(estadoVacuna.getFecha_aplicacion());
		
		fechaGC.add(Calendar.MONTH, 12);
		 
		return fechaGC.getTime();
	
	}
	
	//notificacion si falta alguna vacuna
	
	public int consultarEstado(Long idUsuario){
		 
		int	 contadorDeNo=0;
		//recorro las mascotas de un duenio
		List<Mascota> listaMascotas= servicioMascotaDao.mostrarMascotasDeUnoDao(idUsuario);  
		for (Mascota m : listaMascotas) {
			
			//recorro las vacunas de esa mascota
			Long idMascota=m.getId();//agarro el id de la mascota
			
			List<EstadoVacuna> listaVacunas= servicioMascotaDao.mostrarEstadoVacunasDao(idMascota);   
			for (EstadoVacuna ev : listaVacunas) {
		
				if(ev.getEstado().equals("no")){
					contadorDeNo++;	
				}
				
			}//for vacunas
		 
		 
		 }//for mascotas
			return	contadorDeNo;	
		}
	
	//cuanta la cantidad de mascotas (perros)	 
	 public int contarMascotas(){
		 
	List<Mascota> lista =servicioMascotaDao.mostrarMascotasDao();	
	int cant=0;
	for (Mascota m : lista) {
			 
	 if (m.getTipo().equals("Perro")){
		 
		cant++; 
	 }
	 
	}
	return cant; 
}	 
	
}
