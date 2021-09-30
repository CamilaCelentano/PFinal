package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import com.daos.DepartamentoDAO;
import com.entities.Departamento;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Local
@Stateless
public class DepartamentoBean{

	@EJB
	DepartamentoDAO departamento;

	public void crear(Departamento d) throws ServiciosException {
		departamento.crear(d);
	}

	public void actualizar(Departamento d) throws ServiciosException {
		departamento.actualizar(d);
	}

	public void borrar(Long id) throws ServiciosException {
		departamento.borrar(id);
	}

	public List<Departamento> obtenerTodos() {
		return departamento.obtenerTodos();
	}
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }
    public Departamento obtenerporId(Long id) {
		return departamento.buscarPorId(id);
	}
}
