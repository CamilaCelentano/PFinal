package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.ActividadCampoDAO;
import com.entities.ActividadCampo;
import com.exception.ServiciosException;

@Stateless
public class ActividadCampoBean implements ActividadCampoBeanRemote {

	public ActividadCampoBean() {
	}

	@EJB
	ActividadCampoDAO actividadcampo;

	@Override
	public void crear(ActividadCampo ac) throws ServiciosException {
		actividadcampo.crear(ac);
	}

	@Override
	public void actualizar(ActividadCampo ac) throws ServiciosException {
		actividadcampo.actualizar(ac);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		actividadcampo.borrar(id);
	}

	@Override
	public List<ActividadCampo> obtenerTodos() {
		return actividadcampo.obtenerTodos();
	}

//	@Override
//	public ActividadCampo buscarPorNombre(String nom) {
//		return actividadcampo.buscarPorNombre(nom);
//	}

//	@Override
//	public ActividadCampo buscarPorForm(String form) {
//		// TODO Auto-generated method stub
////		return actividadcampo.buscarPorForm(form);
//		return null;
//	}
//
//	@Override
//	public ActividadCampo buscarPorFecha(String fecha) {
//		// TODO Auto-generated method stub
//		return actividadcampo.buscarPorFecha(fecha);
//	}
//
//	@Override
//	public ActividadCampo buscarPorMetM(String metM) {
//		// TODO Auto-generated method stub
//		return null;
////		return actividadcampo.buscarPorMetM(metM);
//	}
//
//	@Override
//	public ActividadCampo buscarPorEstM(String estM) {
//		// TODO Auto-generated method stub
//		return null;
////		return actividadcampo.buscarPorEstM(estM);
//	}
//
//	@Override
//	public ActividadCampo buscarPorUsuerio(String usuario) {
//		// TODO Auto-generated method stub
//		return null;
////		return actividadcampo.buscarPorUsuerio(usuario);
//	}

}
