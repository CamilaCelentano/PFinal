package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoMuestreo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TIPOMUESTREO_SEQ", sequenceName = "TIPOMUESTREO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOMUESTREO_SEQ")
	private Long idTipoMuestreo;

	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	public TipoMuestreo() {
		super();
	}

	public Long getIdTipoMuestreo() {
		return idTipoMuestreo;
	}

	public void setIdTipoMuestreo(Long idTipoMuestreo) {
		this.idTipoMuestreo = idTipoMuestreo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoMuestreo [nombre=" + nombre + "]";
	}

}
