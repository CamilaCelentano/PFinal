package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.GeopuntoDAO;
import com.entities.Geopunto;
import com.exception.ServiciosException;
@Local
@Stateless
public class GeopuntoBean{

	@EJB
	GeopuntoDAO geopunto;

	public void crear(Geopunto g) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.crear(g);
	}

	public void actualizar(Geopunto g) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.actualizar(g);
	}

	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.borrar(id);
	}

	public List<Geopunto> obtenerTodos() {
		// TODO Auto-generated method stub
		return geopunto.obtenerTodos();
	}

	public Geopunto buscar(Long lon, Long lat) {
		return geopunto.buscar(lon, lat);
	}

	public GeopuntoBean() {
		// TODO Auto-generated constructor stub
	}

}
