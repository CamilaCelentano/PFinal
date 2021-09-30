package com.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBean;

@Named(value = "eliminarUsuario") // JEE8
@SessionScoped // JEE8
public class ControladorEliminarUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuarioBorrar;
	
	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@PostConstruct
	public void init() {
	}

	public Usuario getUsuarioBorrar() {
		return usuarioBorrar;
	}

	public void setUsuarioBorrar(Usuario usuarioBorrar) {
		this.usuarioBorrar = usuarioBorrar;
	}
	
	public void eliminarUsuario(Usuario u) {
		try {
			usuBean.borrar(u.getIdUsuario());
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
	}
	
}
