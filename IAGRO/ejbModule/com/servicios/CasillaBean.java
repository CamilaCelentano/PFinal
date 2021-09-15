package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.CasillaDAO;
import com.entities.Casilla;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class CasillaBean
 */
@Stateless
public class CasillaBean implements CasillaBeanRemote {

	@EJB
	CasillaDAO casilla;

	public CasillaBean() {

	}

	@Override
	public void crear(Casilla c) throws ServiciosException {
		casilla.crear(c);
	}

	@Override
	public void actualizar(Casilla c) throws ServiciosException {
		casilla.crear(c);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		casilla.borrar(id);
	}

	@Override
	public List<Casilla> obtenerTodos() {
		return casilla.obtenerTodos();
	}

	@Override
	public Casilla buscar(String nom) {
		return casilla.buscar(nom);
	}

}
