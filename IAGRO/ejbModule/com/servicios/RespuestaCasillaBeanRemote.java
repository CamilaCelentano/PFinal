package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.RespuestaCasilla;
import com.exception.ServiciosException;

@Remote
public interface RespuestaCasillaBeanRemote {
	public void crear(RespuestaCasilla g) throws ServiciosException;
	public void actualizar(RespuestaCasilla g) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<RespuestaCasilla> obtenerTodos();
}
