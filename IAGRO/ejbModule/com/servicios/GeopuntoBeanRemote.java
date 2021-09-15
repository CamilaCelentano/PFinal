package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Geopunto;
import com.exception.ServiciosException;

@Remote
public interface GeopuntoBeanRemote {
	public void crear(Geopunto g) throws ServiciosException;
	public void actualizar(Geopunto g) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<Geopunto> obtenerTodos();
	public Geopunto buscar(Long lon, Long lat);
}
