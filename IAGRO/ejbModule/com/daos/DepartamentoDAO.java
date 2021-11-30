package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Administrador;
import com.entities.Departamento;
import com.exception.ServiciosException;

@Stateless
public class DepartamentoDAO {

	@PersistenceContext
	private EntityManager em;

	public DepartamentoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(Departamento d) throws ServiciosException {
		if (buscarPorNombre(d.getNombre()) == null) {
			try {
				em.persist(d);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear el Departamento");
			}
		} else {
			throw new ServiciosException("El Departamento ya existe");
		}
	}

	public void actualizar(Departamento d) throws ServiciosException {
		try {
			em.merge(d);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el Departamento.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Departamento d = em.find(Departamento.class, id);
			em.remove(d);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Departamento.");
		}

	}

	public List<Departamento> obtenerTodos() {
		TypedQuery<Departamento> query = em.createQuery("SELECT a FROM Departamento a", Departamento.class);
		return query.getResultList();
	}

	public Departamento buscarPorNombre(String nom) {
		TypedQuery<Departamento> query = em
				.createQuery("SELECT a FROM Departamento a WHERE a.nombre = :nom", Departamento.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
	public Departamento buscarPorId(Long idDepartamento) {
		TypedQuery<Departamento> query = em
				.createQuery("SELECT a FROM Departamento a WHERE a.idDepartamento = :id", Departamento.class)
				.setParameter("id", idDepartamento);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
	

}
