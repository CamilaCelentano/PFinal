package dto;

import java.util.Objects;

public class formularioDTO {
	private String nombre;
	private String resumen;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, resumen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		formularioDTO other = (formularioDTO) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(resumen, other.resumen);
	}
	

}
