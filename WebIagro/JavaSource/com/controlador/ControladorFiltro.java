package com.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.entities.ActividadCampo;
import com.entities.Formulario;
import com.servicios.ActividadCampoBean;

@Named(value = "filtro") // JEE8
@SessionScoped // JEE8
public class ControladorFiltro implements Serializable{
	
	@PostConstruct
	public void init() {
	
	}
	private static final long serialVersionUID = 1L;
	private Date fecha1;
	private Date fecha2;
	@EJB
	ActividadCampoBean act = new ActividadCampoBean();
	public List<ActividadCampo> mostrarActv() {
		ret = act.obtenerTodos();
		return act.obtenerTodos();
	}
	ActividadCampo act1 = new ActividadCampo();
	private List<ActividadCampo> listado = new ArrayList<ActividadCampo>();
	private List<ActividadCampo> ret = new ArrayList<ActividadCampo>();
	
	public List<ActividadCampo> obtenerActividad(Date fecha, Date fecha1){
		return act.buscarPorFecha(fecha, fecha1);
	}
	
	public List<ActividadCampo> filtroFecha(Date ini, Date fin) {
		for (ActividadCampo ac : listado) {
			if (ac.getFecha().after(ini) && ac.getFecha().before(fin)) {
				ret.add(ac);
			}
		}
		return ret;
	}
	public Date getFecha1() {
		return fecha1;
	}
	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}
	public Date getFecha2() {
		return fecha2;
	}
	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}
	public List<ActividadCampo> getListado() {
		return listado;
	}
	public void setListado(List<ActividadCampo> listado) {
		this.listado = listado;
	}
	public List<ActividadCampo> getRet() {
		return ret;
	}
	public void setRet(List<ActividadCampo> ret) {
		this.ret = ret;
	}
	

}
