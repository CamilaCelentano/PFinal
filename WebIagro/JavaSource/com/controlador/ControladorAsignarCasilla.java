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
import com.entities.Casilla;
import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.CasillaBean;
import com.servicios.FormularioBean;
@Named(value = "asignarCasilla") // JEE8
@SessionScoped // JEE8
public class ControladorAsignarCasilla implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		private Formulario formulario;
		private Casilla casilla;
		
		@EJB
		private FormularioBean formBean = new FormularioBean();
		
		@EJB
		private CasillaBean casiBean = new CasillaBean();

		@PostConstruct
		public void init() {
			formulario = new Formulario();
			casilla = new Casilla();
		}
		
		public void asignarCasilla(){
			try {
				formBean.asignarCasilla(formulario.getIdFormulario(), casilla.getIdCasilla());
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Casilla asignada correctamente.",
						"");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			} catch (ServiciosException e) {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				e.printStackTrace();
			}
		}
		
		public String seleccionarModificar(Formulario f) {
				formulario = (Formulario) f;
			return "asignarCasilla";
		}
		public List<Formulario> mostrarFormularios() {
			return formBean.obtenerTodos();
		}
		public List<Casilla> mostrarCasilla() {
			return casiBean.obtenerTodos();
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

		public Casilla getCasilla() {
			return casilla;
		}

		public void setCasilla(Casilla casilla) {
			this.casilla = casilla;
		}

		public CasillaBean getCasiBean() {
			return casiBean;
		}

		public void setCasiBean(CasillaBean casiBean) {
			this.casiBean = casiBean;
		}
		

		
	}


