package ar.edu.unlam.tallerweb1.controladores;

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

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioVeterinario;


@Controller
public class ControladorVeterinarioAbm {

	
	@Inject
	private ServicioVeterinario servicioVeterinario;
	
	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping(path ="/editarVeterinario/{veterinarioId}", method = RequestMethod.GET)
	public ModelAndView irAeditar(HttpServletRequest request,@PathVariable Long veterinarioId) {
		
		ModelMap modelo = new ModelMap();
		Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
		modelo.put("usuario", usuarioLogueado);
		Veterinario veterinario=new Veterinario();
		modelo.put("veterinario", servicioVeterinario.getVeterinarioId(veterinarioId));
		modelo.put("veterinarioId", veterinario);
			
		return new ModelAndView("editarVeterinario",modelo);
	}
	@RequestMapping(path ="/validarEdicionVet/", method = RequestMethod.POST)
	public ModelAndView validarEdicion(@ModelAttribute("veterinario") Veterinario veterinario,BindingResult bindingResult,HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("veterinario", modelo);
        veterinario.setNombre(veterinario.getNombre());
        veterinario.setApellido(veterinario.getApellido());
    
		servicioVeterinario.editDeVeterinario(veterinario);
		modelo.put("aviso", "Se EDITO correctamente");
	
		return new ModelAndView("editarVeterinario",modelo);
	}
	@RequestMapping("/formVet")
	public ModelAndView ingresarVet(HttpServletRequest request) {
		
		ModelMap model =new ModelMap();
		Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
		model.put("usuario", usuarioLogueado);
		Veterinario vet=new Veterinario();
		model.put("vet", vet);	
		return new ModelAndView ("formVet",model);
	}
	
	//conecto el form con la validacion ,BindingResult bindingResult
	@RequestMapping(path="/validarVet",method=RequestMethod.POST)
	public ModelAndView irAValidarVet(@ModelAttribute ("vet") Veterinario vet,BindingResult bindingResult,HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("vet", modelo);
		modelo.put("nombre", modelo);
		modelo.put("apellido", modelo);
		servicioVeterinario.guardarVeterinario(vet);
		modelo.put("aviso", "Se CREO exitosamente");
		
		
	return new ModelAndView("correcto",modelo);
	}
	
	@RequestMapping(path="/eliminarVet/{veterinarioiId}")
	public ModelAndView irAeliminarVet(@ModelAttribute ("veterinario") Veterinario veterinario) {
		
		ModelMap modelo = new ModelMap();	
		servicioVeterinario.eliminarVeterinario(veterinario);	
        modelo.put("veterinario", modelo);
        modelo.put("id", veterinario);
		modelo.put("aviso", "ELIMINACION Exitosa");
		return new ModelAndView("correcto",modelo);
	}	
	
	
}
