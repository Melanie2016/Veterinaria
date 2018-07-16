package ar.edu.unlam.tallerweb1.servicios;

import java.util.Calendar;
import java.util.Date;
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
	
	//intento se suprimir el if del html pero con servicio
	//no funciona ya que no tengo el idEstadoVacuna y 
	//en el html debo informar al href a que vista ir
/*	@Override
	 public int consultarEstado(Long idMascota){ 
	 List<EstadoVacuna> listaEV= servicioMascotaDao.mostrarEstadoVacunasDao(idMascota);	 
		for (EstadoVacuna ev : listaEV) {
			if (ev.getEstado()=="no")
				System.out.println("Estado-----> " + ev.getEstado());
			return 0;				
	 }
	return 1;
 }
*/	
	
	
	
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
	 
	 
	 //intento revacunacion
	 
	//que me muestre por el id ingresado estado vacuna
		public EstadoVacuna getIdEV(Long id) {
	        return servicioMascotaDao.getIdEVDao(id);
	    }
	 
	 @Override
		public Date mostrarRevacunacion(String fecha){
			//recibo la fecha como un string
			System.out.println("fecha de aplicacion es--> " + fecha);

			//intento convertirla del tipo DATE	    
			/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			 //otra forma: SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	        try {

	            Date date = formatter.parse(fecha);
	           //otra forma Date date = formatter.parse(fecha.replaceAll("Z$", "+0000"));
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(date);
	            cal.add(Calendar.MONTH, 12);
	            Date nuevaFecha = cal.getTime();
	            return nuevaFecha;

	       } catch (ParseException e) {
	           e.printStackTrace();
	        }
		*/
			
			//otro intento---default, ISO_LOCAL_DATE
	       // LocalDate localDate = LocalDate.parse(fecha);
			
			//PROVISORIO calcula sobre la fecha de hoy, y le suma meses			
	        Calendar cal = Calendar.getInstance(); 
			Date hoy = new Date();	
	        cal.setTime(hoy); 
	        cal.add(Calendar.MONTH, 12);
	        Date nuevaFecha = cal.getTime();
	        System.out.println("fecha aumentada es--> " + nuevaFecha);
	        return nuevaFecha;
		}
	 
	 @Override
		public List<Mascota> mostrarMascotasDeUno(Long idUsuario){
			return servicioMascotaDao.mostrarMascotasDeUnoDao(idUsuario);		
		}
	 
	 
	 @Override 
		public void cargaDeMascota(Mascota mascota) {
			 servicioMascotaDao.cargaDeMascotaDao(mascota);
		}
		
		/*@Override 
		public void editDeMascota(Mascota mascota) {
			servicioMascotaDao.editDeMascotaDao(mascota);
		}*/
		
		@Override 
		public void eliminarMascota(Mascota mascota) {
			servicioMascotaDao.eliminarMascotaDao(mascota);
		}
}
