package com.daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.ActividadCampo;
import com.exception.ServiciosException;

@Stateless
public class ActividadCampoDAO {

	@PersistenceContext
	private EntityManager em;

	public ActividadCampoDAO() {

	}

	public void crear(ActividadCampo ac) throws ServiciosException {
		try {
			em.persist(ac);
			em.flush();
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			throw new ServiciosException("No se pudo crear la Actividad de Campo.");
		}
	}

	public void actualizar(ActividadCampo ac) throws ServiciosException {
		try {
			em.merge(ac);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Actividad de Campo.");
		}

	}

	public void borrar(Long id) throws ServiciosException {
		try {
			ActividadCampo ac = em.find(ActividadCampo.class, id);
			em.remove(ac);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo eliminar la Actividad de Campo.");
		}

	}

	public List<ActividadCampo> obtenerTodos() {
		TypedQuery<ActividadCampo> query = em.createQuery("SELECT a FROM ActividadCampo a", ActividadCampo.class);
		return query.getResultList();
	}

//	public ActividadCampo buscarPorNombre(String nom) {
//		TypedQuery<ActividadCampo> query = em
//				.createQuery("SELECT a FROM ActividadCampo a WHERE a.nombre = :nom", ActividadCampo.class)
//				.setParameter("nom", nom);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

//	public ActividadCampo buscarPorForm(String form) {
//		TypedQuery<ActividadCampo> query = em
//				.createQuery("SELECT a FROM ActividadCampo a WHERE a.formulario = :form", ActividadCampo.class)
//				.setParameter("formulario", form);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

	public List<ActividadCampo> buscarPorFecha(Date fecha, Date fecha1) {
		TypedQuery<ActividadCampo> query = em
				.createQuery("SELECT a FROM ActividadCampo a WHERE a.fecha >= :fecha AND a.fecha <= :fecha1", ActividadCampo.class)
				.setParameter("fecha", fecha).setParameter("fecha1", fecha1);
		return query.getResultList();
	}

//	public ActividadCampo buscarPorMetM(String metM) {
//		TypedQuery<ActividadCampo> query = em
//				.createQuery("SELECT a FROM ActividadCampo a WHERE a.metodoMuestreo = :metM", ActividadCampo.class)
//				.setParameter("metodoMuestreo", metM);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

//	public ActividadCampo buscarPorEstM(String estM) {
//		TypedQuery<ActividadCampo> query = em
//				.createQuery("SELECT a FROM ActividadCampo a WHERE a.estacionMuestreo = :estM", ActividadCampo.class)
//				.setParameter("estacionMuestreo", estM);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

//	public ActividadCampo buscarPorUsuerio(String usuario) {
//		TypedQuery<ActividadCampo> query = em
//				.createQuery("SELECT a FROM ActividadCampo a WHERE a.usuario = :usuario", ActividadCampo.class)
//				.setParameter("usuraio", usuario);
//		if (query.getResultList().size() == 1) {
//			return query.getResultList().get(0);
//		} else {
//			return null;
//		}
//	}

}
