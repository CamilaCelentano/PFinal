package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.ActividadCampo;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;
import com.servicios.ActividadCampoBean;
import com.servicios.DepartamentoBean;
import com.servicios.EstacionMuestreoBean;
import com.servicios.MetodoMuestreoBean;

import dto.ActividadCampoDTO;

@Path("/actividades")
public class ActividadRest {
	@EJB
	private ActividadCampoBean actBean = new ActividadCampoBean();
	
	
	@GET
	@Path("/listaActividades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadCampo> getActividades() {
		return actBean.obtenerTodos();
	}
	
	
	@POST
	@Path("/crearA")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearA(ActividadCampoDTO a) {
		try {
			actBean.crear(new ActividadCampo( a.getDescripcion(),a.getFecha(), a.getNombre(), a.getCantidad(),null, a.getFormulario(), a.getMetMuestreo(), a.getEstacionMuestreo(), null ,a.getDepartamento()));
			return "ok";
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		return "Error";
	}
	
}
