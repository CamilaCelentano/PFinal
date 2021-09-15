package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Experto extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 15, unique = true, nullable = false)
	private String cedula;

	@Column(length = 30, nullable = false)
	private String profesion;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Experto() {
		super();
	}

	public Experto(String apellido, String contraseña, String email, String nombUsuario, String nombre, String cedula,
			String profesion) {
		super(apellido, contraseña, email, nombUsuario, nombre);
		this.cedula = cedula;
		this.profesion = profesion;
	}
	

}
