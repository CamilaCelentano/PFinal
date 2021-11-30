package dto;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(idGeopunto, latitud, longitud);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeopuntoDTO other = (GeopuntoDTO) obj;
		return Objects.equals(idGeopunto, other.idGeopunto) && Objects.equals(latitud, other.latitud)
				&& Objects.equals(longitud, other.longitud);
	}

}
