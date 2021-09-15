package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Comun extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Comun() {
		super();
	}

	public Comun(String apellido, String contrase�a, String email, String nombUsuario, String nombre) {
		super(apellido, contrase�a, email, nombUsuario, nombre);
	}

}
