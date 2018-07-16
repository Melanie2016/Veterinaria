package ar.edu.unlam.tallerweb1.controladores;

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
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorMascota {
	
	@Inject
	private ServicioMascota servicioMascota;
	@Inject
	private ServicioLogin servicioLogin;

	
			@RequestMapping("/vacunas/{idMascota}")
			public ModelAndView irAvacunas(@PathVariable Long idMascota) {
				
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
						
				return new ModelAndView("vacunas",modelo);
			}
	/*esto deberia levar a una vista aparte para mostrar la fecha de aplicacion pero 
	 * sumandole 12 meses, pero ahora solo funciona usando la fecha de HOY y le suma un año*/		
			@RequestMapping("/revacunar/{idEstadoVacuna}/{fecha}")
			public ModelAndView irArevacunar(@PathVariable Long idEstadoVacuna,@PathVariable(value = "fecha") String fecha) {
				
				ModelMap modelo = new ModelMap();
				modelo.put("ev",servicioMascota.getIdEV(idEstadoVacuna));
			
				modelo.put("rev",servicioMascota.mostrarRevacunacion(fecha));	
				System.out.println("El id de estado vacuna es--> " + idEstadoVacuna);
				System.out.println("fecha de aplicacion es--> " + fecha);
				
				return new ModelAndView("revacunar",modelo);
			}
			
			
			//Para agregar una mascota..{id}@PathVariable Long id para k envie iddeususario
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



