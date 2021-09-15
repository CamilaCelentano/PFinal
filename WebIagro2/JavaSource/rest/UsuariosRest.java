package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.entities.Comun;
import com.entities.MD5;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.ComunBean;
import com.servicios.UsuarioBean;

@Path("/usuarios")
public class UsuariosRest {

	@EJB
	private UsuarioBean usuBean = new UsuarioBean();

	@EJB
	private ComunBean comBean = new ComunBean();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		return usuBean.obtenerTodos();
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
	public String login(Parametros p) {
		Usuario u = usuBean.buscarPorNombreUsuario(p.getNombre());
		if (u != null) {
			if (u.isActivo()) {
				if (u.getContraseña().equals(MD5.getMd5(p.getPassword()))) {
					return "Logeo correcto.";
				} else {
					return "Contraseña incorrecta.";
				}
			} else {
				return "El Usuario se encuentra inactivo.";
			}
		} else {
			return "El Usuario no existe.";
		}
	}
}	
