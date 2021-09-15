package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.EstacionMuestreoDAO;
import com.entities.EstacionMuestreo;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class EstacionMuestreoBean
 */
@Stateless
public class EstacionMuestreoBean implements EstacionMuestreoBeanRemote {

    /**
     * Default constructor. 
     */
    public EstacionMuestreoBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
	EstacionMuestreoDAO estMuestreo;

	@Override
	public void crear(EstacionMuestreo m) throws ServiciosException {
		estMuestreo.crear(m);
	}

	@Override
	public void actualizar(EstacionMuestreo m) throws ServiciosException {
		estMuestreo.actualizar(m);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		estMuestreo.borrar(id);
	}

	@Override
	public List<EstacionMuestreo> obtenerTodos() {
		return estMuestreo.obtenerTodos();
	}

}
