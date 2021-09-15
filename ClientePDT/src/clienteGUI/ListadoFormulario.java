package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.FormularioBeanRemote;

public class ListadoFormulario {

	private JFrame frmMenuInicial;

	private FormularioBeanRemote formularioBean;
	private JTable table;
	private boolean comun;
	private JTextField txtBuscar;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public ListadoFormulario(boolean com) {
		try {
			comun = com;
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
		frmMenuInicial.setTitle("Listado Formulario");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 774, 420);
		frmMenuInicial.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Resumen" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnAsignar = new JButton("Asignar Casilla");
		btnAsignar.setBounds(38, 513, 130, 47);
		frmMenuInicial.getContentPane().add(btnAsignar);

		JLabel lblMsj = new JLabel("");
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsj.setBounds(10, 471, 774, 14);
		frmMenuInicial.getContentPane().add(lblMsj);

		JButton btnVer = new JButton("Ver Casillas");
		btnVer.setBounds(192, 513, 130, 47);
		frmMenuInicial.getContentPane().add(btnVer);

		JButton btnAltaActividad = new JButton("Carga Actividad");
		btnAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccione un Formulario.");
				} else {
					Formulario f = formularioBean.buscar(model.getValueAt(sr, 0).toString());
					if(f.getCasilla().size() == 0) {
						AltaActividad aa = new AltaActividad(f);
						aa.getFrame().setVisible(true);
					}else {
						lblMsj.setText("El formulario solo puede contener las casillas basicas.");
					}
					
				}
			}
		});
		btnAltaActividad.setBounds(500, 513, 130, 47);
		frmMenuInicial.getContentPane().add(btnAltaActividad);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(343, 513, 130, 47);
		frmMenuInicial.getContentPane().add(btnEliminar);

		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(10, 11, 58, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(78, 8, 477, 20);
		frmMenuInicial.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBuscar.getText().isEmpty()) {
					lblMsj.setText("Para Buscar ingrese un nombre.");
				} else {
					mostrar(txtBuscar.getText());
				}
			}
		});
		btnBuscar.setBounds(575, 9, 89, 23);
		frmMenuInicial.getContentPane().add(btnBuscar);

		JButton btnBuscar_1 = new JButton("Todos");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		btnBuscar_1.setBounds(681, 9, 89, 23);
		frmMenuInicial.getContentPane().add(btnBuscar_1);

		JButton btnListado = new JButton("Ver Actividades");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccione un Formulario.");
				} else {
					Formulario f = formularioBean.buscar(model.getValueAt(sr, 0).toString());
					ListadoACFormulario lacf = new ListadoACFormulario(f);
					lacf.getFrame().setVisible(true);
				}
			}
		});
		btnListado.setBounds(640, 513, 130, 47);
		frmMenuInicial.getContentPane().add(btnListado);
		mostrar();

		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccione un Formulario.");
				} else {
					Formulario f = formularioBean.buscar(model.getValueAt(sr, 0).toString());
					ListadoCasillas lc = new ListadoCasillas(f);
					lc.getFrame().setVisible(true);
				}
			}
		});

		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccione un Formulario.");
				} else {
					Formulario f = formularioBean.buscar(model.getValueAt(sr, 0).toString());
					VerCasillas vc = new VerCasillas(f);
					vc.getFrame().setVisible(true);
				}

			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccionar un Usuario.");
				} else {
					int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
					if (resp == 0) {
						Formulario f = formularioBean.buscar(model.getValueAt(sr, 0).toString());
						try {
							formularioBean.borrar(f.getIdFormulario());
							lblMsj.setText("Formulario eliminado con exito.");
							mostrar();
						} catch (ServiciosException e) {
							lblMsj.setText(e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
		});

		if (comun) {// DESHABILITO EL BOTON ASGINAR Y VER SI ES UN USUARIO COMUN.
			btnAsignar.setEnabled(false);
			btnVer.setEnabled(false);
			btnEliminar.setEnabled(false);
		}

	}

	public void mostrar() {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Formulario p : formularioBean.obtenerTodos()) {
			fila[0] = p.getNombre();
			fila[1] = p.getResumen();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}

	public void mostrar(String nom) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Formulario p : formularioBean.obtenerTodos()) {
			if (p.getNombre().contains(nom)) {
				fila[0] = p.getNombre();
				fila[1] = p.getResumen();
				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		}
	}
}
