package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDAD_MEDIDA")
public class UnidadMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "UNIDADMEDIDA_SEQ", sequenceName = "UNIDADMEDIDA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIDADMEDIDA_SEQ")
	private Long idUnidadMedida;

	@Column(length = 50, unique = true, nullable = false)
	private String nombre;

	public UnidadMedida() {
		super();
	}

	public Long getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Long idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UnidadMedida(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "UnidadMedida [nombre=" + nombre + "]";
	}
}
