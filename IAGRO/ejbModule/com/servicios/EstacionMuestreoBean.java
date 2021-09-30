package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import com.daos.EstacionMuestreoDAO;
import com.entities.EstacionMuestreo;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class EstacionMuestreoBean
 */
@Local
@Stateless
public class EstacionMuestreoBean{

    /**
     * Default constructor. 
     */
    public EstacionMuestreoBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
	EstacionMuestreoDAO estMuestreo;

	public void crear(EstacionMuestreo m) throws ServiciosException {
		estMuestreo.crear(m);
	}

	public void actualizar(EstacionMuestreo m) throws ServiciosException {
		estMuestreo.actualizar(m);
	}

	public void borrar(Long id) throws ServiciosException {
		estMuestreo.borrar(id);
	}

	public List<EstacionMuestreo> obtenerTodos() {
		return estMuestreo.obtenerTodos();
	}

}
