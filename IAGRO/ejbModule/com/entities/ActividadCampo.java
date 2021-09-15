package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class ActividadCampo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ACTIVIDADES_CAMPO_SEQ", sequenceName = "ACTIVIDADES_CAMPO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDADES_CAMPO_SEQ")
	private Long idActividadCampo;

	@Column(length = 100, nullable = false, unique = true)
	private String nombre;

	@Column(length = 100)
	private String descripcion;

	@Column(length = 10, nullable = false)
	private Date fecha;

	@Column(nullable = true)
	private int cantidad;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Formulario formulario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RespuestaCasilla> respuestas;

	@ManyToOne
	private MetodoMuestreo metMuestreo;

	@ManyToOne
	private EstacionMuestreo estacionMuestreo;

	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	private Geopunto geopunto;

	@ManyToOne
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Long getIdActividadCampo() {
		return idActividadCampo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Geopunto getGeopunto() {
		return geopunto;
	}

	public void setGeopunto(Geopunto geopunto) {
		this.geopunto = geopunto;
	}

	public void setIdActividadCampo(Long idActividadCampo) {
		this.idActividadCampo = idActividadCampo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public MetodoMuestreo getMetMuestreo() {
		return metMuestreo;
	}

	public void setMetMuestreo(MetodoMuestreo metMuestreo) {
		this.metMuestreo = metMuestreo;
	}

	public EstacionMuestreo getEstacionMuestreo() {
		return estacionMuestreo;
	}

	public void setEstacionMuestreo(EstacionMuestreo estacionMuestreo) {
		this.estacionMuestreo = estacionMuestreo;
	}

	public List<RespuestaCasilla> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaCasilla> respuestas) {
		this.respuestas = respuestas;
	}

	public ActividadCampo() {
		super();
	}

	public ActividadCampo(String nombre, String descripcion, Date fecha, int cantidad, Usuario usuario,
			Formulario formulario, MetodoMuestreo metMuestreo, EstacionMuestreo estacionMuestreo, Geopunto geopunto,
			Departamento departamento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.usuario = usuario;
		this.formulario = formulario;
		this.metMuestreo = metMuestreo;
		this.estacionMuestreo = estacionMuestreo;
		this.geopunto = geopunto;
		this.departamento = departamento;
	}

}
