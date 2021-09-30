package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import com.daos.MetodoMuestreoDAO;
import com.entities.MetodoMuestreo;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class MetodoMuestreoBean
 */
@Local
@Stateless
public class MetodoMuestreoBean{

    /**
     * Default constructor. 
     */
    public MetodoMuestreoBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
   	MetodoMuestreoDAO metmuestreo;

 
   	public void crear(MetodoMuestreo m) throws ServiciosException {
   		metmuestreo.crear(m);
   	}

   	
   	public void actualizar(MetodoMuestreo m) throws ServiciosException {
   		metmuestreo.actualizar(m);
   	}

   	
   	public void borrar(Long id) throws ServiciosException {
   		metmuestreo.borrar(id);
   	}

   	
   	public List<MetodoMuestreo> obtenerTodos() {
   		return metmuestreo.obtenerTodos();
   	}

}
