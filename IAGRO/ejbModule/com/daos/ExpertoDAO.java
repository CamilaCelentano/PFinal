package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Experto;
import com.exception.ServiciosException;

@Stateless
public class ExpertoDAO {

	@PersistenceContext
	private EntityManager em;

	public void crear(Experto f) throws ServiciosException {
		if (buscarPorNombreUsuario(f.getNombUsuario()) == null) {
			if (buscarPorMail(f.getEmail()) == null) {
				if (buscarPorCedula(f.getCedula()) == null) {
					try {
						em.persist(f);
						em.flush();
					} catch (PersistenceException e) {
						throw new ServiciosException("No se pudo crear el Usuario Experto.");
					}
				} else {
					throw new ServiciosException("La cedula ya existe.");
				}
			} else {
				throw new ServiciosException("El mail o cedula ya existe.");
			}
		} else {
			throw new ServiciosException("El nombre ya existe.");
		}
	}

	public void actualizar(Experto f) throws ServiciosException {
		try {
			em.merge(f);
			em.flush();
		} catch (PersistenceException e) {
			if (e.getMessage()
					.equals("org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
				throw new ServiciosException("El mail ya esta registrado.");
			} else {
				throw new ServiciosException("No se pudo actualizar el Usuario Experto.");
			}
		}
	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Experto f = em.find(Experto.class, id);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Usuario Experto.");
		}

	}

	public List<Experto> obtenerTodos() {
		TypedQuery<Experto> query = em.createQuery("SELECT a FROM Experto a", Experto.class);
		return query.getResultList();
	}

	public Experto buscarPorCedula(String ci) {
		TypedQuery<Experto> query = em.createQuery("SELECT a FROM Experto a WHERE a.cedula = :ci", Experto.class)
				.setParameter("ci", ci);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Experto buscarPorNombreUsuario(String nom) {
		TypedQuery<Experto> query = em.createQuery("SELECT a FROM Experto a WHERE a.nombUsuario = :nom", Experto.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Experto buscarPorMail(String email) {
		TypedQuery<Experto> query = em.createQuery("SELECT a FROM Experto a WHERE a.email = :email", Experto.class)
				.setParameter("email", email);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public ExpertoDAO() {

	}
	
	public Experto agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña, String profesion) {
		Experto experto = new Experto();
		experto.setNombre(nombre);
		experto.setApellido(apellido);
		experto.setNombUsuario(nombUsuario);
		experto.setEmail(email);
		experto.setContraseña(contraseña);
		experto.setProfesion(profesion);
		em.persist(experto);
		em.flush();
		return experto;
	}

}
