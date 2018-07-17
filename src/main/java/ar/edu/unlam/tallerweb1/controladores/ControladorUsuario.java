package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Mascota;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMascota;

@Controller
public class ControladorUsuario {
	
	@Inject
	private ServicioMascota servicioMascota;
	@Inject
	private ServicioLogin servicioLogin;
	
	
		@RequestMapping("/perfil")
		public ModelAndView mostrarPerfilHumano(HttpServletRequest request) {
			
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			ModelMap model =new ModelMap();
			if (idUsuario != null) {
				if (servicioLogin.buscarPorId(idUsuario).getRol().equals("cliente")) {
			//datos de quien se logeo
			Usuario usuarioLogueado = servicioLogin.buscarPorId((Long) request.getSession().getAttribute("idUsuario"));		
			model.put("usuario", usuarioLogueado);
			model.put("id", usuarioLogueado);
			model.put("email", usuarioLogueado);				
				
			List<Mascota> mascota =servicioMascota.mostrarMascotasDeUno(idUsuario); 
			model.put("mascota",mascota);
			model.put("id",mascota);
					
			//notificacion si falta aplicar vacunas
			int cant = servicioMascota.consultarEstado(idUsuario);
			if (cant>0){
				model.put("aviso", " Tiene "+ cant+ " vacunas sin aplicar ");
			}else
			{ model.put("aviso", ">>No hay notificaciones para mostrar<<");}
					
			return new ModelAndView ("perfil",model);
			}//por rol
				
			else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para acceder usted debe tener rol CLIENTE");
			return new ModelAndView("mensaje", model);}
			}//usuario null
				return new ModelAndView("redirect:/login");}
		
		/*
		  //contar cant de mascotas
					Integer cantPerros =servicioMascota.contarMascotas();
					 modelo.put("aviso", "Usted tiene:" + cantPerros + "perros" );*/
	
}
