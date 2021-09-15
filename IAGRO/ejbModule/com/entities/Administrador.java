package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Administrador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 15, unique = true, nullable = false)
	private String cedula;

	@Column(length = 50, nullable = false)
	private String instituto;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public Administrador() {
		super();
	}

	public Administrador(String apellido, String contraseña, String email, String nombUsuario, String nombre,
			String cedula, String instituto) {
		super(apellido, contraseña, email, nombUsuario, nombre);
		this.cedula = cedula;
		this.instituto = instituto;
	}

}