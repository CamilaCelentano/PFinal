package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Casilla;
import com.exception.ServiciosException;

@Stateless
public class CasillaDAO {
	@PersistenceContext
	private EntityManager em;

	public void crear(Casilla c) throws ServiciosException {
		if (buscar(c.getParametro()) != null) {
			throw new ServiciosException("Ya existe una casilla con ese nombre de paramentro.");
		} else {
			try {
				em.persist(c);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear la casilla.");
			}
		}
	}

	public void actualizar(Casilla c) throws ServiciosException {
		try {
			em.merge(c);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la casilla.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Casilla c = em.find(Casilla.class, id);
			em.remove(c);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la casilla.");
		}

	}

	public List<Casilla> obtenerTodos() {
		TypedQuery<Casilla> query = em.createQuery("SELECT a FROM Casilla a", Casilla.class);
		return query.getResultList();
	}

	public Casilla buscar(String nom) {
		TypedQuery<Casilla> query = em.createQuery("SELECT a FROM Casilla a WHERE a.parametro = :nom", Casilla.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public CasillaDAO() {
		// TODO Auto-generated constructor stub
	}

}
