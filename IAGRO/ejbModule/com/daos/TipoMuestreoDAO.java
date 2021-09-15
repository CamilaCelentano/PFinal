package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoMuestreo;
import com.exception.ServiciosException;

@Stateless
public class TipoMuestreoDAO {

	@PersistenceContext
	private EntityManager em;

	public void crear(TipoMuestreo t) throws ServiciosException {
		if (buscarPorNombre(t.getNombre()) == null) {
			try {
				em.persist(t);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear el tipo de muestreo");
			}
		} else {
			throw new ServiciosException("El tipo de muestreo ya existe.");
		}
	}

	public TipoMuestreo buscarPorNombre(String nom) {
		TypedQuery<TipoMuestreo> query = em
				.createQuery("SELECT a FROM TipoMuestreo a WHERE a.nombre = :nom", TipoMuestreo.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public void actualizar(TipoMuestreo t) throws ServiciosException {
		try {
			em.merge(t);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el tipo de muestreo.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			TipoMuestreo t = em.find(TipoMuestreo.class, id);
			em.remove(t);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el tipo de muestreo.");
		}

	}

	public List<TipoMuestreo> obtenerTodos() {
		TypedQuery<TipoMuestreo> query = em.createQuery("SELECT a FROM TipoMuestreo a", TipoMuestreo.class);
		return query.getResultList();
	}

	public TipoMuestreoDAO() {
		// TODO Auto-generated constructor stub
	}

}
