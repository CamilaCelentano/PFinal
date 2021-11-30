package dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Geopunto;
import com.entities.MetodoMuestreo;
import com.entities.RespuestaCasilla;
import com.entities.Usuario;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
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
	private List<RespuestaCasilla> respuestas;
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
	
	public List<RespuestaCasilla> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<RespuestaCasilla> respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, departamento, descripcion, estacionMuestreo, fecha, formulario, geopunto,
				idActividadCampo, metMuestreo, nombre, respuestas, usuario);
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
				&& Objects.equals(respuestas, other.respuestas) && Objects.equals(usuario, other.usuario);
	}
	public ActividadCampoDTO(Long idActividadCampo, String nombre, String descripcion, Date fecha, int cantidad,
			Usuario usuario, Formulario formulario, MetodoMuestreo metMuestreo, EstacionMuestreo estacionMuestreo,
			Geopunto geopunto, Departamento departamento, List<RespuestaCasilla> respuestas) {
		super();
		this.idActividadCampo = idActividadCampo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.usuario = usuario;
		this.formulario = formulario;
		this.metMuestreo = metMuestreo;
		this.estacionMuestreo = estacionMuestreo;
		this.geopunto = geopunto;
		this.departamento = departamento;
		this.respuestas = respuestas;
	}
	
	
	
	
	
	
	
}
