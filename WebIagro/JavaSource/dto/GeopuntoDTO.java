package dto;

import javax.persistence.Column;

public class GeopuntoDTO {
	private Long idGeopunto;
	private Long latitud;
	private Long longitud;
	public Long getIdGeopunto() {
		return idGeopunto;
	}
	public void setIdGeopunto(Long idGeopunto) {
		this.idGeopunto = idGeopunto;
	}
	public Long getLatitud() {
		return latitud;
	}
	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}
	public Long getLongitud() {
		return longitud;
	}
	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}

}
