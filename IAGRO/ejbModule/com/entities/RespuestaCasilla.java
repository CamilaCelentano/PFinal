package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RespuestaCasilla implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RESPUESTA_CASILLA_SEQ", sequenceName = "RESPUESTA_CASILLA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPUESTA_CASILLA_SEQ")
	private Long idRespuestaCasilla;

	@ManyToOne
	private Casilla casilla;

	private String respuesta;

	public Long getIdRespuestaCasilla() {
		return idRespuestaCasilla;
	}

	public void setIdRespuestaCasilla(Long idRespuestaCasilla) {
		this.idRespuestaCasilla = idRespuestaCasilla;
	}

	public Casilla getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public RespuestaCasilla() {
		super();
	}

	public RespuestaCasilla(Casilla casilla, String respuesta) {
		super();
		this.casilla = casilla;
		this.respuesta = respuesta;
	}
}
