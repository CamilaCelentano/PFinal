package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Comun;
import com.exception.ServiciosException;

@Remote
public interface ComunBeanRemote {

	public void crear(Comun f) throws ServiciosException;

	public void actualizar(Comun f) throws ServiciosException;

	public void borrar(Long id) throws ServiciosException;

	public List<Comun> obtenerTodos();
	
	public Comun buscarPorNombreUsuario(String nom);

	public Comun buscarPorMail(String email);

}
