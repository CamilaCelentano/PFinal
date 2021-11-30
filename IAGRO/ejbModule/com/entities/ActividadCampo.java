package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)//Agregue este para que haga bien el deploy por cambiar lazy por eager
	private List<RespuestaCasilla> respuestas;

	@ManyToOne
	private MetodoMuestreo metMuestreo;

	@ManyToOne
	private EstacionMuestreo estacionMuestreo;

//	@ManyToOne(optional = true)
//	private Geopunto geopunto;

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

//	public Geopunto getGeopunto() {
//		return geopunto;
//	}
//
//	public void setGeopunto(Geopunto geopunto) {
//		this.geopunto = geopunto;
//	}

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

	
	
//	public ActividadCampo(String nombre, String descripcion, Date fecha, int cantidad,
//			Usuario usuario, Formulario formulario, List<RespuestaCasilla> respuestas, MetodoMuestreo metMuestreo,
//			EstacionMuestreo estacionMuestreo, Departamento departamento) {
//		super();
//		this.nombre = nombre;
//		this.descripcion = descripcion;
//		this.fecha = fecha;
//		this.cantidad = cantidad;
//		this.usuario = usuario;
//		this.formulario = formulario;
//		this.respuestas = respuestas;
//		this.metMuestreo = metMuestreo;
//		this.estacionMuestreo = estacionMuestreo;
//		this.departamento = departamento;
//	}



	public ActividadCampo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActividadCampo(String nombre, String descripcion, Date fecha, int cantidad, Usuario usuario,
			Formulario formulario, MetodoMuestreo metMuestreo, EstacionMuestreo estacionMuestreo,
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
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActividadCampo [idActividadCampo=");
		builder.append(idActividadCampo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", formulario=");
		builder.append(formulario);
		builder.append(", respuestas=");
		builder.append(respuestas);
		builder.append(", metMuestreo=");
		builder.append(metMuestreo);
		builder.append(", estacionMuestreo=");
		builder.append(estacionMuestreo);
		builder.append(", departamento=");
		builder.append(departamento);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, departamento, descripcion, estacionMuestreo, fecha, formulario, idActividadCampo,
				metMuestreo, nombre, respuestas, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActividadCampo other = (ActividadCampo) obj;
		return cantidad == other.cantidad && Objects.equals(departamento, other.departamento)
				&& Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(estacionMuestreo, other.estacionMuestreo) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(formulario, other.formulario)
				&& Objects.equals(idActividadCampo, other.idActividadCampo)
				&& Objects.equals(metMuestreo, other.metMuestreo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(respuestas, other.respuestas) && Objects.equals(usuario, other.usuario);
	}

	
	
	
	
	

}
