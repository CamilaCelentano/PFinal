package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.ActividadCampo;
import com.entities.Casilla;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Formulario;
import com.entities.Geopunto;
import com.entities.MetodoMuestreo;
import com.entities.RespuestaCasilla;
import com.entities.TipoValor;
import com.exception.ServiciosException;
import com.servicios.ActividadCampoBeanRemote;
import com.servicios.CasillaBeanRemote;
import com.servicios.DepartamentoBeanRemote;
import com.servicios.EstacionMuestreoBeanRemote;
import com.servicios.FormularioBeanRemote;
import com.servicios.MetodoMuestreoBeanRemote;
import com.servicios.RespuestaCasillaBeanRemote;
import com.toedter.calendar.JDateChooser;

public class AltaActividad {

	private JFrame frmMenuInicial;

	private FormularioBeanRemote formularioBean;
	private CasillaBeanRemote cas;
	private Formulario form;
	private JTextField txtNom;
	private JTextField txtDesc;
	private MetodoMuestreoBeanRemote metBean;
	private EstacionMuestreoBeanRemote estBean;
	private DepartamentoBeanRemote depBean;
	private ActividadCampoBeanRemote acBean;
	private RespuestaCasillaBeanRemote rcBean;
	private JTextField txtLat;
	private JTextField txtLon;
	private JTextField txtCant;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public AltaActividad(Formulario fo) {
		form = fo;
		try {
			formularioBean = (FormularioBeanRemote) InitialContext
					.doLookup("IAGRO/FormularioBean!com.servicios.FormularioBeanRemote");
			cas = (CasillaBeanRemote) InitialContext.doLookup("IAGRO/CasillaBean!com.servicios.CasillaBeanRemote");
			metBean = (MetodoMuestreoBeanRemote) InitialContext
					.doLookup("IAGRO/MetodoMuestreoBean!com.servicios.MetodoMuestreoBeanRemote");
			depBean = (DepartamentoBeanRemote) InitialContext
					.doLookup("IAGRO/DepartamentoBean!com.servicios.DepartamentoBeanRemote");
			estBean = (EstacionMuestreoBeanRemote) InitialContext
					.doLookup("IAGRO/EstacionMuestreoBean!com.servicios.EstacionMuestreoBeanRemote");
			acBean = (ActividadCampoBeanRemote) InitialContext
					.doLookup("IAGRO/ActividadCampoBean!com.servicios.ActividadCampoBeanRemote");
			rcBean = (RespuestaCasillaBeanRemote) InitialContext
					.doLookup("IAGRO/RespuestaCasillaBean!com.servicios.RespuestaCasillaBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Alta Actividad de campo");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(254, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnRegistrar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(411, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnSalir);

		JLabel lblMsj = new JLabel("");
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsj.setBounds(10, 461, 774, 14);
		frmMenuInicial.getContentPane().add(lblMsj);

		JLabel lblNewLabel = new JLabel("Nombre Actividad de campo*:");
		lblNewLabel.setBounds(177, 113, 163, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblDescripcionActividadDe = new JLabel("Descripcion Actividad de campo*:");
		lblDescripcionActividadDe.setBounds(177, 138, 191, 14);
		frmMenuInicial.getContentPane().add(lblDescripcionActividadDe);

		JLabel lblFecha = new JLabel("Fecha*:");
		lblFecha.setBounds(177, 163, 163, 14);
		frmMenuInicial.getContentPane().add(lblFecha);

		JLabel lblMetodoDeMuestreo = new JLabel("Metodo de muestreo*:");
		lblMetodoDeMuestreo.setBounds(177, 188, 163, 14);
		frmMenuInicial.getContentPane().add(lblMetodoDeMuestreo);

		JLabel lblEstacionDeMuestreo = new JLabel("Estacion de muestreo*:");
		lblEstacionDeMuestreo.setBounds(177, 217, 163, 14);
		frmMenuInicial.getContentPane().add(lblEstacionDeMuestreo);

		JLabel lblDepartamento = new JLabel("Departamento*:");
		lblDepartamento.setBounds(177, 242, 163, 14);
		frmMenuInicial.getContentPane().add(lblDepartamento);

		txtNom = new JTextField();
		txtNom.setBounds(369, 110, 163, 20);
		frmMenuInicial.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(369, 135, 163, 20);
		frmMenuInicial.getContentPane().add(txtDesc);

		JComboBox cbMet = new JComboBox();

		for (MetodoMuestreo mm : metBean.obtenerTodos()) {
			cbMet.addItem(mm);
		}

		cbMet.setBounds(369, 183, 163, 24);
		frmMenuInicial.getContentPane().add(cbMet);

		JComboBox cbEst = new JComboBox();

		for (EstacionMuestreo em : estBean.obtenerTodos()) {
			cbEst.addItem(em);
		}

		cbEst.setBounds(369, 212, 163, 24);
		frmMenuInicial.getContentPane().add(cbEst);

		JComboBox cbDep = new JComboBox();

		for (Departamento dep : depBean.obtenerTodos()) {
			cbDep.addItem(dep);
		}

		cbDep.setBounds(369, 242, 163, 24);
		frmMenuInicial.getContentPane().add(cbDep);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(369, 157, 163, 20);
		frmMenuInicial.getContentPane().add(dateChooser);

		JLabel lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(177, 315, 163, 14);
		frmMenuInicial.getContentPane().add(lblUbicacion);

		txtLat = new JTextField();
		txtLat.setToolTipText("Latitud");
		txtLat.setColumns(10);
		txtLat.setBounds(369, 312, 69, 20);
		frmMenuInicial.getContentPane().add(txtLat);

		txtLon = new JTextField();
		txtLon.setToolTipText("Longitud");
		txtLon.setColumns(10);
		txtLon.setBounds(463, 312, 69, 20);
		frmMenuInicial.getContentPane().add(txtLon);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(177, 280, 163, 14);
		frmMenuInicial.getContentPane().add(lblCantidad);

		txtCant = new JTextField();
		txtCant.setToolTipText("Cantidad");
		txtCant.setColumns(10);
		txtCant.setBounds(369, 277, 163, 20);
		frmMenuInicial.getContentPane().add(txtCant);

		JLabel lblCamposObligatorios = new JLabel("Campos obligatorios (*).");
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamposObligatorios.setBounds(254, 412, 237, 14);
		frmMenuInicial.getContentPane().add(lblCamposObligatorios);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNom.getText().equals("")) {
					lblMsj.setText("Ingresar un Nombre.");
				} else if (txtDesc.getText().equals("")) {
					lblMsj.setText("Ingresar una Descripcion.");
				} else if (dateChooser.getDate() == null) {
					lblMsj.setText("Seleccione una fecha.");
				} else {
					boolean cant = true;
					boolean lat = true;
					boolean lon = true;
					if (!txtCant.getText().equals("")) {
						if (!isNumeric(txtCant.getText())) {
							lblMsj.setText("La cantidad debe ser numerica.");
							cant = false;
						}
					}
					if (!txtLat.getText().equals("")) {
						if (!isNumeric(txtLat.getText())) {
							lblMsj.setText("La latitud debe ser numerica.");
							lat = false;
						} else {
							if (!txtLon.getText().equals("")) {
								if (!isNumeric(txtLon.getText())) {
									lblMsj.setText("La longitud debe ser numerica.");
									lon = false;
								}
							} else {
								lblMsj.setText("Ingrese una latitud y longitud, o deje vacio ambos.");
								lon = false;
								lat = false;
							}
						}
					} else {
						if (!txtLon.getText().equals("")) {
							lblMsj.setText("Ingrese una latitud y longitud, o deje vacio ambos.");
							lon = false;
							lat = false;
						}
					}

					if (cant && lon && lat) {
						ActividadCampo ac = new ActividadCampo(txtNom.getText(), txtDesc.getText(),
								new Date(dateChooser.getDate().getYear(), dateChooser.getDate().getMonth(),
										dateChooser.getDate().getDate()),
								-1, MainWindow.getUsuario(), form, ((MetodoMuestreo) cbMet.getSelectedItem()),
								((EstacionMuestreo) cbEst.getSelectedItem()), null,
								((Departamento) cbDep.getSelectedItem()));
						if (!txtLat.getText().equals("")) {
							Geopunto gp = new Geopunto(Long.parseLong(txtLat.getText()),
									Long.parseLong(txtLon.getText()));
							ac.setGeopunto(gp);
						}
						if (!txtCant.getText().equals("")) {
							ac.setCantidad(Integer.parseInt(txtCant.getText()));
						}

						try {
							acBean.crear(ac);
							lblMsj.setText("Se dio de alta.");
							limpiar();
						} catch (ServiciosException e) {
							lblMsj.setText(e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frmMenuInicial.dispose();
			}

		});
	}
	
	private void limpiar() {
		txtCant.setText("");
		txtDesc.setText("");
		txtLat.setText("");
		txtLon.setText("");
		txtNom.setText("");
	}

	private boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
