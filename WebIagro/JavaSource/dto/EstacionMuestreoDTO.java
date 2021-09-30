package dto;

import javax.persistence.Column;

public class EstacionMuestreoDTO {
	private Long idEstacionMuestreo;
	private String nombre;
	public Long getIdEstacionMuestreo() {
		return idEstacionMuestreo;
	}
	public void setIdEstacionMuestreo(Long idEstacionMuestreo) {
		this.idEstacionMuestreo = idEstacionMuestreo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
