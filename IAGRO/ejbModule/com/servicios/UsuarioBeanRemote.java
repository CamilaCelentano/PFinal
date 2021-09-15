package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;

@Remote
public interface UsuarioBeanRemote {
	
//	public void crear(Usuario f) throws ServiciosException;
//
//	public void actualizar(Usuario f) throws ServiciosException;
//
//	public void borrar(Long id) throws ServiciosException;

	public List<Usuario> obtenerTodos();

	public Usuario buscarPorNombreUsuario(String nom);

	public Usuario buscarPorMail(String email);
}
