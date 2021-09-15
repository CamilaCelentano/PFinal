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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
	private Long idUsuario;

	@Column(length = 30, nullable = false)
	private String apellido;

	@Column(length = 32, nullable = false)
	private String contraseña;

	@Column(length = 50, unique = true, nullable = false)
	private String email;

	@Column(length = 25, unique = true, nullable = false)
	private String nombUsuario;

	@Column(length = 30, nullable = false)
	private String nombre;

	@Column
	private boolean activo;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Tarea> tareas = new ArrayList<Tarea>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = MD5.getMd5(contraseña);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombUsuario() {
		return nombUsuario;
	}

	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Usuario() {
		this.activo = true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido=" + apellido + ", contraseña=" + contraseña + ", email="
				+ email + ", nombUsuario=" + nombUsuario + ", nombre=" + nombre + ", activo=" + activo + "]";
	}

	public Usuario(String apellido, String contraseña, String email, String nombUsuario, String nombre) {
		super();
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.email = email;
		this.nombUsuario = nombUsuario;
		this.nombre = nombre;
		this.activo = true;
	}

}
