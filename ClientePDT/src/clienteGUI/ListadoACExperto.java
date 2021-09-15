package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.entities.ActividadCampo;
import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Departamento;
import com.entities.EstacionMuestreo;
import com.entities.Experto;
import com.entities.MetodoMuestreo;
import com.entities.Usuario;
import com.servicios.ActividadCampoBeanRemote;
import com.servicios.DepartamentoBeanRemote;
import com.servicios.EstacionMuestreoBeanRemote;
import com.servicios.FormularioBeanRemote;
import com.servicios.MetodoMuestreoBeanRemote;
import com.servicios.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

public class ListadoACExperto {

	private JFrame frmMenuInicial;

	private FormularioBeanRemote formularioBean;
	private ActividadCampoBeanRemote acBean;
	private JTable table;
	private MetodoMuestreoBeanRemote metBean;
	private EstacionMuestreoBeanRemote estBean;
	private DepartamentoBeanRemote depBean;
	private UsuarioBeanRemote usuBean;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public ListadoACExperto() {
		try {
			metBean = (MetodoMuestreoBeanRemote) InitialContext
					.doLookup("IAGRO/MetodoMuestreoBean!com.servicios.MetodoMuestreoBeanRemote");
			depBean = (DepartamentoBeanRemote) InitialContext
					.doLookup("IAGRO/DepartamentoBean!com.servicios.DepartamentoBeanRemote");
			estBean = (EstacionMuestreoBeanRemote) InitialContext
					.doLookup("IAGRO/EstacionMuestreoBean!com.servicios.EstacionMuestreoBeanRemote");
			acBean = (ActividadCampoBeanRemote) InitialContext
					.doLookup("IAGRO/ActividadCampoBean!com.servicios.ActividadCampoBeanRemote");
			usuBean = (UsuarioBeanRemote) InitialContext.doLookup("IAGRO/UsuarioBean!com.servicios.UsuarioBeanRemote");
			formularioBean = (FormularioBeanRemote) InitialContext
					.doLookup("IAGRO/FormularioBean!com.servicios.FormularioBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Actividad de campo por Experto");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 774, 415);
		frmMenuInicial.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Usuario", "Nombre", "Descripcion",
				"Fecha", "Metodo muestreo", "Estacion muestreo", "Departamento", "Cantidad", "Ubicacion" }) {
			boolean[] columnEditables = new boolean[] { true, true, true, true, true, true, true, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblMsj = new JLabel("");
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsj.setBounds(10, 546, 774, 14);
		frmMenuInicial.getContentPane().add(lblMsj);

		JLabel lblNewLabel = new JLabel("Fecha inicio:");
		lblNewLabel.setBounds(10, 11, 89, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(10, 36, 89, 14);
		frmMenuInicial.getContentPane().add(lblFechaFin);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 61, 89, 14);
		frmMenuInicial.getContentPane().add(lblUsuario);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 86, 89, 14);
		frmMenuInicial.getContentPane().add(lblRol);

		JLabel lblMetodoDeMuestreo = new JLabel("Metodo de muestreo:");
		lblMetodoDeMuestreo.setBounds(306, 11, 136, 14);
		frmMenuInicial.getContentPane().add(lblMetodoDeMuestreo);

		JLabel lblEstacionDeMuestreo = new JLabel("Estacion de muestreo:");
		lblEstacionDeMuestreo.setBounds(306, 36, 136, 14);
		frmMenuInicial.getContentPane().add(lblEstacionDeMuestreo);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(306, 61, 136, 14);
		frmMenuInicial.getContentPane().add(lblDepartamento);

		JComboBox cbMet = new JComboBox();
		cbMet.addItem("Todos");
		for (MetodoMuestreo mm : metBean.obtenerTodos()) {
			cbMet.addItem(mm);
		}
		cbMet.setBounds(463, 7, 163, 24);
		frmMenuInicial.getContentPane().add(cbMet);

		JComboBox cbEst = new JComboBox();
		cbEst.addItem("Todos");
		for (EstacionMuestreo em : estBean.obtenerTodos()) {
			cbEst.addItem(em);
		}
		cbEst.setBounds(463, 32, 163, 24);
		frmMenuInicial.getContentPane().add(cbEst);

		JComboBox cbDep = new JComboBox();
		for (Departamento dep : depBean.obtenerTodos()) {
			cbDep.addItem(dep);
		}
		cbDep.setBounds(463, 57, 163, 24);
		frmMenuInicial.getContentPane().add(cbDep);

		JComboBox cbUsu = new JComboBox();
		cbUsu.addItem("Todos");
		for (Usuario us : usuBean.obtenerTodos()) {
			cbUsu.addItem(us);
		}
		cbUsu.setBounds(88, 57, 163, 24);
		frmMenuInicial.getContentPane().add(cbUsu);

		JComboBox cbRol = new JComboBox();
		cbRol.setModel(new DefaultComboBoxModel(new String[] { "Experto" }));
		cbRol.setBounds(88, 86, 163, 24);
		frmMenuInicial.getContentPane().add(cbRol);

		JDateChooser dateChooserIni = new JDateChooser();
		dateChooserIni.setBounds(88, 11, 163, 20);
		frmMenuInicial.getContentPane().add(dateChooserIni);

		JDateChooser dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(88, 36, 163, 20);
		frmMenuInicial.getContentPane().add(dateChooserFin);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<ActividadCampo> todos = acBean.obtenerTodos();
				boolean fecha = true;
				todos = filtroRol(todos, cbRol.getSelectedItem().toString());
				if (dateChooserIni.getDate() != null && dateChooserFin.getDate() != null) {
					if (dateChooserFin.getDate().after(dateChooserIni.getDate())) {
						todos = filtroFecha(todos, dateChooserIni.getDate(), dateChooserFin.getDate());
					} else {
						lblMsj.setText("La fecha de inicio debe ser menor a la fecha fin.");
						fecha = false;
					}
				}
				if (cbEst.getSelectedIndex() != 0) {
					todos = filtroEstacion(todos, (EstacionMuestreo) cbEst.getSelectedItem());
				}

				if (cbDep.getSelectedIndex() != 0) {
					todos = filtroDepartamento(todos, (Departamento) cbDep.getSelectedItem());
				}
				if (cbMet.getSelectedIndex() != 0) {
					todos = filtroMetodo(todos, (MetodoMuestreo) cbMet.getSelectedItem());
				}
				if (cbUsu.getSelectedIndex() != 0) {
					todos = filtroUsuario(todos, (Usuario) cbUsu.getSelectedItem());
				}
				if (fecha) {
					mostrar(todos);
				}

			}
		});
		btnFiltrar.setBounds(306, 86, 150, 23);
		frmMenuInicial.getContentPane().add(btnFiltrar);
		
		JButton btnExportar = new JButton("Exportar Excel");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getRowCount() > 0) {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
					chooser.setFileFilter(filter);
					chooser.setDialogTitle("Guardar archivo");
					chooser.setAcceptAllFileFilterUsed(false);
					if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						List<JTable> tb = new ArrayList<JTable>();
						List<String> nom = new ArrayList<String>();
						tb.add(table);
						nom.add("Listado por Experto");
						String file = chooser.getSelectedFile().toString().concat(".xls");
						try {
							Exporter e = new Exporter(new File(file), tb, nom);
							if (e.export()) {
								JOptionPane.showMessageDialog(null,
										"Los datos fueron exportados a excel en el directorio seleccionado",
										"Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay datos para exportar", "Mensaje de error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnExportar.setBounds(463, 86, 150, 23);
		frmMenuInicial.getContentPane().add(btnExportar);

		mostrar(filtroRol(acBean.obtenerTodos(), cbRol.getSelectedItem().toString()));
		
	}

	public List<ActividadCampo> filtroEstacion(List<ActividadCampo> lista, EstacionMuestreo em) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();
		for (ActividadCampo ac : lista) {
			if (ac.getEstacionMuestreo().getIdEstacionMuestreo() == em.getIdEstacionMuestreo()) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public List<ActividadCampo> filtroFecha(List<ActividadCampo> lista, Date ini, Date fin) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();

		for (ActividadCampo ac : lista) {
			if (ac.getFecha().compareTo(ini) >= 0 && ac.getFecha().compareTo(fin) <= 0) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public List<ActividadCampo> filtroUsuario(List<ActividadCampo> lista, Usuario u) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();

		for (ActividadCampo ac : lista) {
			if (ac.getUsuario().getIdUsuario() == u.getIdUsuario()) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public List<ActividadCampo> filtroMetodo(List<ActividadCampo> lista, MetodoMuestreo mm) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();

		for (ActividadCampo ac : lista) {
			if (ac.getMetMuestreo().getIdMetodoMuestreo() == mm.getIdMetodoMuestreo()) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public List<ActividadCampo> filtroDepartamento(List<ActividadCampo> lista, Departamento d) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();

		for (ActividadCampo ac : lista) {
			if (ac.getDepartamento().getIdDepartamento() == d.getIdDepartamento()) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public List<ActividadCampo> filtroRol(List<ActividadCampo> lista, String rol) {
		List<ActividadCampo> ret = new ArrayList<ActividadCampo>();
		for (ActividadCampo ac : lista) {
			if (rol.equals("Comun") && ac.getUsuario() instanceof Comun) {
				ret.add(ac);
			} else if (rol.equals("Experto") && ac.getUsuario() instanceof Experto) {
				ret.add(ac);
			} else if (rol.equals("Administrador") && ac.getUsuario() instanceof Administrador) {
				ret.add(ac);
			}
		}
		return ret;
	}

	public void mostrar(List<ActividadCampo> lista) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (ActividadCampo ac : lista) {
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
			String stringDate = DateFor.format(ac.getFecha());

			fila[0] = ac.getUsuario().getNombre();
			fila[1] = ac.getNombre();
			fila[2] = ac.getDescripcion();
			fila[3] = stringDate;
			fila[4] = ac.getMetMuestreo().getNombre();
			fila[5] = ac.getEstacionMuestreo().getNombre();
			fila[6] = ac.getDepartamento().getNombre();
			fila[7] = ac.getCantidad();
			if (ac.getCantidad() != -1) {
				fila[7] = ac.getCantidad();
			} else {
				fila[7] = "";
			}
			if (ac.getGeopunto() != null) {
				fila[8] = ac.getGeopunto().getLatitud() + " ," + ac.getGeopunto().getLongitud();
			} else {
				fila[8] = "";
			}
			((DefaultTableModel) table.getModel()).addRow(fila);

		}
	}
}
