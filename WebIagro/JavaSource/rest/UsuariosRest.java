package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import org.jboss.resteasy.spi.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Experto;
import com.entities.MD5;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.AdministradorBean;
import com.servicios.ComunBean;
import com.servicios.ExpertoBean;
import com.servicios.UsuarioBean;

@Path("/usuarios")
public class UsuariosRest {

	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@EJB
	private ComunBean comBean = new ComunBean();

	@EJB
	private AdministradorBean admBean = new AdministradorBean();

	@EJB
	private ExpertoBean expBean = new ExpertoBean();

	@GET
	@Path("/listaCom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comun> getUsuarios() {
		return comBean.obtenerTodos();
	}

	@GET
	@Path("/listaAdm")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Administrador> getAdministrador() {
		return admBean.obtenerTodos();
	}

	@GET
	@Path("/listaExp")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Experto> getExperto() {
		return expBean.obtenerTodos();
	}

	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String create() {
		try {
			comBean.crear(new Comun("apellidoComun", MD5.getMd5("12345"), "comun@gmail.com", "comun", "nombreComun"));
			return "ok";
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		return "Error";
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(Parametros p) throws JSONException {
	
		boolean error = true;
		JSONObject jsonString = new JSONObject().put("error", error);

//            .put("JSON3", new JSONObject().put("key1", "value1"))
		try {
			Usuario u = usuBean.buscarPorNombreUsuario(p.getNombre());
			if (u != null) {
				if (u.isActivo()) {
					if (u.getContraseña().equals(MD5.getMd5(p.getPassword()))) {
						jsonString.put("error", false);
						jsonString.put("mensaje", "Login exitoso.");
						return jsonString.toString();
					} else {
						jsonString.put("mensaje", "Por favor revise sus datos.");
						return jsonString.toString();
					}
				} else {
					jsonString.put("mensaje", "Usuario inactivo.");
					return jsonString.toString();
				}
			} else {
				jsonString.put("mensaje", "Usuario no existe.");
				return jsonString.toString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			jsonString.put("mensaje", e.getMessage());
			return jsonString.toString();
		}
	}

	@POST
	@Path("/crearC")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearC(Parametros p) {
		try {
			comBean.crear(new Comun(p.getApellido(), p.getPassword(), p.getEmail(), p.getNombre(), p.getNombUsuario()));
			return "ok";
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		return "Error";
	}

	@POST
	@Path("/crearA")
	@Produces(MediaType.APPLICATION_JSON)
	public String crearA(Administrador a) {
		try {
			admBean.crear(new Administrador(a.getApellido(), a.getCedula(), a.getContraseña(), a.getEmail(),
					a.getInstituto(), a.getNombre(), a.getNombUsuario()));
			return "ok";
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		return "Error";
	}
}
