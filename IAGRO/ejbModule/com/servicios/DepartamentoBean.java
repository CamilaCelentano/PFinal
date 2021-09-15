package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.daos.DepartamentoDAO;
import com.entities.Departamento;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote {

	@EJB
	DepartamentoDAO departamento;

	@Override
	public void crear(Departamento d) throws ServiciosException {
		departamento.crear(d);
	}

	@Override
	public void actualizar(Departamento d) throws ServiciosException {
		departamento.crear(d);
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		departamento.borrar(id);
	}

	@Override
	public List<Departamento> obtenerTodos() {
		return departamento.obtenerTodos();
	}
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }

}
