package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Tarea;
import com.exception.ServiciosException;

@Stateless
public class TareaDAO {

	@PersistenceContext
	private EntityManager em;

	public void crear(Tarea f) throws ServiciosException {
		if (buscarPorNombre(f.getNombre()) == null) {
			try {
				em.persist(f);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear la Tarea.");
			}
		} else {
			throw new ServiciosException("El nombre ya existe.");
		}
	}

	public void actualizar(Tarea f) throws ServiciosException {
		try {
			em.merge(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Tarea.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Tarea f = em.find(Tarea.class, id);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Tarea.");
		}

	}

	public List<Tarea> obtenerTodos() {
		TypedQuery<Tarea> query = em.createQuery("SELECT a FROM Tarea a", Tarea.class);
		return query.getResultList();
	}

	public Tarea buscarPorNombre(String nom) {
		TypedQuery<Tarea> query = em.createQuery("SELECT a FROM Tarea a WHERE a.nombre = :nom", Tarea.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public TareaDAO() {

	}

}
