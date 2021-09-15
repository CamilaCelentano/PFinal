package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Casilla implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "CASILLAS_SEQ", sequenceName = "CASILLAS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASILLAS_SEQ")
	private Long idCasilla;

	@Column(length = 50, nullable = false, unique = true)
	private String parametro;

	@Column(length = 50)
	private String descripcion;

	@ManyToOne(optional = false)
	private UnidadMedida unidadMedida;

	@Column(nullable = false)
	private boolean obligatorio;

	@Enumerated(EnumType.STRING)
	private TipoValor tipoValor;

	public Casilla() {
		super();
	}

	public boolean isObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public Long getIdCasilla() {
		return idCasilla;
	}

	public void setIdCasilla(Long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Casilla(String parametro, String descripcion, UnidadMedida unidadMedida, boolean obligatorio,
			TipoValor tipoValor) {
		super();
		this.parametro = parametro;
		this.descripcion = descripcion;
		this.unidadMedida = unidadMedida;
		this.obligatorio = obligatorio;
		this.tipoValor = tipoValor;
	}

	@Override
	public String toString() {
		return "Casilla [idCasilla=" + idCasilla + ", parametro=" + parametro + ", descripcion=" + descripcion
				+ ", unidadMedida=" + unidadMedida + ", obligatorio=" + obligatorio + ", tipoValor=" + tipoValor + "]";
	}

}
