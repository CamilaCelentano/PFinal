package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.FormularioDAO;
import com.entities.Formulario;
import com.exception.ServiciosException;
@Local
@Stateless
public class FormularioBean {

    public FormularioBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
	FormularioDAO formulario;

	public void crear(Formulario f) throws ServiciosException {
		formulario.crear(f);
	}

	public void actualizar(Formulario f) throws ServiciosException {
		formulario.actualizar(f);
	}

	public void borrar(Long id) throws ServiciosException {
		formulario.borrar(id);
	}

	public List<Formulario> obtenerTodos() {
		return formulario.obtenerTodos();
	}

	public Formulario buscar(String nom) {
		return formulario.buscar(nom);
	}

	public void asignarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException {
		formulario.asignarCasilla(idFormulario, idCasilla);
		
	}

	public void borrarCasilla(Long idFormulario, Long idCasilla) throws ServiciosException {
		formulario.borrarCasilla(idFormulario, idCasilla);
		
	}

}
