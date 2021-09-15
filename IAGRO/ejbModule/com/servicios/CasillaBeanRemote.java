package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;
import com.exception.ServiciosException;

@Remote
public interface CasillaBeanRemote {
	public void crear(Casilla c) throws ServiciosException;

	public void actualizar(Casilla c) throws ServiciosException;

	public void borrar(Long id) throws ServiciosException;

	public List<Casilla> obtenerTodos();

	public Casilla buscar(String nom);
}
