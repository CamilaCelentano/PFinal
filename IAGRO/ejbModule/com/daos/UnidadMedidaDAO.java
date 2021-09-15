package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.UnidadMedida;
import com.exception.ServiciosException;

@Stateless
public class UnidadMedidaDAO {
	@PersistenceContext
	private EntityManager em;

	public void crear(UnidadMedida m) throws ServiciosException {
		try {
			em.persist(m);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la Unidad de medida.");
		}
	}

	public void actualizar(UnidadMedida m) throws ServiciosException {
		try {
			em.merge(m);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Unidad de medida.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			UnidadMedida m = em.find(UnidadMedida.class, id);
			em.remove(m);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Unidad de medida.");
		}

	}

	public List<UnidadMedida> obtenerTodos() {
		TypedQuery<UnidadMedida> query = em.createQuery("SELECT a FROM UnidadMedida a", UnidadMedida.class);
		return query.getResultList();
	}

	public UnidadMedida buscarPorNombre(String nombre) {
		TypedQuery<UnidadMedida> query = em
				.createQuery("SELECT a FROM UnidadMedida a WHERE a.nombre = :nom", UnidadMedida.class)
				.setParameter("nom", nombre);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public UnidadMedidaDAO() {

	}

}
