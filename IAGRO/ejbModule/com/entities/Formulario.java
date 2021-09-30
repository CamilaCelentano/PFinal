package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public Formulario() {
		super();
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
}
