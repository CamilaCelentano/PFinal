package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Experto;
import com.exception.ServiciosException;

@Remote
public interface ExpertoBeanRemote {
	
	public void crear(Experto f) throws ServiciosException;

	public void actualizar(Experto f) throws ServiciosException;

	public void borrar(Long id) throws ServiciosException;

	public List<Experto> obtenerTodos();

	public Experto buscarPorCedula(String ci);
}
