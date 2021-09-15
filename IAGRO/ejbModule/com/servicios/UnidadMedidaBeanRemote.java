package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.UnidadMedida;
import com.exception.ServiciosException;

@Remote
public interface UnidadMedidaBeanRemote {
	public void crear(UnidadMedida m) throws ServiciosException;
	public void actualizar(UnidadMedida m) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<UnidadMedida> obtenerTodos();
	public UnidadMedida buscarPorNombre(String nom);
	
}
