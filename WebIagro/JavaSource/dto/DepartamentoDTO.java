package dto;

import java.util.Objects;

public class DepartamentoDTO {
	private Long idDepartamento;
	private String nombre;
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DepartamentoDTO() {
		
	}
	public DepartamentoDTO(Long idDepartamento, String nombre) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idDepartamento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoDTO other = (DepartamentoDTO) obj;
		return Objects.equals(idDepartamento, other.idDepartamento) && Objects.equals(nombre, other.nombre);
	}
	
	
}
