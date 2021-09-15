package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ActividadCampo;
import com.exception.ServiciosException;

@Remote
public interface ActividadCampoBeanRemote {

	public void crear(ActividadCampo ac) throws ServiciosException;
	public void actualizar(ActividadCampo ac) throws ServiciosException;
	public void borrar(Long id) throws ServiciosException;
	public List<ActividadCampo> obtenerTodos();
//	public ActividadCampo buscarPorNombre(String nom);
//	public ActividadCampo buscarPorForm(String form);
//	public ActividadCampo buscarPorFecha(String fecha);
//	public ActividadCampo buscarPorMetM(String metM);
//	public ActividadCampo buscarPorEstM(String estM);
//	public ActividadCampo buscarPorUsuerio(String usuario);
}
