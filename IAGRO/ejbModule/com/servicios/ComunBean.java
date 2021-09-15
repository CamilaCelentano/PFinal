package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.ComunDAO;
import com.entities.Comun;
import com.exception.ServiciosException;
@Local
@Stateless
public class ComunBean{

	@EJB
	private ComunDAO comun;


	public void crear(Comun f) throws ServiciosException {
		comun.crear(f);
	}


	public void actualizar(Comun f) throws ServiciosException {
		comun.actualizar(f);
	}


	public void borrar(Long id) throws ServiciosException {
		comun.borrar(id);
	}


	public List<Comun> obtenerTodos() {
		return comun.obtenerTodos();
	}

	public Comun buscarPorNombreUsuario(String nom) {
		return comun.buscarPorNombreUsuario(nom);
	}


	public Comun buscarPorMail(String email) {
		return comun.buscarPorMail(email);
	}

	public ComunBean() {

	}
	public Comun Agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña) {
		return comun.agregar(nombre, apellido, nombUsuario, email, contraseña);
	}

}

