package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Administrador;
import com.exception.ServiciosException;

@Stateless
public class AdministradorDAO {

	@PersistenceContext
	private EntityManager em;

	public void crear(Administrador f) throws ServiciosException {
		if (buscarPorNombreUsuario(f.getNombUsuario()) == null) {
			if (buscarPorMail(f.getEmail()) == null) {
				if (buscarPorCedula(f.getCedula()) == null) {
					try {
						em.persist(f);
						em.flush();
					} catch (PersistenceException e) {
						throw new ServiciosException("No se pudo crear el Usuario Administrador.");
					}
				}else {
					throw new ServiciosException("La cedula ya existe.");
				}	
			} else {
				throw new ServiciosException("El mail o cedula ya existe.");
			}
		} else {
			throw new ServiciosException("El nombre ya existe.");
		}
	}

	public void actualizar(Administrador f) throws ServiciosException {
		try {
			em.merge(f);
			em.flush();
		} catch (PersistenceException e) {
			if (e.getMessage()
					.equals("org.hibernate.exception.ConstraintViolationException: could not execute statement")) {
				throw new ServiciosException("El mail ya esta registrado.");
			} else {
				throw new ServiciosException("No se pudo actualizar el Usuario Administrador.");
			}
		}
	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Administrador f = em.find(Administrador.class, id);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Usuario Administrador.");
		}

	}

	public List<Administrador> obtenerTodos() {
		TypedQuery<Administrador> query = em.createQuery("SELECT a FROM Administrador a", Administrador.class);
		return query.getResultList();
	}

	public Administrador buscarPorCedula(String ci) {
		TypedQuery<Administrador> query = em
				.createQuery("SELECT a FROM Administrador a WHERE a.cedula = :ci", Administrador.class)
				.setParameter("ci", ci);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Administrador buscarPorNombreUsuario(String nom) {
		TypedQuery<Administrador> query = em
				.createQuery("SELECT a FROM Administrador a WHERE a.nombUsuario = :nom", Administrador.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Administrador buscarPorMail(String email) {
		TypedQuery<Administrador> query = em
				.createQuery("SELECT a FROM Administrador a WHERE a.email = :email", Administrador.class)
				.setParameter("email", email);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
	public Administrador agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña, String ci, String instituto) {
		Administrador admin = new Administrador();
		admin.setNombre(nombre);
		admin.setApellido(apellido);
		admin.setNombUsuario(nombUsuario);
		admin.setEmail(email);
		admin.setContraseña(contraseña);
		admin.setCedula(ci);
		admin.setInstituto(instituto);
		em.persist(admin);
		em.flush();
		return admin;
	}

	public AdministradorDAO() {

	}

}