package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	Usuario buscarPorId(Long id);
	
	Usuario consultarUsuarioPorMailDao (Usuario usuario);
	Usuario findById(Long id);
	
	void save(Usuario usuario);
	void update(Usuario usuario);
	List<Usuario> findAll();
}
