package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.Casilla;
import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.CasillaBeanRemote;
import com.servicios.FormularioBeanRemote;

public class ListadoCasillas {

	private JFrame frmMenuInicial;

	private FormularioBeanRemote formularioBean;
	private JTable table;
	private CasillaBeanRemote cas;
	private Formulario form;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public ListadoCasillas(Formulario fo) {
		form = fo;
		try {
			formularioBean = (FormularioBeanRemote) InitialContext
					.doLookup("IAGRO/FormularioBean!com.servicios.FormularioBeanRemote");
			cas = (CasillaBeanRemote) InitialContext.doLookup("IAGRO/CasillaBean!com.servicios.CasillaBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Listado Casillas");
		frmMenuInicial.setBounds(100, 100, 600, 400);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 261);
		frmMenuInicial.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Parametro", "Descripcion", "TipoValor", "UnidadMedida", "Obligatorio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnAsignar = new JButton("Asignar Casilla");
		btnAsignar.setBounds(332, 513, 111, 47);
		frmMenuInicial.getContentPane().add(btnAsignar);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(159, 313, 111, 47);
		frmMenuInicial.getContentPane().add(btnAgregar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(316, 313, 111, 47);
		frmMenuInicial.getContentPane().add(btnSalir);

		JLabel lblMsj = new JLabel("");
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsj.setBounds(10, 288, 574, 14);
		frmMenuInicial.getContentPane().add(lblMsj);
		mostrar();

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int sr = table.getSelectedRow();
				if (sr == -1) {
					lblMsj.setText("Seleccione una casilla.");
				} else {
					try {
						formularioBean.asignarCasilla(form.getIdFormulario(),
								Long.parseLong(model.getValueAt(sr, 0).toString()));
						lblMsj.setText("Casilla asignada con exito.");
					} catch (NumberFormatException e) {
						lblMsj.setText(e.getMessage());
						e.printStackTrace();
					} catch (ServiciosException e) {
						lblMsj.setText(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenuInicial.dispose();
			}
		});

		table.removeColumn(table.getColumnModel().getColumn(0));// HAGO INVISIBLE COLUMNA ID
	}

	public void mostrar() {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (Casilla p : cas.obtenerTodos()) {
			fila[0] = p.getIdCasilla();
			fila[1] = p.getParametro();
			fila[2] = p.getDescripcion();
			fila[3] = p.getTipoValor().name();
			fila[4] = p.getUnidadMedida().getNombre();
			fila[5] = p.isObligatorio();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
	}
}
