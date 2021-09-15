package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EstacionMuestreo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ESTMUESTREO_SEQ", sequenceName = "ESTMUESTREO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTMUESTREO_SEQ")
	private Long idEstacionMuestreo;

	@Column(length = 50, nullable = false, unique = true)

	private String nombre;

	public EstacionMuestreo() {
		super();
	}

	public Long getIdEstacionMuestreo() {

		return idEstacionMuestreo;
	}

	public void setIdEstacionMuestreo(Long idEstacionMuestreo) {
		this.idEstacionMuestreo = idEstacionMuestreo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
