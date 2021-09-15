package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

//	public void crear(Usuario f) throws ServiciosException {
//		if (buscarPorNombreUsuario(f.getNombUsuario()) == null) {
//			if (buscarPorMail(f.getEmail()) == null) {
//				try {
//					em.persist(f);
//					em.flush();
//				} catch (PersistenceException e) {
//					throw new ServiciosException("No se pudo crear el Usuario.");
//				}
//			} else {
//				throw new ServiciosException("El mail ya existe.");
//			}
//		} else {
//			throw new ServiciosException("El nombre ya existe.");
//		}
//	}
//
//	public void actualizar(Usuario f) throws ServiciosException {
//		try {
//			em.merge(f);
//			em.flush();
//		} catch (PersistenceException e) {
//			throw new ServiciosException("No se pudo actualizar el Usuario.");
//		}
//	}
//
	public void borrar(Long id) throws ServiciosException {
		try {
			Usuario f = em.find(Usuario.class, id);
			f.setActivo(false);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el Usuario.");
		}
	}

	public List<Usuario> obtenerTodos() {
		TypedQuery<Usuario> query = em.createQuery("SELECT a FROM Usuario a WHERE a.activo = :act", Usuario.class)
				.setParameter("act", true);
		return query.getResultList();
	}

	public Usuario buscarPorNombreUsuario(String nom) {
		TypedQuery<Usuario> query = em.createQuery("SELECT a FROM Usuario a WHERE a.nombUsuario = :nom", Usuario.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public Usuario buscarPorMail(String email) {
		TypedQuery<Usuario> query = em.createQuery("SELECT a FROM Usuario a WHERE a.email = :email", Usuario.class)
				.setParameter("email", email);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public UsuarioDAO() {

	}

}
