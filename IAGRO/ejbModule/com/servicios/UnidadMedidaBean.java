package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.daos.UnidadMedidaDAO;
import com.entities.UnidadMedida;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UnidadMedidaBean
 */
@Local
@Stateless
public class UnidadMedidaBean {

    /**
     * Default constructor. 
     */
    
    
    @EJB
	UnidadMedidaDAO unidadmedida;

    public UnidadMedidaBean() {
        // TODO Auto-generated constructor stub
    }
    
	public void crear(UnidadMedida u) throws ServiciosException {
		unidadmedida.crear(u);
	}

	public void actualizar(UnidadMedida u) throws ServiciosException {
		unidadmedida.actualizar(u);
	}

	public void borrar(Long id) throws ServiciosException {
		unidadmedida.borrar(id);
	}

	public List<UnidadMedida> obtenerTodos() {
		return unidadmedida.obtenerTodos();
	}

	public UnidadMedida buscarPorNombre(String nom) {
		return unidadmedida.buscarPorNombre(nom);
	}

}
