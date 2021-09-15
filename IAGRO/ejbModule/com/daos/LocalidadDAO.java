package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Localidad;
import com.exception.ServiciosException;

@Stateless
public class LocalidadDAO {
	@PersistenceContext
	private EntityManager em;

	public LocalidadDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(Localidad l) throws ServiciosException {
		if (buscarPorNombre(l.getNombre()) == null) {
			try {
				em.persist(l);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear la localidad");
			}
		} else {
			throw new ServiciosException("La localidad ya existe.");
		}
	}

	public void actualizar(Localidad l) throws ServiciosException {
		try {
			em.merge(l);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Localidad.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Localidad l = em.find(Localidad.class, id);
			em.remove(l);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Localidad.");
		}

	}

	public List<Localidad> obtenerTodos() {
		TypedQuery<Localidad> query = em.createQuery("SELECT a FROM Localidad a", Localidad.class);
		return query.getResultList();
	}

	public Localidad buscarPorNombre(String nom) {
		TypedQuery<Localidad> query = em
				.createQuery("SELECT a FROM Localidad a WHERE a.nombre = :nom", Localidad.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
}
