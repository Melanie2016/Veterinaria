package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorMascota {
	
	@Inject
	private ServicioMascota servicioMascota;
	
			@RequestMapping("/perfilMascota")
			public ModelAndView mostrarPerfilMascota() {
				
				ModelMap model =new ModelMap();
				Mascota mascota = new Mascota(); 
			
				model.put("mascota", mascota);
				
				return new ModelAndView ("perfilMascota",model);
			}
			
			@RequestMapping("/vacunas/{idMascota}")
			public ModelAndView irAvacunas(@PathVariable Long idMascota) {
				
				ModelMap modelo = new ModelMap();
				List<EstadoVacuna> vacuna = servicioMascota.mostrarEstadoVacunas(idMascota);

				modelo.put("id",vacuna);
				modelo.put("vacuna",vacuna);
				modelo.put("estado",vacuna);

				Mascota mascota = new Mascota(); 
				modelo.put("mascota",servicioMascota.getId(idMascota));
				modelo.put("nombre",mascota);
						
				return new ModelAndView("vacunas",modelo);
			}
			

	}



