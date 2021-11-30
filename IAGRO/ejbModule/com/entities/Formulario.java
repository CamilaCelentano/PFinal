package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "FORMULARIOS_SEQ", sequenceName = "FORMULARIOS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORMULARIOS_SEQ")
	private Long idFormulario;
	
	@Column(length = 50, nullable = false, unique = true)
	private String nombre;

	@Column(length = 100)
	private String resumen;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Casilla> casilla = new ArrayList<>();

	public Formulario(Long idFormulario) {
		super();
		this.idFormulario = idFormulario;
	}

	public Long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Casilla> getCasilla() {
		return casilla;
	}

	public void setCasilla(List<Casilla> casilla) {
		this.casilla = casilla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Formulario(String resumen, String nombre, List<Casilla> casilla) {
		super();
		this.resumen = resumen;
		this.nombre = nombre;
		this.casilla = casilla;
	}

	@Override
	public int hashCode() {
		return Objects.hash(casilla, idFormulario, nombre, resumen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formulario other = (Formulario) obj;
		return Objects.equals(casilla, other.casilla) && Objects.equals(idFormulario, other.idFormulario)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(resumen, other.resumen);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formulario [idFormulario=");
		builder.append(idFormulario);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", resumen=");
		builder.append(resumen);
		builder.append(", casilla=");
		builder.append(casilla);
		builder.append("]");
		return builder.toString();
	}

	public Formulario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
