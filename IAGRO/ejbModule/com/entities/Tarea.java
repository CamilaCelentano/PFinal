package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TAREA_SEQ", sequenceName = "TAREA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAREA_SEQ")
	private Long idTarea;

	@Column(length = 30, unique = true, nullable = false)
	private String nombre;

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tarea() {
		super();
	}

	public Tarea(String nombre) {
		super();
		this.nombre = nombre;
	}

}
