package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import com.daos.LocalidadDAO;
import com.entities.Localidad;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class LocalidadBean
 */
@Local
@Stateless
public class LocalidadBean {

    /**
     * Default constructor. 
     */
    public LocalidadBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
   	LocalidadDAO localidad;

   	public void crear(Localidad l) throws ServiciosException {
   		localidad.crear(l);
   	}

   	public void actualizar(Localidad l) throws ServiciosException {
   		localidad.actualizar(l);
   	}

   	public void borrar(Long id) throws ServiciosException {
   		localidad.borrar(id);
   	}

   	public List<Localidad> obtenerTodos() {
   		return localidad.obtenerTodos();
   	}
}
