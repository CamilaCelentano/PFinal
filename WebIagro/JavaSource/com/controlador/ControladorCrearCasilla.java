package com.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.entities.Casilla;
import com.entities.TipoValor;
import com.entities.UnidadMedida;
import com.exception.ServiciosException;
import com.servicios.CasillaBean;
import com.servicios.UnidadMedidaBean;

@Named(value = "crearCasilla") // JEE8
@SessionScoped // JEE8
public class ControladorCrearCasilla implements Serializable{

private static final long serialVersionUID = 1L;
	
	private Casilla casilla;
	private TipoValor tipovalor;
	private UnidadMedida uniMedida;
	
	@EJB
	private UnidadMedidaBean uniMedidaBean = new UnidadMedidaBean();
	
	@EJB
	private CasillaBean casiBean = new CasillaBean();

	@PostConstruct
	public void init() {
		casilla = new Casilla();
	}
	public void crearCasilla(){
		try {
			casiBean.crear(casilla);
			casilla = new Casilla();
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Casilla creada correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}
	public List<Casilla> mostrarUsuarios() {
		return casiBean.obtenerTodos();
	}
	public List<UnidadMedida> mostrarUnidades() {
		return uniMedidaBean.obtenerTodos();
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
	public TipoValor getTipovalor() {
		return tipovalor;
	}
	public void setTipovalor(TipoValor tipovalor) {
		this.tipovalor = tipovalor;
	}
	public UnidadMedida getUniMedida() {
		return uniMedida;
	}
	public void setUniMedida(UnidadMedida uniMedida) {
		this.uniMedida = uniMedida;
	}
	public UnidadMedidaBean getUniMedidaBean() {
		return uniMedidaBean;
	}
	public void setUniMedidaBean(UnidadMedidaBean uniMedidaBean) {
		this.uniMedidaBean = uniMedidaBean;
	}
	
	
	
	
}
