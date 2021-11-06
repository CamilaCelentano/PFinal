package com.controlador;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.adconnect.ADConnect;
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

	private String contrase�a;

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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@PostConstruct
	public void init() {
		usuLogeado = null;
	}

	public String loginGenerico() {
		if (usuario.contains("@")) {
			return loginAD();
		} else {
			return login();
		}
	}

	public String loginAD() {
		// obtenemos el dominio en base al email provisto
		try {
			LdapContext ctx = ADConnect.getConnection(usuario, contrase�a);
			ADConnect.User userAD = ADConnect.getUser(usuario, ctx);

			if (userAD != null) {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Usuario encontrado en el AD " + userAD.getUserPrincipal(), "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);

				return "listadoUsuarios.xhtml";		
				
			} else {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario no encontrado en el AD, o contrase�a incorrecta",
						"");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	
			}

			ctx.close();

		} catch (Exception e) {
			// Failed to authenticate user!
			System.out.println(e.getMessage());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario no encontrado", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
		return "";
	}

	public String login() {
		Usuario u = usuBean.buscarPorNombreUsuario(usuario);

		if (u != null) {
			if (u.isActivo()) {
				if (u.getContrase�a().equals(MD5.getMd5(contrase�a))) {
					usuLogeado = u;
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login correcto.", "");
					FacesContext.getCurrentInstance().addMessage(null, facesMsg);
					usuario = "";
					contrase�a = "";
					return "listadoUsuarios.xhtml";
				} else {
					FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrase�a incorrecta.", "");
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
