package com.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.entities.ActividadCampo;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;
import com.servicios.ActividadCampoBean;
import com.servicios.DepartamentoBean;
import com.servicios.EstacionMuestreoBean;
import com.servicios.FormularioBean;
import com.servicios.MetodoMuestreoBean;

import dto.ActividadCampoDTO;
import dto.DepartamentoDTO;

@Named(value = "crearActividad") // JEE8
@SessionScoped // JEE8
public class ControladorActividadCampo implements Serializable{
	private static final long serialVersionUID = 1L;
	private ActividadCampo act = new ActividadCampo();
	private Long departamento;
	private List<Departamento> listadep = new ArrayList<Departamento>();
	private List<MetodoMuestreo> listadomet = new ArrayList<MetodoMuestreo>();
	private List<EstacionMuestreo> listadoest = new ArrayList<EstacionMuestreo>();
	private List<Formulario> listadofor = new ArrayList<Formulario>();
	private Departamento dep = new Departamento();
	private EstacionMuestreo estM = new EstacionMuestreo();
	private MetodoMuestreo metM = new MetodoMuestreo();
	private Formulario form = new Formulario();
	private FormularioBean formBean = new FormularioBean();
	private ActividadCampoDTO acDTO = new ActividadCampoDTO();
	private DepartamentoDTO depDTO = new DepartamentoDTO();
	@EJB
	private DepartamentoBean depBean = new DepartamentoBean();
	
	@EJB
	private EstacionMuestreoBean estBean = new EstacionMuestreoBean();
	
	@EJB
	private MetodoMuestreoBean metBean = new MetodoMuestreoBean();
	
	@EJB
	private ActividadCampoBean actBean = new ActividadCampoBean();
	
	
	@PostConstruct
	public void init() {
	
	}
	public void crearActividad(){
		try {
			actBean.crear(act);
			act = new ActividadCampo();
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad de campo creada correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}
	
	public List<ActividadCampo> mostrarAct() {
		return actBean.obtenerTodos();
	}
	
	
	public List<Departamento> mostrarDep() {
		return depBean.obtenerTodos();
	}
	
	public List<EstacionMuestreo> mostrarEst() {
		return estBean.obtenerTodos();
	}
	
	public List<MetodoMuestreo> mostrarMet() {
		return metBean.obtenerTodos();
	}
	
	public List<Formulario> mostrarFor() {
		return formBean.obtenerTodos();
	}
	
	public ActividadCampo getAct() {
		return act;
	}
	public void setAct(ActividadCampo act) {
		this.act = act;
	}
	public Departamento getDep() {
		return dep;
	}
	public void setDep(Departamento dep) {
		this.dep = dep;
	}
	public EstacionMuestreo getEstM() {
		return estM;
	}
	public void setEstM(EstacionMuestreo estM) {
		this.estM = estM;
	}
	public MetodoMuestreo getMetM() {
		return metM;
	}
	public void setMetM(MetodoMuestreo metM) {
		this.metM = metM;
	}
	public ActividadCampoBean getActBean() {
		return actBean;
	}
	public void setActBean(ActividadCampoBean actBean) {
		this.actBean = actBean;
	}
	public DepartamentoBean getDepBean() {
		return depBean;
	}
	public void setDepBean(DepartamentoBean depBean) {
		this.depBean = depBean;
	}
	public EstacionMuestreoBean getEstBean() {
		return estBean;
	}
	public void setEstBean(EstacionMuestreoBean estBean) {
		this.estBean = estBean;
	}
	public MetodoMuestreoBean getMetBean() {
		return metBean;
	}
	public void setMetBean(MetodoMuestreoBean metBean) {
		this.metBean = metBean;
	}
	
	public List<Departamento> selectDep() {
		List<Departamento> obtenerD = depBean.obtenerTodos();
		return obtenerD;
	}
	
	public List<MetodoMuestreo> selectMet() {
		List<MetodoMuestreo> obtenerM = metBean.obtenerTodos();
		return obtenerM;
	}
	public List<EstacionMuestreo> selectEst() {
		List<EstacionMuestreo> obtenerE = estBean.obtenerTodos();
		return obtenerE;
	}
	
//	public Long getDepartamento() {
//		return departamento;
//	}
//	public void setDepartamento(Long departamento) {
//		this.departamento = departamento;
//	}
	public List<Departamento> getListadep() {
		return listadep;
	}
	public void setListadep(List<Departamento> listadep) {
		this.listadep = listadep;
	}
	public List<MetodoMuestreo> getListadomet() {
		return listadomet;
	}
	public void setListadomet(List<MetodoMuestreo> listadomet) {
		this.listadomet = listadomet;
	}
	public List<EstacionMuestreo> getListadoest() {
		return listadoest;
	}
	public void setListadoest(List<EstacionMuestreo> listadoest) {
		this.listadoest = listadoest;
	}
	public Formulario getForm() {
		return form;
	}
	public void setForm(Formulario form) {
		this.form = form;
	}
	public FormularioBean getFormBean() {
		return formBean;
	}
	public void setFormBean(FormularioBean formBean) {
		this.formBean = formBean;
	}
	public ActividadCampoDTO getAcDTO() {
		return acDTO;
	}
	public void setAcDTO(ActividadCampoDTO acDTO) {
		this.acDTO = acDTO;
	}
	public DepartamentoDTO getDepDTO() {
		return depDTO;
	}
	public void setDepDTO(DepartamentoDTO depDTO) {
		this.depDTO = depDTO;
	}
	
	
}
