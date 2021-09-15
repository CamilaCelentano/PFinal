package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstacionMuestreo;
import com.exception.ServiciosException;

@Remote
public interface EstacionMuestreoBeanRemote {
	public void crear(EstacionMuestreo m) throws ServiciosException;
	public void actualizar(EstacionMuestreo m) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<EstacionMuestreo> obtenerTodos();
}
