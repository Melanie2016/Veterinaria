package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
	Usuario consultarUsuarioPorMail (Usuario usuario);
	Usuario buscarPorId(Long id);
}
