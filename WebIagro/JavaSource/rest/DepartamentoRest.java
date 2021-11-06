package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.Departamento;
import com.servicios.DepartamentoBean;

@Path("/departamentos")
public class DepartamentoRest {
	
	@EJB
	private DepartamentoBean dptoBean = new DepartamentoBean();
	
	
	@GET
	@Path("/llenarSpinner")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departamento> getDepartametos() {
		return dptoBean.obtenerTodos();
	}

}
