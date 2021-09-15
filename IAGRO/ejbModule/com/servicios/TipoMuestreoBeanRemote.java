package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoMuestreo;
import com.exception.ServiciosException;

@Remote
public interface TipoMuestreoBeanRemote {
	public void crear(TipoMuestreo t) throws ServiciosException;
	public void actualizar(TipoMuestreo t) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<TipoMuestreo> obtenerTodos();
}
