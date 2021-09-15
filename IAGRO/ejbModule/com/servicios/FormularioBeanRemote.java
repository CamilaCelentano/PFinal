package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Formulario;
import com.exception.ServiciosException;

@Remote
public interface FormularioBeanRemote {
	public void crear(Formulario f) throws ServiciosException;
	public void actualizar(Formulario f) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<Formulario> obtenerTodos();
	public Formulario buscar(String nom);
	public void asignarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException; 
	public void borrarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException;
}
