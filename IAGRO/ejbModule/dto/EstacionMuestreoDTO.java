package dto;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(idEstacionMuestreo, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstacionMuestreoDTO other = (EstacionMuestreoDTO) obj;
		return Objects.equals(idEstacionMuestreo, other.idEstacionMuestreo) && Objects.equals(nombre, other.nombre);
	}
	
}
