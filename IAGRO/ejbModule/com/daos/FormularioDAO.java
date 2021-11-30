package com.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Casilla;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.exception.ServiciosException;

@Stateless
public class FormularioDAO {

	@PersistenceContext
	private EntityManager em;

	public FormularioDAO() {
		// TODO Auto-generated constructor stub
	}

	public void crear(Formulario f) throws ServiciosException {
		if(buscar(f.getnombre()) == null) {
			try {
				em.persist(f);
				em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear el formulario.");
			}
		}else {
			throw new ServiciosException("El nombre ya esta registrado.");
		}
	}

	public void actualizar(Formulario f) throws ServiciosException {
		try {
			em.merge(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el formulario.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			Formulario f = em.find(Formulario.class, id);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar el formulario.");
		}

	}

	public List<Formulario> obtenerTodos() {
		TypedQuery<Formulario> query = em.createQuery("SELECT a FROM Formulario a", Formulario.class);
		return query.getResultList();
	}

	public Formulario buscar(String nom) {
		TypedQuery<Formulario> query = em
				.createQuery("SELECT a FROM Formulario a WHERE a.nombre = :nom", Formulario.class)
				.setParameter("nom", nom);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public void asignarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException {
		try {
			Formulario f = em.find(Formulario.class, idFormulario);
			Casilla c = em.find(Casilla.class, idCasilla);
			f.getCasilla().add(c);
			em.flush();
		} catch (Exception e) {
			throw new ServiciosException("No se pudo asignar la casilla.");
		}
	}

	public void borrarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException {
		try {
			Formulario f = em.find(Formulario.class, idFormulario);
			Casilla c = em.find(Casilla.class, idCasilla);
			f.getCasilla().remove(c);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiciosException("No se pudo borrar la casilla.");
		}
	}
	public Formulario buscarPorId(Long idFormulario) {
		TypedQuery<Formulario> query = em
				.createQuery("SELECT a FROM Formulario a WHERE a.idFormulario = :id", Formulario.class)
				.setParameter("id", idFormulario);
		if (query.getResultList().size() == 1) {
			return query.getResultList().get(0);
		} else {
			return null;
		}
	}
	

}
