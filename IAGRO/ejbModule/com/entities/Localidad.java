package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Localidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LOCALIDAD_SEQ", sequenceName = "LOCALIDAD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCALIDAD_SEQ")
	private Long idLocalidad;

	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	public Localidad() {
		super();
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Localidad [nombre=" + nombre + "]";
	}

}
