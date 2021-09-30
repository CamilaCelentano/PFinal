package com.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.entities.Administrador;
import com.entities.Experto;
import com.entities.MD5;
import com.entities.Usuario;
import com.servicios.UsuarioBean;

@Named(value = "loginUsuario") // JEE8
@SessionScoped // JEE8
public class ControladorLoginUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;

	private String contraseña;

	private Usuario usuLogeado;

	public Usuario getUsuLogeado() {
		return usuLogeado;
	}

	public void setUsuLogeado(Usuario usuLogeado) {
		this.usuLogeado = usuLogeado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@PostConstruct
	public void init() {
		usuLogeado = null;
	}

	public String login() {
		Usuario u = usuBean.buscarPorNombreUsuario(usuario);

		if (u != null) {
			if (u.isActivo()) {
				if (u.getContraseña().equals(MD5.getMd5(contraseña))) {
					usuLogeado = u;
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login correcto.", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
					usuario = "";
					contraseña = "";
					return "listadoUsuarios.xhtml";
				} else {
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta.", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				}
			} else {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"El Usuario se encuentra inactivo.", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			}
		} else {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El Usuario no existe.", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		return "";
	}

	public String logout() {
		usuLogeado = null;
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logout correcto.", "");
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return "login.xhtml";
	}

	public boolean esAdm() {
		return usuLogeado instanceof Administrador;
	}

	public boolean esExpOAdm() {
		if (usuLogeado instanceof Experto || usuLogeado instanceof Administrador) {
			return true;
		} else {
			return false;
		}
	}

	public boolean logeado() {
		if (usuLogeado != null) {
			return true;
		} else {
			return false;
		}
	}

}
