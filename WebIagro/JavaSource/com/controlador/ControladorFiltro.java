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
import com.entities.Administrador;
import com.entities.Departamento;
import com.entities.Experto;
import com.entities.Formulario;
import com.entities.MetodoMuestreo;
import com.entities.Usuario;
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
	private String usuario;
	private MetodoMuestreo meM = new MetodoMuestreo();
	private Usuario usu;
	private Experto exp = new Experto();
	private List<String> lista;
	
	
	public List<String> listado() {
		lista.add("Experto");
		lista.add("Administrador");
		lista.add("Comun");
		return lista;
	}
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
	public List<ActividadCampo> filtro(Date a, Date b){
		return act.buscarPorFecha(a, b);
	}

	public boolean esExp() {
		if (usu instanceof Experto || usu instanceof Administrador) {
			return true;
		} else {
			return false;
		}
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

	public MetodoMuestreo getMeM() {
		return meM;
	}

	public void setMeM(MetodoMuestreo meM) {
		this.meM = meM;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String tipoUsu(Usuario u) {
		if (u instanceof Experto){
			return tipoUsuario = "Experto";
		} else if (u instanceof Administrador){
			return tipoUsuario = "Administrador";
		}else {
			return tipoUsuario = "Comun";
		}
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	private String tipoUsuario;

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	

}
