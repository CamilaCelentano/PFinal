package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;

@Stateless

public class MetodoMuestreoDAO {

	@PersistenceContext
	private EntityManager em;

	public MetodoMuestreoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(MetodoMuestreo mm) throws ServiciosException {
		if (buscarPorNombre(mm.getNombre()) == null) {
			try {
				em.persist(mm);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear el Metodo de Muestreo");
			}
		} else {
			throw new ServiciosException("El metodo de muestreo ya existe.");
		}
	}

	public MetodoMuestreo buscarPorNombre(String nom) {
		TypedQuery<MetodoMuestreo> query = em
				.createQuery("SELECT a FROM MetodoMuestreo a WHERE a.nombre = :nom", MetodoMuestreo.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public void actualizar(MetodoMuestreo mm) throws ServiciosException {
		try {
			em.merge(mm);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el método de muestreo.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			MetodoMuestreo mm = em.find(MetodoMuestreo.class, id);
			em.remove(mm);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el método de muestreo.");
		}

	}

	public List<MetodoMuestreo> obtenerTodos() {
		TypedQuery<MetodoMuestreo> query = em.createQuery("SELECT a FROM MetodoMuestreo a", MetodoMuestreo.class);
		return query.getResultList();
	}
}
