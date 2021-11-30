package com.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.ActividadCampoDAO;
import com.daos.DepartamentoDAO;
import com.daos.EstacionMuestreoDAO;
import com.daos.FormularioDAO;
import com.daos.MetodoMuestreoDAO;
import com.daos.RespuestaCasillaDAO;
import com.daos.UsuarioDAO;
import com.entities.ActividadCampo;
import com.entities.Casilla;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Experto;
import com.entities.Formulario;
import com.entities.MetodoMuestreo;

import com.entities.RespuestaCasilla;
import com.entities.Usuario;
import com.exception.ServiciosException;

import dto.ActividadCampoDTOS;
import dto.RespuestaCasillaDTO;

@Local
@Stateless
public class ActividadCampoBean {

	public ActividadCampoBean() {
	}

	@EJB
	ActividadCampoDAO actividadcampo;
	@EJB
	DepartamentoDAO departamento;
	@EJB
	MetodoMuestreoDAO metodo;
	@EJB
	EstacionMuestreoDAO estacion;
	@EJB
	FormularioDAO formulario;
	@EJB
	UsuarioDAO usuario;
	@EJB
	RespuestaCasillaDAO respuesta;

	public void crear(ActividadCampo ac) throws ServiciosException {
		actividadcampo.crear(ac);
	}

	public void actualizar(ActividadCampo ac) throws ServiciosException {
		actividadcampo.actualizar(ac);
	}

	public void borrar(Long id) throws ServiciosException {
		actividadcampo.borrar(id);
	}

	public List<ActividadCampo> obtenerTodos() {
		return actividadcampo.obtenerTodos();
	}

//	@Override
//	public ActividadCampo buscarPorNombre(String nom) {
//		return actividadcampo.buscarPorNombre(nom);
//	}

	public List<ActividadCampo> buscarPorFecha(Date fecha, Date fecha1) {
		// TODO Auto-generated method stub
		return actividadcampo.buscarPorFecha(fecha, fecha1);
	}

	public List<ActividadCampo> buscarPorMetM(MetodoMuestreo metM) {
		return actividadcampo.buscarPorMetM(metM);
	}

//
//	@Override
//	public ActividadCampo buscarPorEstM(String estM) {
//		// TODO Auto-generated method stub
//		return null;
////		return actividadcampo.buscarPorEstM(estM);
//	}
//
//	@Override
	public List<ActividadCampo> buscarPorUsuario(String usuario) {
		// TODO Auto-generated method stub
		return actividadcampo.buscarPorUsuario(usuario);
	}

	public void crearA(ActividadCampoDTOS acDTO) throws ServiciosException {
		ActividadCampo ac = new ActividadCampo();
		// directos
		ac.setNombre(acDTO.getNombre());
		ac.setCantidad(acDTO.getCantidad());
		ac.setDescripcion(acDTO.getDescripcion());
		ac.setFecha(acDTO.getFecha());
		// referencias a entidades
		Long idDepartamento = acDTO.getIddepartamento();
		Departamento d = departamento.buscarPorId(idDepartamento);
		if (d == null) {
			throw new ServiciosException("id de departamento inválido");
		} else {
			ac.setDepartamento(d);
		}

		Long idmetMuestreo = acDTO.getIdmetMuestreo();
		MetodoMuestreo m = metodo.buscarPorId(idmetMuestreo);
		if (m == null) {
			throw new ServiciosException("id de método de muestreo inválido");
		} else {
			ac.setMetMuestreo(m);
		}

		Long idestacionMuestreo = acDTO.getIdestacionMuestreo();
		EstacionMuestreo e = estacion.buscarPorId(idestacionMuestreo);
		if (e == null) {
			throw new ServiciosException("id de estación de muestreo inválido");
		} else {
			ac.setEstacionMuestreo(e);
		}

		Long idformulario = acDTO.getIdformulario();
		Formulario f = formulario.buscarPorId(idformulario);
		List<Casilla> casillas = new ArrayList<Casilla>();

		if (f == null) {
			throw new ServiciosException("id de formulario inválido");
		} else {
			ac.setFormulario(f);
			
			if (acDTO.getRespuestas() != null && acDTO.getRespuestas().size() > 0) {
				for (RespuestaCasillaDTO rc : acDTO.getRespuestas()) {
					casillas.add(rc.getCasilla());
				}
			}
		
		}

		
		
		
//		Long idusuario = acDTO.getIdusuario();
//		Usuario u = usuario.buscarPorId(idusuario);
//		if(u==null) {
//			throw new ServiciosException("id de usuario inválido");
//		}else {
//			ac.setUsuario(u);
//		}
		ac.setUsuario(null);

		actividadcampo.crear(ac);

		if (acDTO.getRespuestas() != null && acDTO.getRespuestas().size() != 0) {

			for (RespuestaCasillaDTO item : acDTO.getRespuestas()) {
				if(casillas!= null)
				{
					for (Casilla casilla : casillas) {
						if(casilla.getIdCasilla().equals(item.getCasilla().getIdCasilla()))
						{
							RespuestaCasilla respuestaCasilla = new RespuestaCasilla(casilla, item.getRespuesta());
							respuesta.crear(respuestaCasilla);
							break;
						}
						
					}
				}
			}
		}

	}

}
