package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Tarea;
import com.exception.ServiciosException;

@Remote
public interface TareaBeanRemote {

	public void crear(Tarea f) throws ServiciosException;

	public void actualizar(Tarea f) throws ServiciosException;

	public void borrar(Long id) throws ServiciosException;

	public List<Tarea> obtenerTodos();

	public Tarea buscarPorNombre(String nom);
}