package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DEPARTAMENTO_SEQ", sequenceName = "DEPARTAMENTO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTAMENTO_SEQ")
	private Long idDepartamento;

	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	public Departamento() {
		super();
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
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

	public Departamento(Long idDepartamento, String nombre) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}
	

}
