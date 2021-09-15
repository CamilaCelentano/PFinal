package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Geopunto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "GEOPUNTO_SEQ", sequenceName = "GEOPUNTO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEOPUNTO_SEQ")
	private Long idGeopunto;

	@Column(length = 20, nullable = false)
	private Long latitud;

	@Column(length = 20, nullable = false)
	private Long longitud;

	public Long getIdGeopunto() {
		return idGeopunto;
	}

	public void setIdGeopunto(Long idGeopunto) {
		this.idGeopunto = idGeopunto;
	}

	public Long getLatitud() {
		return latitud;
	}

	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}

	public Long getLongitud() {
		return longitud;
	}

	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}

	public Geopunto() {
		super();
	}

	public Geopunto(Long latitud, Long longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

}
