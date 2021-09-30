package com.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Experto;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.AdministradorBean;
import com.servicios.ComunBean;
import com.servicios.ExpertoBean;
import com.servicios.UsuarioBean;

@Named(value = "gestionUsuario") // JEE8
@SessionScoped // JEE8
public class ControladorUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipoUsuario = "";

	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@EJB
	private AdministradorBean adminBean = new AdministradorBean();

	private Administrador adm = new Administrador();

	@EJB
	private ExpertoBean expertoBean = new ExpertoBean();

	private Experto exp = new Experto();

	@EJB
	private ComunBean comunBean = new ComunBean();

	private Comun com = new Comun();

	@PostConstruct
	public void init() {

	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}

	public Experto getExp() {
		return exp;
	}

	public void setExp(Experto exp) {
		this.exp = exp;
	}

	public Comun getCom() {
		return com;
	}

	public void setCom(Comun com) {
		this.com = com;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean cargarFormAdm() {
		if (tipoUsuario.equals("Administrador")) {
			return true;
		}
		return false;
	}

	public boolean cargarFormCom() {
		if (tipoUsuario.equals("Comun")) {
			return true;
		}
		return false;
	}

	public boolean cargarFormExp() {
		if (tipoUsuario.equals("Experto")) {
			return true;
		}
		return false;
	}

	public void crearAdm() {
		try {
			adminBean.crear(adm);
			adm = new Administrador();
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Administrador creado correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}

	public void crearCom() {
		try {
			comunBean.crear(com);
			com = new Comun();
			System.out.println(comunBean.obtenerTodos());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Comun creado correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}

	}

	public void crearExp() {
		try {
			expertoBean.crear(exp);
			exp = new Experto();
			System.out.println(expertoBean.obtenerTodos());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Experto creado correctamente.", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}

	public List<Usuario> mostrarUsuarios() {
		return usuBean.obtenerTodos();
	}

	public String tUsuario(Usuario u) {
		if (u instanceof Administrador) {
			return "Administrador";
		} else if (u instanceof Comun) {
			return "Comun";
		} else {
			return "Experto";
		}
	}

	public String seleccionarModificar(Usuario u) {
		if (u instanceof Administrador) {
			tipoUsuario = "Administrador";
			adm = (Administrador) u;
		} else if (u instanceof Comun) {
			tipoUsuario = "Comun";
			com = (Comun) u;
		} else {
			tipoUsuario = "Experto";
			exp = (Experto) u;
		}
		return "modificarUsuario";
	}

}
