package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.TipoMuestreoDAO;
import com.entities.TipoMuestreo;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class TipoMuestreoBean
 */
@Stateless
public class TipoMuestreoBean implements TipoMuestreoBeanRemote {

    /**
     * Default constructor. 
     */
    public TipoMuestreoBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
   	TipoMuestreoDAO tipomuestreo;

   	@Override
   	public void crear(TipoMuestreo t) throws ServiciosException {
   		tipomuestreo.crear(t);
   	}

   	@Override
   	public void actualizar(TipoMuestreo t) throws ServiciosException {
   		tipomuestreo.actualizar(t);
   	}

   	@Override
   	public void borrar(Long id) throws ServiciosException {
   		tipomuestreo.borrar(id);
   	}

   	@Override
   	public List<TipoMuestreo> obtenerTodos() {
   		return tipomuestreo.obtenerTodos();
   	}

}
