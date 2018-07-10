package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.EstadoVacuna;
import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import ar.edu.unlam.tallerweb1.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioVacuna;

@Controller
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;
	private ServicioVacuna servicioVacuna;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {			
	     request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
	     request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
	     
	     if (usuarioBuscado.getRol().equals("admin")) {
				return new ModelAndView("redirect:/perfilAdmin");
			}
			if (usuarioBuscado.getRol().equals("cliente")) {
				return new ModelAndView("redirect:/perfil");
			}
			if (usuarioBuscado.getRol().equals("vet")) {
				return new ModelAndView("redirect:/perfilVet");
			}
			return new ModelAndView("redirect:/index");

		} else {
			model.put("error", "Usuario o clave incorrecta");
		
		} 
				
		return new ModelAndView("login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
	
	//cuando se aprete el boton cerrar sesion se desloguea y lleva al inicio	
		@RequestMapping("cerrarSession")
	public ModelAndView cerrarSession(HttpServletRequest request) {
			request.getSession().setAttribute("rol", null);
			request.getSession().setAttribute("id", null);
			return new ModelAndView("redirect:/login");
		}
	
	//Para probar las vistas del formulario.
	@RequestMapping("/formMascota")
	public ModelAndView sacarTurno() {
		String msj = "hola";
		ModelMap model =new ModelMap();
		
		model.put("datos", msj);
		
		return new ModelAndView ("formMascota",model);
	}
	
	@RequestMapping("/perfilAdmin")
	public ModelAndView mostrarPerfilAdmin() {		
		
		ModelMap model =new ModelMap();
	//	List<Vacuna> vacuna = servicioVacuna.mostrarVacunas();
	//	model.put("vacuna", vacuna);	
	//	model.put("id",vacuna);
	//	model.put("nombreVacuna",vacuna);
	//	model.put("cantidad",vacuna);
		Usuario admin = new Usuario();		
		model.put("admin", admin);	
		    return new ModelAndView ("perfilAdmin",model);
		
	}
	
	@RequestMapping("/perfilVet")
	public ModelAndView mostrarPerfilVet() {		
		
		ModelMap model =new ModelMap();
		Usuario vet = new Usuario();
		model.put("vet", vet);	
		    return new ModelAndView ("perfilVet",model);
		
	}
	
	// test de mockito controlador
	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}
	
}
