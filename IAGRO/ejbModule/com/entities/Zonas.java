package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Zonas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ZONAS_SEQ", sequenceName = "ZONAS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ZONAS_SEQ")
	private Long idZona;

	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	public Zonas() {
		super();
	}

	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Zonas [nombre=" + nombre + "]";
	}

}
