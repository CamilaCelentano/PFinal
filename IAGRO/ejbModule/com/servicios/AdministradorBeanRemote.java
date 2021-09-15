package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Administrador;
import com.exception.ServiciosException;

@Remote
public interface AdministradorBeanRemote {
	
	public void crear(Administrador f) throws ServiciosException;

	public void actualizar(Administrador f) throws ServiciosException;

	public void borrar(Long id) throws ServiciosException;

	public List<Administrador> obtenerTodos();

	public Administrador buscarPorCedula(String ci);
}

