package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.MetodoMuestreoDAO;
import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class MetodoMuestreoBean
 */
@Stateless
public class MetodoMuestreoBean implements MetodoMuestreoBeanRemote {

    /**
     * Default constructor. 
     */
    public MetodoMuestreoBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
   	MetodoMuestreoDAO metmuestreo;

   	@Override
   	public void crear(MetodoMuestreo m) throws ServiciosException {
   		metmuestreo.crear(m);
   	}

   	@Override
   	public void actualizar(MetodoMuestreo m) throws ServiciosException {
   		metmuestreo.actualizar(m);
   	}

   	@Override
   	public void borrar(Long id) throws ServiciosException {
   		metmuestreo.borrar(id);
   	}

   	@Override
   	public List<MetodoMuestreo> obtenerTodos() {
   		return metmuestreo.obtenerTodos();
   	}

}
