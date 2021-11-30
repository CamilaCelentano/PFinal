package dto;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(idMetodoMuestreo, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetodoMuestreoDTO other = (MetodoMuestreoDTO) obj;
		return Objects.equals(idMetodoMuestreo, other.idMetodoMuestreo) && Objects.equals(nombre, other.nombre);
	}
	
}
