package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.UnidadMedidaDAO;
import com.entities.UnidadMedida;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UnidadMedidaBean
 */
@Stateless
public class UnidadMedidaBean implements UnidadMedidaBeanRemote {

    /**
     * Default constructor. 
     */
    
    
    @EJB
	UnidadMedidaDAO unidadmedida;

    public UnidadMedidaBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void crear(UnidadMedida u) throws ServiciosException {
		unidadmedida.crear(u);
	}

	@Override
	public void actualizar(UnidadMedida u) throws ServiciosException {
		unidadmedida.actualizar(u);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		unidadmedida.borrar(id);
	}

	@Override
	public List<UnidadMedida> obtenerTodos() {
		return unidadmedida.obtenerTodos();
	}

	@Override
	public UnidadMedida buscarPorNombre(String nom) {
		return unidadmedida.buscarPorNombre(nom);
	}

}
