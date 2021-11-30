package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.exception.ServiciosException;

@Stateless
public class EstacionMuestreoDAO {

	@PersistenceContext
	private EntityManager em;

	public EstacionMuestreoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(EstacionMuestreo m) throws ServiciosException {
		if (buscarPorNombre(m.getNombre()) == null) {
			try {
				em.persist(m);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear la Estación de Muestreo.");
			}
		} else {
			throw new ServiciosException("La estación ya existe");
		}
	}

	public void actualizar(EstacionMuestreo m) throws ServiciosException {
		try {
			em.merge(m);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la estación de muestreo.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			EstacionMuestreo m = em.find(EstacionMuestreo.class, id);
			em.remove(m);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la estación de muestreo.");
		}

	}

	public List<EstacionMuestreo> obtenerTodos() {
		TypedQuery<EstacionMuestreo> query = em.createQuery("SELECT a FROM EstacionMuestreo a", EstacionMuestreo.class);
		return query.getResultList();
	}

	public EstacionMuestreo buscarPorNombre(String nom) {
		TypedQuery<EstacionMuestreo> query = em
				.createQuery("SELECT a FROM EstacionMuestreo a WHERE a.nombre = :nom", EstacionMuestreo.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
	public EstacionMuestreo buscarPorId(Long idEstacion) {
		TypedQuery<EstacionMuestreo> query = em
				.createQuery("SELECT a FROM EstacionMuestreo a WHERE a.idEstacionMuestreo = :id", EstacionMuestreo.class)
				.setParameter("id", idEstacion);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstacionMuestreoDAO [em=");
		builder.append(em);
		builder.append("]");
		return builder.toString();
	}
	

}
