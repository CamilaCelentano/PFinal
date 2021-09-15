package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.RespuestaCasillaDAO;
import com.entities.RespuestaCasilla;
import com.exception.ServiciosException;

@Stateless
public class RespuestaCasillaBean implements RespuestaCasillaBeanRemote {

	@EJB
	RespuestaCasillaDAO resCas;

	public RespuestaCasillaBean() {

	}

	@Override
	public void crear(RespuestaCasilla g) throws ServiciosException {
		resCas.crear(g);
	}

	@Override
	public void actualizar(RespuestaCasilla g) throws ServiciosException {
		resCas.actualizar(g);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		resCas.borrar(id);

	}

	@Override
	public List<RespuestaCasilla> obtenerTodos() {
		return resCas.obtenerTodos();
	}

}
