package dto;



import java.util.Objects;

import com.entities.Casilla;

public class RespuestaCasillaDTO {
	
	private Long idRespuestaCasilla;
	private Casilla casilla;
	private String respuesta;
	
	public Long getIdRespuestaCasilla() {
		return idRespuestaCasilla;
	}
	public void setIdRespuestaCasilla(Long idRespuestaCasilla) {
		this.idRespuestaCasilla = idRespuestaCasilla;
	}
	public Casilla getCasilla() {
		return casilla;
	}
	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(casilla, idRespuestaCasilla, respuesta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespuestaCasillaDTO other = (RespuestaCasillaDTO) obj;
		return Objects.equals(casilla, other.casilla) && Objects.equals(idRespuestaCasilla, other.idRespuestaCasilla)
				&& Objects.equals(respuesta, other.respuesta);
	}
	
	
	
}
