package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.exception.ServiciosException;

@Remote
public interface DepartamentoBeanRemote {
	public void crear(Departamento d) throws ServiciosException;
	public void actualizar(Departamento d) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<Departamento> obtenerTodos();
}
