package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.LocalidadDAO;
import com.entities.Localidad;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
public class LocalidadBean implements LocalidadBeanRemote {

    /**
     * Default constructor. 
     */
    public LocalidadBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
   	LocalidadDAO localidad;

   	@Override
   	public void crear(Localidad l) throws ServiciosException {
   		localidad.crear(l);
   	}

   	@Override
   	public void actualizar(Localidad l) throws ServiciosException {
   		localidad.actualizar(l);
   	}

   	@Override
   	public void borrar(Long id) throws ServiciosException {
   		localidad.borrar(id);
   	}

   	@Override
   	public List<Localidad> obtenerTodos() {
   		return localidad.obtenerTodos();
   	}
}
