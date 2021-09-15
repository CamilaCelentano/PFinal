package clienteGUI;

import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.ActividadCampo;
import com.entities.Administrador;
import com.entities.Casilla;
import com.entities.Comun;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Experto;
import com.entities.Formulario;
import com.entities.MetodoMuestreo;
import com.entities.TipoValor;
import com.entities.UnidadMedida;
import com.servicios.ActividadCampoBeanRemote;
import com.servicios.AdministradorBeanRemote;
import com.servicios.CasillaBeanRemote;
import com.servicios.ComunBeanRemote;
import com.servicios.DepartamentoBeanRemote;
import com.servicios.EstacionMuestreoBeanRemote;
import com.servicios.ExpertoBeanRemote;
import com.servicios.FormularioBeanRemote;
import com.servicios.MetodoMuestreoBeanRemote;
import com.servicios.UnidadMedidaBeanRemote;

public class Cliente {

	public static void main(String[] args) throws NamingException {
//		

		cargarUsuarios();
		ActividadCampoBeanRemote acBean = (ActividadCampoBeanRemote) InitialContext
				.doLookup("IAGRO/ActividadCampoBean!com.servicios.ActividadCampoBeanRemote");
		
//		for (ActividadCampo ac : acBean.obtenerTodos()) {
//			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
//			String stringDate= DateFor.format(ac.getFecha());
//			System.out.println(stringDate);
//		}
//	
		
	}

	public static void cargarUsuarios() throws NamingException {
		ExpertoBeanRemote expertoBean = (ExpertoBeanRemote) InitialContext
				.doLookup("IAGRO/ExpertoBean!com.servicios.ExpertoBeanRemote");
		ComunBeanRemote comunBean = (ComunBeanRemote) InitialContext
				.doLookup("IAGRO/ComunBean!com.servicios.ComunBeanRemote");
		AdministradorBeanRemote adminBean = (AdministradorBeanRemote) InitialContext
				.doLookup("IAGRO/AdministradorBean!com.servicios.AdministradorBeanRemote");
		UnidadMedidaBeanRemote umed = (UnidadMedidaBeanRemote) InitialContext
				.doLookup("IAGRO/UnidadMedidaBean!com.servicios.UnidadMedidaBeanRemote");
		CasillaBeanRemote casillaBean = (CasillaBeanRemote) InitialContext
				.doLookup("IAGRO/CasillaBean!com.servicios.CasillaBeanRemote");
		FormularioBeanRemote fBean = (FormularioBeanRemote) InitialContext
				.doLookup("IAGRO/FormularioBean!com.servicios.FormularioBeanRemote");
		EstacionMuestreoBeanRemote estBean = (EstacionMuestreoBeanRemote) InitialContext
				.doLookup("IAGRO/EstacionMuestreoBean!com.servicios.EstacionMuestreoBeanRemote");
		MetodoMuestreoBeanRemote metBean = (MetodoMuestreoBeanRemote) InitialContext
				.doLookup("IAGRO/MetodoMuestreoBean!com.servicios.MetodoMuestreoBeanRemote");
		DepartamentoBeanRemote depBean = (DepartamentoBeanRemote) InitialContext
				.doLookup("IAGRO/DepartamentoBean!com.servicios.DepartamentoBeanRemote");
		ActividadCampoBeanRemote acBean = (ActividadCampoBeanRemote) InitialContext
				.doLookup("IAGRO/ActividadCampoBean!com.servicios.ActividadCampoBeanRemote");

		Experto ex = new Experto("ape", "con", "mail", "experto", "nom", "12345", "prof");
		Comun com = new Comun("ape", "con", "mail2", "comun", "nom");
		Administrador adm = new Administrador("ape", "con", "mail3", "admin", "nom", "165421", "instituto");

		UnidadMedida um = new UnidadMedida("m cuadrados");

		EstacionMuestreo em = new EstacionMuestreo();
		em.setNombre("Estacion 1");
		MetodoMuestreo mm = new MetodoMuestreo();
		mm.setNombre("Metodo 1");
		Departamento dpto = new Departamento();
		dpto.setNombre("Canelones");

		try {
			estBean.crear(em);
			em.setNombre("Estacion 2");
			estBean.crear(em);
			metBean.crear(mm);
			mm.setNombre("Metodo 2");
			metBean.crear(mm);
			depBean.crear(dpto);
			dpto.setNombre("Durazno");
			depBean.crear(dpto);
			dpto.setNombre("Montevideo");
			depBean.crear(dpto);

			comunBean.crear(com);
			expertoBean.crear(ex);
			adminBean.crear(adm);
			umed.crear(um);
			Casilla c = new Casilla("Espacio ocupado", "desc", umed.buscarPorNombre("m cuadrados"), true,
					TipoValor.STRING);
			Casilla c2 = new Casilla("Prueba 2", "desc", umed.buscarPorNombre("m cuadrados"), true, TipoValor.STRING);
			Casilla c3 = new Casilla("Prueba 3", "desc", umed.buscarPorNombre("m cuadrados"), false, TipoValor.STRING);
			casillaBean.crear(c);
			casillaBean.crear(c2);
			casillaBean.crear(c3);
			Formulario f = new Formulario();
			f.setNombre("Formulario Prueba");
			f.setResumen("Prueba");
			fBean.crear(f);
			f = fBean.buscar("Formulario Prueba");
			fBean.asignarCasilla(f.getIdFormulario(), casillaBean.buscar("Espacio ocupado").getIdCasilla());
			fBean.asignarCasilla(f.getIdFormulario(), casillaBean.buscar("Prueba 2").getIdCasilla());
			fBean.asignarCasilla(f.getIdFormulario(), casillaBean.buscar("Prueba 3").getIdCasilla());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
