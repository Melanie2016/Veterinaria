package ar.edu.unlam.tallerweb1.controladores;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorMascota {
	
	@Inject
	private ServicioMascota servicioMascota;
	@Inject
	private ServicioLogin servicioLogin;

	
	@RequestMapping("/vacunas/{idMascota}")
	public ModelAndView irAvacunas(@PathVariable Long idMascota,HttpServletRequest request) {
				
		ModelMap modelo = new ModelMap();
		List<EstadoVacuna> vacuna = servicioMascota.mostrarEstadoVacunas(idMascota);
	
		modelo.put("id",vacuna);
		modelo.put("vacuna",vacuna);
		modelo.put("fecha_aplicacion",vacuna);
		modelo.put("estado",vacuna);
		modelo.put("vencimiento",vacuna);
	
		Mascota mascota = new Mascota(); 
		modelo.put("mascota",servicioMascota.getId(idMascota));
		modelo.put("nombre",mascota);
		
		//valida la edad para la vacuna que solo se aplica al ser cachorro
		int edad =servicioMascota.consultarEdad(idMascota);
		if(edad==0){
			modelo.put("avisoQuintuple", "Aplicar antes del primer anio de edad");
		}else
		{ modelo.put("avisoQuintuple", "Ya no se aplica");}
		
		return new ModelAndView("vacunas",modelo);
	}
		
	@RequestMapping("/revacunar/{idEstadoVacuna}")
	public ModelAndView irArevacunar(@PathVariable Long idEstadoVacuna) {
					
		ModelMap modelo = new ModelMap();
						
		EstadoVacuna estadoVacuna = servicioMascota.consultaEstadoVacuna(idEstadoVacuna);
		Date revacunacion = servicioMascota.mostrarRevacunacion(estadoVacuna);
		
		modelo.put("vacunaNombre", estadoVacuna.getVacuna().getNombreVacuna());
		
		modelo.put("rev", revacunacion);
					
		return new ModelAndView("revacunar",modelo);
	}
		

			@RequestMapping("/formMascota")
			public ModelAndView ingresarMascota(HttpServletRequest request) {
				
				ModelMap model =new ModelMap();
				Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
				model.put("usuario", usuarioLogueado);
				Mascota mascota=new Mascota();
				model.put("mascota", mascota);	
				return new ModelAndView ("formMascota",model);
			}
			
			//conecto el form con la validacion
			//BindingResult:solucion de stackoverflow por error 400
			@RequestMapping(path="/validarMascota",method=RequestMethod.POST)
			public ModelAndView irAValidarMascota(@ModelAttribute ("mascota") Mascota mascota,BindingResult bindingResult,HttpServletRequest request) {
				
				ModelMap modelo = new ModelMap();
				modelo.put("mascota", modelo);
				mascota.setDuenio(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario")));
				servicioMascota.cargaDeMascota(mascota);
				modelo.put("aviso", "Se CREO exitosamente");
				
				
			return new ModelAndView("correcto",modelo);
			}
			
			//editar: NO FUNCIONa
			@RequestMapping(path ="/editarMascota/{idMascota}", method = RequestMethod.GET)
			public ModelAndView irAeditar(HttpServletRequest request,@PathVariable Long idMascota) {
				
				ModelMap modelo = new ModelMap();
				Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
				modelo.put("usuario", usuarioLogueado);
				Mascota mascota=new Mascota();
				modelo.put("mascota", servicioMascota.getId(idMascota));
				modelo.put("id", mascota);
					
				return new ModelAndView("editarMascota",modelo);
			}
			//guardar edicion:NO ANDA
			@RequestMapping(path ="/validarEdicion/", method = RequestMethod.POST)
			public ModelAndView validarEdicion(@ModelAttribute("mascota") Mascota mascota,BindingResult bindingResult,HttpServletRequest request) {
				
				ModelMap modelo = new ModelMap();
				modelo.put("mascota", modelo);
				mascota.setDuenio(servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario")));
                mascota.setNombre(mascota.getNombre());
                mascota.setEdad(mascota.getEdad());
                mascota.setTipo(mascota.getTipo());
            
				servicioMascota.editDeMascota(mascota);
				modelo.put("aviso", "Se EDITO correctamente");
			
				return new ModelAndView("correcto",modelo);
			}
			
			@RequestMapping(path="/eliminar/{id}")
			public ModelAndView irAeliminar(@ModelAttribute ("mascota") Mascota mascota) {
				
				ModelMap modelo = new ModelMap();	
				servicioMascota.eliminarMascota(mascota);	
				modelo.put("farmacia", modelo);	
				modelo.put("id", mascota);
				modelo.put("aviso", "ELIMINACION Exitosa");
				return new ModelAndView("correcto",modelo);
			}


	}



