package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.entities.MetodoMuestreo;
import com.servicios.MetodoMuestreoBean;

@Path("/metodomuestreos")
public class MetodoMuestreoRest {
	
	@EJB
	private MetodoMuestreoBean metMBean = new MetodoMuestreoBean();
	
	@GET
	@Path("/llenarSpinner")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MetodoMuestreo> getMetodoMuestreos() {
		return metMBean.obtenerTodos();
	}

}
