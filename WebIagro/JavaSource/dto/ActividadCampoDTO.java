package dto;

import java.util.Date;
import java.util.Objects;

import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Geopunto;
import com.entities.MetodoMuestreo;
import com.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ActividadCampoDTO {
	private Long idActividadCampo;
	private String nombre;
	private String descripcion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha;
	private int cantidad;
	private Usuario usuario;
	private Formulario formulario;
	private MetodoMuestreo metMuestreo;
	private EstacionMuestreo estacionMuestreo;
	private Geopunto geopunto;
	private Departamento departamento;
	public Long getIdActividadCampo() {
		return idActividadCampo;
	}
	public void setIdActividadCampo(Long idActividadCampo) {
		this.idActividadCampo = idActividadCampo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Formulario getFormulario() {
		return formulario;
	}
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	public MetodoMuestreo getMetMuestreo() {
		return metMuestreo;
	}
	public void setMetMuestreo(MetodoMuestreo metMuestreo) {
		this.metMuestreo = metMuestreo;
	}
	public EstacionMuestreo getEstacionMuestreo() {
		return estacionMuestreo;
	}
	public void setEstacionMuestreo(EstacionMuestreo estacionMuestreo) {
		this.estacionMuestreo = estacionMuestreo;
	}
	public Geopunto getGeopunto() {
		return geopunto;
	}
	public void setGeopunto(Geopunto geopunto) {
		this.geopunto = geopunto;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public ActividadCampoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, departamento, descripcion, estacionMuestreo, fecha, formulario, geopunto,
				idActividadCampo, metMuestreo, nombre, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActividadCampoDTO other = (ActividadCampoDTO) obj;
		return cantidad == other.cantidad && Objects.equals(departamento, other.departamento)
				&& Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(estacionMuestreo, other.estacionMuestreo) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(formulario, other.formulario) && Objects.equals(geopunto, other.geopunto)
				&& Objects.equals(idActividadCampo, other.idActividadCampo)
				&& Objects.equals(metMuestreo, other.metMuestreo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
	
	
	
	
}
