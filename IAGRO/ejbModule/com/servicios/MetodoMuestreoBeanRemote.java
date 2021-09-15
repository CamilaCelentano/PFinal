package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;

@Remote
public interface MetodoMuestreoBeanRemote {
	public void crear(MetodoMuestreo m) throws ServiciosException;
	public void actualizar(MetodoMuestreo m) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<MetodoMuestreo> obtenerTodos();
}
