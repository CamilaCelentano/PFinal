package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Geopunto;
import com.exception.ServiciosException;

@Stateless
public class GeopuntoDAO {

	@PersistenceContext
	private EntityManager em;

	public GeopuntoDAO() {

	}

	public void crear(Geopunto g) throws ServiciosException {
		try {
			em.persist(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el Geopunto.");
		}
	}

	public void actualizar(Geopunto g) throws ServiciosException {
		try {
			em.merge(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el Geopunto.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Geopunto g = em.find(Geopunto.class, id);
			em.remove(g);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Geopunto.");
		}

	}

	public List<Geopunto> obtenerTodos() {
		TypedQuery<Geopunto> query = em.createQuery("SELECT a FROM Geopunto a", Geopunto.class);
		return query.getResultList();
	}

	public Geopunto buscar(Long lon, Long lat) {
		TypedQuery<Geopunto> query = em
				.createQuery("SELECT a FROM Geopunto a WHERE a.longitud = :lon AND a.latitud = :lat", Geopunto.class)
				.setParameter("lon", lon).setParameter("lat", lat);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

}
