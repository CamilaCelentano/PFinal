package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;
import com.exception.ServiciosException;

@Remote
public interface LocalidadBeanRemote {
	public void crear(Localidad l) throws ServiciosException;
	public void actualizar(Localidad l) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<Localidad> obtenerTodos();
}
