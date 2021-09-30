package dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Geopunto;
import com.entities.MetodoMuestreo;
import com.entities.RespuestaCasilla;
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
	private List<RespuestaCasilla> respuestas;
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
	public List<RespuestaCasilla> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<RespuestaCasilla> respuestas) {
		this.respuestas = respuestas;
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
	
}
