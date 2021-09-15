package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.ZonasDAO;
import com.entities.Zonas;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ZonasBean
 */
@Stateless
public class ZonasBean implements ZonasBeanRemote {

    /**
     * Default constructor. 
     */
    public ZonasBean() {
        // TODO Auto-generated constructor stub
    }
    @EJB
	ZonasDAO zona;

	@Override
	public void crear(Zonas z) throws ServiciosException {
		zona.crear(z);
	}

	@Override
	public void actualizar(Zonas z) throws ServiciosException {
		zona.actualizar(z);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		zona.borrar(id);
	}

	@Override
	public List<Zonas> obtenerTodos() {
		return zona.obtenerTodos();
	}
}
