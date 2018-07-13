package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorAdmin {
	
	@Inject
	private ServicioMascota servicioMascota;
	
	
	
	@RequestMapping("/perfilAdmin")
	public ModelAndView mostrarPerfilVet() {		
		
		ModelMap model =new ModelMap();
		Usuario admin = new Usuario();
		model.put("admin", admin);	
			
		Integer aviso =servicioMascota.consultarStock();
			if(aviso==0){
				model.put("aviso", "Revisar el Stock de Vacunas, quedan pocas");
			}else
			{ model.put("aviso", ">>No hay notificaciones para mostrar<<");}
		
	 return new ModelAndView ("perfilAdmin",model);
		
	}
	
	
	@RequestMapping(path="/stockVacunas", method=RequestMethod.GET)
	public ModelAndView mostrarPerfilAdmin() {			
		ModelMap model =new ModelMap();
		List<Vacuna> list =servicioMascota.mostrarVacunas(); 
		model.put("vacuna", list);
		model.put("id", list);
		model.put("nombreVacuna", list);
		model.put("vencimiento", list);
		model.put("animal", list);
		model.put("cantStock", list);

		    return new ModelAndView ("stockVacunas",model);
		
	}

}
