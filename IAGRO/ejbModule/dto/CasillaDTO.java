package dto;

import java.io.Serializable;
import java.util.Objects;

import com.entities.TipoValor;
import com.entities.UnidadMedida;

public class CasillaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idCasilla;
	private String parametro;
	private String descripcion;
	private UnidadMedida unidadMedida;
	private boolean obligatorio;
	private TipoValor tipoValor;
	public Long getIdCasilla() {
		return idCasilla;
	}
	public void setIdCasilla(Long idCasilla) {
		this.idCasilla = idCasilla;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public boolean isObligatorio() {
		return obligatorio;
	}
	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	public TipoValor getTipoValor() {
		return tipoValor;
	}
	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}
	public CasillaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CasillaDTO [idCasilla=");
		builder.append(idCasilla);
		builder.append(", parametro=");
		builder.append(parametro);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", unidadMedida=");
		builder.append(unidadMedida);
		builder.append(", obligatorio=");
		builder.append(obligatorio);
		builder.append(", tipoValor=");
		builder.append(tipoValor);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idCasilla, obligatorio, parametro, tipoValor, unidadMedida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasillaDTO other = (CasillaDTO) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idCasilla, other.idCasilla)
				&& obligatorio == other.obligatorio && Objects.equals(parametro, other.parametro)
				&& tipoValor == other.tipoValor && Objects.equals(unidadMedida, other.unidadMedida);
	}
	
	

}
