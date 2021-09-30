package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.CasillaDAO;
import com.entities.Casilla;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class CasillaBean
 */
@Local
@Stateless
public class CasillaBean {

	@EJB
	CasillaDAO casilla;

	public CasillaBean() {

	}

	public void crear(Casilla c) throws ServiciosException {
		casilla.crear(c);
	}

	public void actualizar(Casilla c) throws ServiciosException {
		casilla.crear(c);
	}

	public void borrar(Long id) throws ServiciosException {
		casilla.borrar(id);
	}

	public List<Casilla> obtenerTodos() {
		return casilla.obtenerTodos();
	}

	public Casilla buscar(String nom) {
		return casilla.buscar(nom);
	}

}
