package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.RespuestaCasillaDAO;
import com.entities.RespuestaCasilla;
import com.exception.ServiciosException;
@Local
@Stateless
public class RespuestaCasillaBean{

	@EJB
	RespuestaCasillaDAO resCas;

	public RespuestaCasillaBean() {

	}

	public void crear(RespuestaCasilla g) throws ServiciosException {
		resCas.crear(g);
	}

	public void actualizar(RespuestaCasilla g) throws ServiciosException {
		resCas.actualizar(g);
	}

	public void borrar(Long id) throws ServiciosException {
		resCas.borrar(id);

	}

	public List<RespuestaCasilla> obtenerTodos() {
		return resCas.obtenerTodos();
	}

}
