package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Zonas;
import com.exception.ServiciosException;

@Remote
public interface ZonasBeanRemote {
	public void crear(Zonas z) throws ServiciosException;
	public void actualizar(Zonas z) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<Zonas> obtenerTodos();
}
