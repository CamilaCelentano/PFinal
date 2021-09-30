package com.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.FormularioBean;

@Named(value = "crearFormulario") // JEE8
@SessionScoped // JEE8
public class ControladorCrearFormulario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Formulario formulario;
	
	@EJB
	private FormularioBean formBean = new FormularioBean();

	@PostConstruct
	public void init() {
		formulario = new Formulario();
	}
	public void crearFormulario(){
		try {
			formBean.crear(formulario);
			formulario = new Formulario();
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Formulario creado correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}
	public List<Formulario> mostrarUsuarios() {
		return formBean.obtenerTodos();
	}
	public Formulario getFormulario() {
		return formulario;
	}
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	public FormularioBean getFormBean() {
		return formBean;
	}
	public void setFormBean(FormularioBean formBean) {
		this.formBean = formBean;
	}

	
}
