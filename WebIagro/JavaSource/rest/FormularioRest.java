package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.FormularioBean;

import dto.formularioDTO;

@Path("/formularios")
public class FormularioRest {
	
	@EJB
	private FormularioBean formBean = new FormularioBean();
	
	@GET
	@Path("/listaFormularios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Formulario> getformularios() {
		return formBean.obtenerTodos();
	}
	
	@GET
	@Path("/formbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Formulario formularioPorId (@PathParam("id") Long id) {
		return formBean.buscarPorId(id);
	}
	
	@POST
	@Path("/crearF")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearF(formularioDTO f) {
		try {
			formBean.crear(new Formulario(f.getResumen(),f.getNombre(),null));
			return "ok";
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		return "Error";
	}
}
