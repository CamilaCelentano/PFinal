package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.ExpertoDAO;
import com.entities.Experto;
import com.exception.ServiciosException;
@Local
@Stateless
public class ExpertoBean {

	@EJB
	private ExpertoDAO experto;

	public void crear(Experto f) throws ServiciosException {
		experto.crear(f);
	}


	public void actualizar(Experto f) throws ServiciosException {
		experto.actualizar(f);
	}

	public void borrar(Long id) throws ServiciosException {
		experto.borrar(id);
	}


	public List<Experto> obtenerTodos() {
		return experto.obtenerTodos();
	}

	public Experto buscarPorCedula(String ci) {
		return experto.buscarPorCedula(ci);
	}

	public ExpertoBean() {

	}
	public Experto Agregar(String nombre, String apellido, String nombUsuario, String email, String contraseña, String profesion) {
		return experto.agregar(nombre, apellido, nombUsuario, email, contraseña, profesion);
	}

}