package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.RespuestaCasilla;
import com.exception.ServiciosException;

@Stateless
public class RespuestaCasillaDAO {

	@PersistenceContext
	private EntityManager em;

	public RespuestaCasillaDAO() {

	}
	
	public void crear(RespuestaCasilla g) throws ServiciosException {
		try {
			em.persist(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la Respuesta Casilla.");
		}
	}

	public void actualizar(RespuestaCasilla g) throws ServiciosException {
		try {
			em.merge(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Respuesta Casilla.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			RespuestaCasilla g = em.find(RespuestaCasilla.class, id);
			em.remove(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Respuesta Casilla.");
		}

	}

	public List<RespuestaCasilla> obtenerTodos() {
		TypedQuery<RespuestaCasilla> query = em.createQuery("SELECT a FROM RespuestaCasilla a", RespuestaCasilla.class);
		return query.getResultList();
	}

//	public RespuestaCasilla buscar() {
//		TypedQuery<RespuestaCasilla> query = em
//				.createQuery("SELECT a FROM RespuestaCasilla a WHERE a.longitud = :lon AND a.latitud = :lat", RespuestaCasilla.class)
//				.setParameter("lon", lon).setParameter("lat", lat);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

}
