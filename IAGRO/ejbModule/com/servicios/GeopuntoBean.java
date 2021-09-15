package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.GeopuntoDAO;
import com.entities.Geopunto;
import com.exception.ServiciosException;

@Stateless
public class GeopuntoBean implements GeopuntoBeanRemote {

	@EJB
	GeopuntoDAO geopunto;

	@Override
	public void crear(Geopunto g) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.crear(g);
	}

	@Override
	public void actualizar(Geopunto g) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.actualizar(g);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		geopunto.borrar(id);
	}

	@Override
	public List<Geopunto> obtenerTodos() {
		// TODO Auto-generated method stub
		return geopunto.obtenerTodos();
	}

	@Override
	public Geopunto buscar(Long lon, Long lat) {
		return geopunto.buscar(lon, lat);
	}

	public GeopuntoBean() {
		// TODO Auto-generated constructor stub
	}

}
