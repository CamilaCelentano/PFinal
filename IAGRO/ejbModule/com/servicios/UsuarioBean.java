package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.UsuarioDAO;
import com.entities.Administrador;
import com.entities.Usuario;
import com.exception.ServiciosException;
@Local
@Stateless
public class UsuarioBean {
	/* public class UsuarioBean implements UsuarioBeanRemote { */

	@EJB
	UsuarioDAO usuario;

//	public void crear(Usuario f) throws ServiciosException {
//		usuario.crear(f);
//	}
//
//	@Override
//	public void actualizar(Usuario f) throws ServiciosException {
//		usuario.actualizar(f);
//	}
//
	public void borrar(Long id) throws ServiciosException {
		usuario.borrar(id);
	}

	public List<Usuario> obtenerTodos() {
		return usuario.obtenerTodos();
	}

	public Usuario buscarPorNombreUsuario(String nom) {
		return usuario.buscarPorNombreUsuario(nom);
	}

	public Usuario buscarPorMail(String email) {
		return usuario.buscarPorMail(email);
	}

	public UsuarioBean() {

	}

}
