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
import com.fasterxml.jackson.annotation.JsonFormat;


public class ActividadCampoDTOS {
	private Long idActividadCampo;
	private String nombre;
	private String descripcion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha;
	private int cantidad;
	
	private Long idusuario;
	private Long idformulario;
	private Long idmetMuestreo;
	private Long idestacionMuestreo;
	private Long iddepartamento;
	private List<RespuestaCasillaDTO> respuestas;
	
	public ActividadCampoDTOS() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public Long getIdformulario() {
		return idformulario;
	}

	public void setIdformulario(Long idformulario) {
		this.idformulario = idformulario;
	}

	public Long getIdmetMuestreo() {
		return idmetMuestreo;
	}

	public void setIdmetMuestreo(Long idmetMuestreo) {
		this.idmetMuestreo = idmetMuestreo;
	}

	public Long getIdestacionMuestreo() {
		return idestacionMuestreo;
	}

	public void setIdestacionMuestreo(Long idestacionMuestreo) {
		this.idestacionMuestreo = idestacionMuestreo;
	}

	public Long getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Long iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public List<RespuestaCasillaDTO> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaCasillaDTO> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, fecha, idActividadCampo, iddepartamento, idestacionMuestreo,
				idformulario, idmetMuestreo, idusuario, nombre, respuestas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActividadCampoDTOS other = (ActividadCampoDTOS) obj;
		return cantidad == other.cantidad && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(idActividadCampo, other.idActividadCampo)
				&& Objects.equals(iddepartamento, other.iddepartamento)
				&& Objects.equals(idestacionMuestreo, other.idestacionMuestreo)
				&& Objects.equals(idformulario, other.idformulario)
				&& Objects.equals(idmetMuestreo, other.idmetMuestreo) && Objects.equals(idusuario, other.idusuario)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(respuestas, other.respuestas);
	}

	public ActividadCampoDTOS(Long idActividadCampo, String nombre, String descripcion, Date fecha, int cantidad,
			Long idusuario, Long idformulario, Long idmetMuestreo, Long idestacionMuestreo, Long iddepartamento,
			List<RespuestaCasillaDTO> respuestas) {
		super();
		this.idActividadCampo = idActividadCampo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.idusuario = idusuario;
		this.idformulario = idformulario;
		this.idmetMuestreo = idmetMuestreo;
		this.idestacionMuestreo = idestacionMuestreo;
		this.iddepartamento = iddepartamento;
		this.respuestas = respuestas;
	}
	


	
	
	
	
	
	
	
	
}
