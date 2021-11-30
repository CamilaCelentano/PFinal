package dto;

import java.util.Objects;

import javax.persistence.Column;

public class UsuarioDTO {
	private Long idUsuario;
	private String apellido;
	private String contrase�a;
	private String email;
	private String nombUsuario;
	private String nombre;
	private boolean activo;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombUsuario() {
		return nombUsuario;
	}
	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public UsuarioDTO(Long idUsuario, String apellido, String contrase�a, String email, String nombUsuario,
			String nombre, boolean activo) {
		super();
		this.idUsuario = idUsuario;
		this.apellido = apellido;
		this.contrase�a = contrase�a;
		this.email = email;
		this.nombUsuario = nombUsuario;
		this.nombre = nombre;
		this.activo = activo;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(activo, apellido, contrase�a, email, idUsuario, nombUsuario, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return activo == other.activo && Objects.equals(apellido, other.apellido)
				&& Objects.equals(contrase�a, other.contrase�a) && Objects.equals(email, other.email)
				&& Objects.equals(idUsuario, other.idUsuario) && Objects.equals(nombUsuario, other.nombUsuario)
				&& Objects.equals(nombre, other.nombre);
	}
	
	


}
