package rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.controlador.ControladorLoginUsuario;
import com.entities.ActividadCampo;
import com.entities.Casilla;
import com.entities.Formulario;
import com.entities.RespuestaCasilla;
import com.exception.ServiciosException;
import com.servicios.ActividadCampoBean;
import com.servicios.FormularioBean;
import com.servicios.RespuestaCasillaBean;

import dto.ActividadCampoDTO;
import dto.ActividadCampoDTOS;
import dto.DepartamentoDTO;
import dto.EstacionMuestreoDTO;
import dto.GeopuntoDTO;
import dto.MetodoMuestreoDTO;
import dto.formularioDTO;

@Path("/actividades")
public class ActividadRest {
	@EJB
	private ActividadCampoBean actBean = new ActividadCampoBean();
	@EJB
	private FormularioBean formBean = new FormularioBean();
	@EJB
	private RespuestaCasillaBean respBean = new RespuestaCasillaBean();
	private ControladorLoginUsuario ctl = new ControladorLoginUsuario();
	private Casilla casilla = new Casilla();
	
	@GET
	@Path("/listaActividades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadCampo> getActividades() {
		return actBean.obtenerTodos();
	}
	
	@POST
	@Path("/crearA")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearA(ActividadCampoDTOS a) throws JSONException{

		boolean error = true;
		JSONObject jsonString = new JSONObject().put("error", error);
		try {
			
			if (a != null) {
				actBean.crearA(a);
				jsonString.put("error", false);
				jsonString.put("mensaje", "Se creó correctamente la actividad");
				return jsonString.toString();
			}
			
		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
			jsonString.put("mensaje", e.getMessage());
			return jsonString.toString();
		}
		jsonString.put("mensaje", "Error al crear actividad");
		return jsonString.toString();
	}
	
	@POST
	@Path("/crearAct")
	public ActividadCampo crearAct(Formulario f){
		List<Casilla> listaC= new ArrayList<Casilla>(f.getCasilla());
		ActividadCampo a = new ActividadCampo();
		RespuestaCasilla r = new RespuestaCasilla();
		for(int i = 0; i<=listaC.size();i++) {
			r.setCasilla(listaC.get(i));
			try {
				respBean.crear(r);
			} catch (ServiciosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return a;
			
	}
	
}
