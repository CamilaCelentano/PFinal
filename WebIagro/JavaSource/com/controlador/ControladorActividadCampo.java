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
import com.entities.Geopunto;
import com.entities.MetodoMuestreo;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.ActividadCampoBean;
import com.servicios.DepartamentoBean;
import com.servicios.EstacionMuestreoBean;
import com.servicios.FormularioBean;
import com.servicios.GeopuntoBean;
import com.servicios.MetodoMuestreoBean;
import com.servicios.UsuarioBean;

import dto.ActividadCampoDTO;
import dto.DepartamentoDTO;
import dto.EstacionMuestreoDTO;
import dto.GeopuntoDTO;
import dto.MetodoMuestreoDTO;
import dto.UsuarioDTO;
import dto.formularioDTO;

@Named(value = "crearActividad") // JEE8
@SessionScoped // JEE8
public class ControladorActividadCampo implements Serializable{
	private static final long serialVersionUID = 1L;
	private ActividadCampo act = new ActividadCampo();
	private Long departamento;
	private List<Departamento> listadep;
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
	private EstacionMuestreoDTO estDTO = new EstacionMuestreoDTO();
	private MetodoMuestreoDTO metDTO = new MetodoMuestreoDTO();
	private formularioDTO forDTO = new formularioDTO();
	private GeopuntoDTO geoDTO = new GeopuntoDTO();
	private UsuarioDTO usuDTO = new UsuarioDTO();
	@EJB
	private DepartamentoBean depBean = new DepartamentoBean();
	
	@EJB
	private EstacionMuestreoBean estBean = new EstacionMuestreoBean();
	
	@EJB
	private MetodoMuestreoBean metBean = new MetodoMuestreoBean();
	
	@EJB
	private ActividadCampoBean actBean = new ActividadCampoBean();
	@EJB
	private FormularioBean foBean = new FormularioBean();
	@EJB
	private GeopuntoBean geoBean = new GeopuntoBean();
	@EJB
	private UsuarioBean usuBean = new UsuarioBean();
	
	@PostConstruct
	public void init() {
	
	}
	public void crearActividad(ActividadCampoDTO actDTO){
		ControladorLoginUsuario ctlL = new ControladorLoginUsuario();
		try {
			actBean.crear(new ActividadCampo(actDTO.getNombre(),actDTO.getDescripcion(), actDTO.getFecha(), actDTO.getCantidad(), ctlL.getUsuLogeado(), actDTO.getFormulario(), actDTO.getRespuestas(),actDTO.getMetMuestreo(), actDTO.getEstacionMuestreo(), actDTO.getGeopunto(), actDTO.getDepartamento()));
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad de campo creada correctamente.",
					"");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (ServiciosException e) {
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();
		}
	}
	
	public String seleccionarCargar(Formulario f) {
		form = (Formulario) f;
	return "crearActividad";
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
		return foBean.obtenerTodos();
	}
	
	public List<Geopunto> mostrarGeo() {
		return geoBean.obtenerTodos();
	}
	public List<Usuario> mostrarUsu() {
		return usuBean.obtenerTodos();
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
	public List<Departamento> listado() {
		listadep = depBean.obtenerTodos();
		return listadep;
	}
	public List<MetodoMuestreo> selectMet() {
		List<MetodoMuestreo> obtenerM = metBean.obtenerTodos();
		return obtenerM;
	}
	public List<EstacionMuestreo> selectEst() {
		List<EstacionMuestreo> obtenerE = estBean.obtenerTodos();
		return obtenerE;
	}
	
	public List<Formulario> selectFor() {
		List<Formulario> obtenerF = foBean.obtenerTodos();
		return obtenerF;
	}
	
	public List<Geopunto> selectGeo() {
		List<Geopunto> obtenerG = geoBean.obtenerTodos();
		return obtenerG;
	}
	public List<Usuario> selectUser() {
		List<Usuario> obtenerU = usuBean.obtenerTodos();
		return obtenerU;
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
	private DepartamentoDTO depDTO1 = new DepartamentoDTO(dep.getIdDepartamento(), dep.getNombre());


	public EstacionMuestreoDTO getEstDTO() {
		return estDTO;
	}
	public void setEstDTO(EstacionMuestreoDTO estDTO) {
		this.estDTO = estDTO;
	}
	public MetodoMuestreoDTO getMetDTO() {
		return metDTO;
	}
	public void setMetDTO(MetodoMuestreoDTO metDTO) {
		this.metDTO = metDTO;
	}
	public formularioDTO getForDTO() {
		return forDTO;
	}
	public void setForDTO(formularioDTO forDTO) {
		this.forDTO = forDTO;
	}
	public GeopuntoDTO getGeoDTO() {
		return geoDTO;
	}
	public void setGeoDTO(GeopuntoDTO geoDTO) {
		this.geoDTO = geoDTO;
	}
	public UsuarioDTO getUsuDTO() {
		return usuDTO;
	}
	public void setUsuDTO(UsuarioDTO usuDTO) {
		this.usuDTO = usuDTO;
	}
	
	
}
