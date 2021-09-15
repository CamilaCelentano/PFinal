package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.TareaDAO;
import com.entities.Tarea;
import com.exception.ServiciosException;

@Stateless
public class TareaBean implements TareaBeanRemote {

	@EJB
	private TareaDAO tarea;

	public TareaBean() {
		
	}

	@Override
	public void crear(Tarea f) throws ServiciosException {
		tarea.crear(f);
	}

	@Override
	public void actualizar(Tarea f) throws ServiciosException {
		tarea.actualizar(f);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		tarea.borrar(id);
	}

	@Override
	public List<Tarea> obtenerTodos() {
		return tarea.obtenerTodos();
	}

	@Override
	public Tarea buscarPorNombre(String nom) {
		return tarea.buscarPorNombre(nom);
	}

}
