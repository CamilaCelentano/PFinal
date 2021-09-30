package dto;

import javax.persistence.Column;

public class MetodoMuestreoDTO {
	private Long idMetodoMuestreo;
	private String nombre;
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
	
}
