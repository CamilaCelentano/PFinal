package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Experto;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.AdministradorBeanRemote;
import com.servicios.ComunBeanRemote;
import com.servicios.ExpertoBeanRemote;
import com.servicios.UsuarioBeanRemote;

public class ListadoUsuario {

	private JFrame frmMenuInicial;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtMail;
	private JTextField txtCI;
	private JTextField txtProf;
	private JTextField txtInst;

	private ExpertoBeanRemote expertoBean;
	private ComunBeanRemote comunBean;
	private AdministradorBeanRemote adminBean;
	private JTable table;
	private UsuarioBeanRemote usuarioBean;
	private JTextField txtBuscar;

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public ListadoUsuario() {
		try {
			expertoBean = (ExpertoBeanRemote) InitialContext
					.doLookup("IAGRO/ExpertoBean!com.servicios.ExpertoBeanRemote");
			comunBean = (ComunBeanRemote) InitialContext.doLookup("IAGRO/ComunBean!com.servicios.ComunBeanRemote");
			adminBean = (AdministradorBeanRemote) InitialContext
					.doLookup("IAGRO/AdministradorBean!com.servicios.AdministradorBeanRemote");
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("IAGRO/UsuarioBean!com.servicios.UsuarioBeanRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Listado Usuarios");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(145, 368, 66, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(410, 368, 66, 14);
		frmMenuInicial.getContentPane().add(lblApellido);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(145, 405, 46, 14);
		frmMenuInicial.getContentPane().add(lblMail);

		txtNom = new JTextField();
		txtNom.setBounds(232, 367, 130, 20);
		frmMenuInicial.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtApe = new JTextField();
		txtApe.setBounds(500, 365, 130, 20);
		txtApe.setColumns(10);
		frmMenuInicial.getContentPane().add(txtApe);

		txtMail = new JTextField();
		txtMail.setBounds(232, 402, 130, 20);
		txtMail.setColumns(10);
		frmMenuInicial.getContentPane().add(txtMail);

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(410, 408, 60, 14);
		frmMenuInicial.getContentPane().add(lblCedula);

		txtCI = new JTextField();
		txtCI.setBounds(500, 405, 130, 20);
		txtCI.setColumns(10);
		frmMenuInicial.getContentPane().add(txtCI);

		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setBounds(145, 445, 77, 14);
		lblProfesion.setVisible(false);
		frmMenuInicial.getContentPane().add(lblProfesion);

		txtProf = new JTextField();
		txtProf.setBounds(232, 442, 130, 20);
		txtProf.setVisible(false);
		txtProf.setColumns(10);
		frmMenuInicial.getContentPane().add(txtProf);

		txtInst = new JTextField();
		txtInst.setBounds(500, 442, 130, 20);
		txtInst.setColumns(10);
		frmMenuInicial.getContentPane().add(txtInst);

		JLabel lblInstituto = new JLabel("Instituto:");
		lblInstituto.setBounds(410, 445, 66, 14);
		frmMenuInicial.getContentPane().add(lblInstituto);

		JButton btnEditar = new JButton("Modificar");
		btnEditar.setBounds(220, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnEditar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenuInicial.dispose();
			}
		});
		btnSalir.setBounds(488, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnSalir);

		JLabel lblMsj = new JLabel("");
		lblMsj.setBounds(10, 488, 774, 14);
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		frmMenuInicial.getContentPane().add(lblMsj);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 774, 310);
		frmMenuInicial.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				Usuario usu = usuarioBean.buscarPorNombreUsuario(model.getValueAt(sr, 4).toString());

				txtNom.setText(usu.getNombre());
				txtApe.setText(usu.getApellido());
				txtMail.setText(usu.getEmail());

				if (usu instanceof Administrador) {
					txtCI.setVisible(true);
					lblCedula.setVisible(true);
					txtInst.setVisible(true);
					lblInstituto.setVisible(true);
					txtProf.setVisible(false);
					lblProfesion.setVisible(false);
					txtCI.setText(((Administrador) usu).getCedula());
					txtInst.setText(((Administrador) usu).getInstituto());
				} else if (usu instanceof Experto) {
					txtCI.setVisible(true);
					lblCedula.setVisible(true);
					txtInst.setVisible(false);
					lblInstituto.setVisible(false);
					txtProf.setVisible(true);
					lblProfesion.setVisible(true);
					txtCI.setText(((Experto) usu).getCedula());
					txtProf.setText(((Experto) usu).getProfesion());
				} else {
					txtCI.setVisible(false);
					lblCedula.setVisible(false);
					txtInst.setVisible(false);
					lblInstituto.setVisible(false);
					txtProf.setVisible(false);
					lblProfesion.setVisible(false);
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Rol", "Nombre", "Apellido", "Mail", "Usuario" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(352, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnEliminar);

		JLabel lblNewLabel_1 = new JLabel("Buscar:");
		lblNewLabel_1.setBounds(10, 11, 66, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel_1);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(185, 8, 401, 20);
		frmMenuInicial.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(596, 7, 89, 23);
		frmMenuInicial.getContentPane().add(btnBuscar);

		JButton btnTodos = new JButton("Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		btnTodos.setBounds(695, 7, 89, 23);
		frmMenuInicial.getContentPane().add(btnTodos);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Usuario", "Rol" }));
		comboBox.setBounds(66, 7, 98, 22);
		frmMenuInicial.getContentPane().add(comboBox);

		JComboBox cbRoles = new JComboBox();
		cbRoles.setVisible(false);
		cbRoles.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		cbRoles.setBounds(185, 6, 401, 22);
		frmMenuInicial.getContentPane().add(cbRoles);

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccionar un Usuario.");
				} else {
					int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
					if (resp == 0) {
						Usuario usu = usuarioBean.buscarPorNombreUsuario(model.getValueAt(sr, 4).toString());
						if (usu instanceof Comun) {
							if (txtNom.getText().equals("") || txtApe.equals("") || txtMail.equals("")) {
								lblMsj.setText("Completar todos los campos.");
							} else {
								Comun u = comunBean.buscarPorNombreUsuario(usu.getNombUsuario());
								u.setNombre(txtNom.getText());
								u.setApellido(txtApe.getText());
								u.setEmail(txtMail.getText());

								try {
									comunBean.actualizar(u);
									lblMsj.setText("Modificado con exito.");
									mostrar();
									borrarCampos();
								} catch (Exception e) {
									lblMsj.setText(e.getMessage());
									e.printStackTrace();
								}
							}

						} else if (usu instanceof Experto) {
							if (txtNom.getText().equals("") || txtApe.equals("") || txtMail.equals("")
									|| txtCI.getText().equals("") || txtProf.getText().equals("")) {
								lblMsj.setText("Completar todos los campos.");
							} else {
								usu.setNombre(txtNom.getText());
								usu.setApellido(txtApe.getText());
								usu.setEmail(txtMail.getText());
								((Experto) usu).setCedula(txtCI.getText());
								((Experto) usu).setProfesion(txtProf.getText());
							}
							try {
								expertoBean.actualizar((Experto) usu);
								lblMsj.setText("Modificado con exito.");
								mostrar();
								borrarCampos();
							} catch (ServiciosException e) {
								lblMsj.setText(e.getMessage());
								e.printStackTrace();

							}
						} else if (usu instanceof Administrador) {
							if (txtNom.getText().equals("") || txtApe.equals("") || txtMail.equals("")
									|| txtCI.getText().equals("") || txtInst.getText().equals("")) {
								lblMsj.setText("Completar todos los campos.");
							} else {
								usu.setNombre(txtNom.getText());
								usu.setApellido(txtApe.getText());
								usu.setEmail(txtMail.getText());
								((Administrador) usu).setCedula(txtCI.getText());
								((Administrador) usu).setInstituto(txtInst.getText());

								try {
									adminBean.actualizar((Administrador) usu);
									lblMsj.setText("Modificado con exito.");
									mostrar();
									borrarCampos();
								} catch (ServiciosException e) {
									e.printStackTrace();
									lblMsj.setText(e.getMessage());

								}
							}
						}
					}
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
						Usuario u = usuarioBean.buscarPorNombreUsuario(model.getValueAt(sr, 4).toString());
						if (u instanceof Administrador) {
							try {
								adminBean.borrar(u.getIdUsuario());
								lblMsj.setText("Eliminado con exito.");
								mostrar();
							} catch (ServiciosException e) {
								lblMsj.setText(e.getMessage());
								e.printStackTrace();
							}
						} else if (u instanceof Experto) {
							try {
								expertoBean.borrar(u.getIdUsuario());
								lblMsj.setText("Eliminado con exito.");
								mostrar();
							} catch (ServiciosException e) {
								lblMsj.setText(e.getMessage());
								e.printStackTrace();
							}
						} else {
							try {
								comunBean.borrar(u.getIdUsuario());
								lblMsj.setText("Eliminado con exito.");
								mostrar();
							} catch (ServiciosException e) {
								lblMsj.setText(e.getMessage());
								e.printStackTrace();
							}
						}
					}
				}
			}
		});

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedIndex() == 3) {
					txtBuscar.setVisible(false);
					cbRoles.setVisible(true);
				} else {
					txtBuscar.setVisible(true);
					cbRoles.setVisible(false);
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedIndex() != 3) {
					if (txtBuscar.getText().equals("")) {
						lblMsj.setText("Debe ingresar un texto para buscar.");
					} else {
						if (comboBox.getSelectedIndex() == 0) {
							mostrarNombre(txtBuscar.getText());
						} else if (comboBox.getSelectedIndex() == 1) {
							mostrarApellido(txtBuscar.getText());
						} else if (comboBox.getSelectedIndex() == 2) {
							mostrarNomUsu(txtBuscar.getText());
						}
					}
				} else {
					mostrarRol(cbRoles.getSelectedItem().toString());
				}

			}
		});

		mostrar();
	}

	public void borrarCampos() {
		txtApe.setText("");
		txtCI.setText("");
		txtInst.setText("");
		txtMail.setText("");
		txtNom.setText("");
		txtProf.setText("");
	}

	public void mostrar() {
		txtBuscar.setText("");
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Usuario p : usuarioBean.obtenerTodos()) {
			if (p instanceof Administrador) {
				fila[0] = "Administrador";
			} else if (p instanceof Experto) {
				fila[0] = "Experto";
			} else {
				fila[0] = "Comun";
			}
			fila[1] = p.getNombre();
			fila[2] = p.getApellido();
			fila[3] = p.getEmail();
			fila[4] = p.getNombUsuario();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}

//	public void mostrarRol(String rol) {
//		((DefaultTableModel) table.getModel()).setRowCount(0);
//		int numCols = table.getModel().getColumnCount();
//		Object[] fila = new Object[numCols];
//
//		if (rol.equals("Administrador")) {
//			for (Usuario p : usuarioBean.obtenerTodos()) {
//				if (p instanceof Administrador) {
//					fila[0] = "Administrador";
//					fila[1] = p.getNombre();
//					fila[2] = p.getApellido();
//					fila[3] = p.getEmail();
//					fila[4] = p.getNombUsuario();
//				}
//			}
//		} else if (rol.equals("Comun")) {
//			for (Usuario p : usuarioBean.obtenerTodos()) {
//				if (p instanceof Comun) {
//					fila[0] = "Comun";
//					fila[1] = p.getNombre();
//					fila[2] = p.getApellido();
//					fila[3] = p.getEmail();
//					fila[4] = p.getNombUsuario();
//				}
//			}
//		} else if (rol.equals("Experto")) {
//			for (Usuario p : usuarioBean.obtenerTodos()) {
//				if (p instanceof Experto) {
//					fila[0] = "Experto";
//					fila[1] = p.getNombre();
//					fila[2] = p.getApellido();
//					fila[3] = p.getEmail();
//					fila[4] = p.getNombUsuario();
//				}
//			}
//		}
//		((DefaultTableModel) table.getModel()).addRow(fila);
//
//	}

	public void mostrarRol(String rol) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];
		for (Usuario p : usuarioBean.obtenerTodos()) {
			if (rol.equals("Administrador")) {

				if (p instanceof Administrador) {
					fila[0] = "Administrador";
					fila[1] = p.getNombre();
					fila[2] = p.getApellido();
					fila[3] = p.getEmail();
					fila[4] = p.getNombUsuario();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			} else if (rol.equals("Comun")) {

				if (p instanceof Comun) {
					fila[0] = "Comun";
					fila[1] = p.getNombre();
					fila[2] = p.getApellido();
					fila[3] = p.getEmail();
					fila[4] = p.getNombUsuario();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			} else if (rol.equals("Experto")) {

				if (p instanceof Experto) {
					fila[0] = "Experto";
					fila[1] = p.getNombre();
					fila[2] = p.getApellido();
					fila[3] = p.getEmail();
					fila[4] = p.getNombUsuario();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}
			
		}

	}

	public void mostrarNombre(String nom) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Usuario p : usuarioBean.obtenerTodos()) {
			if (p.getNombre().contains(nom)) {
				if (p instanceof Administrador) {
					fila[0] = "Administrador";
				} else if (p instanceof Experto) {
					fila[0] = "Experto";
				} else {
					fila[0] = "Comun";
				}
				fila[1] = p.getNombre();
				fila[2] = p.getApellido();
				fila[3] = p.getEmail();
				fila[4] = p.getNombUsuario();

				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		}
	}

	public void mostrarApellido(String ape) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Usuario p : usuarioBean.obtenerTodos()) {
			if (p.getApellido().contains(ape)) {
				if (p instanceof Administrador) {
					fila[0] = "Administrador";
				} else if (p instanceof Experto) {
					fila[0] = "Experto";
				} else {
					fila[0] = "Comun";
				}
				fila[1] = p.getNombre();
				fila[2] = p.getApellido();
				fila[3] = p.getEmail();
				fila[4] = p.getNombUsuario();

				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		}
	}

	public void mostrarNomUsu(String nom) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Usuario p : usuarioBean.obtenerTodos()) {
			if (p.getNombUsuario().contains(nom)) {
				if (p instanceof Administrador) {
					fila[0] = "Administrador";
				} else if (p instanceof Experto) {
					fila[0] = "Experto";
				} else {
					fila[0] = "Comun";
				}
				fila[1] = p.getNombre();
				fila[2] = p.getApellido();
				fila[3] = p.getEmail();
				fila[4] = p.getNombUsuario();

				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		}
	}
}
