package com.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MetodoMuestreo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "METMUESTREO_SEQ", sequenceName = "METMUESTREO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "METMUESTREO_SEQ")
	private Long idMetodoMuestreo;

	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	public MetodoMuestreo() {
		super();
	}

	public Long getIdMetodoMuestreo() {
		return idMetodoMuestreo;
	}

	public void setIdMetodoMuestreo(Long idMetodoMuestreo) {
		this.idMetodoMuestreo = idMetodoMuestreo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MetodoMuestreo [idMetodoMuestreo=");
		builder.append(idMetodoMuestreo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMetodoMuestreo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetodoMuestreo other = (MetodoMuestreo) obj;
		return Objects.equals(idMetodoMuestreo, other.idMetodoMuestreo) && Objects.equals(nombre, other.nombre);
	}
	
	
}
