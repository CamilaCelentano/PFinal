package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import com.entities.Comun;
import com.exception.ServiciosException;

@Stateless
public class ComunDAO {

	@PersistenceContext
	private EntityManager em;

	public void crear(Comun f) throws ServiciosException {
		if (buscarPorNombreUsuario(f.getNombUsuario()) == null) {
			if (buscarPorMail(f.getEmail()) == null) {
				try {
					em.persist(f);
					em.flush();
				} catch (PersistenceException e) {
					throw new ServiciosException("No se pudo crear el Usuario Comun.");
				}
			} else {
				throw new ServiciosException("El mail ya existe.");
			}
		} else {
			throw new ServiciosException("El nombre ya existe.");
		}
	}

	public void actualizar(Comun f) throws ServiciosException {
		try {
			em.merge(f);
			em.flush();
		} catch (PersistenceException e) {
			if (e.getMessage()
					.equals("org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
				throw new ServiciosException("El mail ya esta registrado.");
			} else {
				throw new ServiciosException("No se pudo actualizar el Usuario Comun.");
			}
		}
	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Comun f = em.find(Comun.class, id);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Usuario Comun.");
		}

	}

	public List<Comun> obtenerTodos() {
		TypedQuery<Comun> query = em.createQuery("SELECT a FROM Comun a", Comun.class);
		return query.getResultList();
	}

	public Comun buscarPorNombreUsuario(String nom) {
		TypedQuery<Comun> query = em.createQuery("SELECT a FROM Comun a WHERE a.nombUsuario = :nom", Comun.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Comun buscarPorMail(String email) {
		TypedQuery<Comun> query = em.createQuery("SELECT a FROM Comun a WHERE a.email = :email", Comun.class)
				.setParameter("email", email);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public ComunDAO() {

	}
	
	
	public Comun agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña) {
		Comun comun = new Comun();
		comun.setNombre(nombre);
		comun.setApellido(apellido);
		comun.setNombUsuario(nombUsuario);
		comun.setEmail(email);
		comun.setContraseña(contraseña);
		em.persist(comun);
		em.flush();
		return comun;
	}

}
