package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Zonas;
import com.exception.ServiciosException;

@Stateless
public class ZonasDAO {

	@PersistenceContext
	private EntityManager em;

	public ZonasDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(Zonas z) throws ServiciosException {
		if (buscarPorNombre(z.getNombre()) == null) {
			try {
				em.persist(z);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear la zona");
			}
		} else {
			throw new ServiciosException("La Zona ya existe.");
		}
	}

	public Zonas buscarPorNombre(String nom) {
		TypedQuery<Zonas> query = em.createQuery("SELECT a FROM Zonas a WHERE a.nombZona = :nom", Zonas.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public void actualizar(Zonas z) throws ServiciosException {
		try {
			em.merge(z);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Zona.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Zonas z = em.find(Zonas.class, id);
			em.remove(z);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Zona.");
		}

	}

	public List<Zonas> obtenerTodos() {
		TypedQuery<Zonas> query = em.createQuery("SELECT a FROM Zonas a", Zonas.class);
		return query.getResultList();
	}
}
