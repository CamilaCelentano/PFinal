package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.AdministradorDAO;
import com.entities.Administrador;
import com.exception.ServiciosException;
@Local
@Stateless
public class AdministradorBean{

	@EJB
	private AdministradorDAO admin;

	public void crear(Administrador f) throws ServiciosException {
		admin.crear(f);
	}

	public void actualizar(Administrador f) throws ServiciosException {
		admin.actualizar(f);
	}

	public void borrar(Long id) throws ServiciosException {
		admin.borrar(id);
	}

	public List<Administrador> obtenerTodos() {
		return admin.obtenerTodos();
	}

	public Administrador buscarPorCedula(String ci) {
		return admin.buscarPorCedula(ci);
	}
	
	public Administrador Agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña, String ci, String instituto) {
		return admin.agregar(nombre, apellido, nombUsuario, email, contraseña, ci, instituto);
	}


}
