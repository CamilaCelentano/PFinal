package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.EstacionMuestreo;
import com.servicios.EstacionMuestreoBean;

@Path("/estacionmuestreo")
public class EstacionMuestreoRest {

	@EJB
	private EstacionMuestreoBean estMBean = new EstacionMuestreoBean();
	
	@GET
	@Path("/llenarSpinner")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstacionMuestreo> getEstacionMuestreos() {
		return estMBean.obtenerTodos();
	}
}
