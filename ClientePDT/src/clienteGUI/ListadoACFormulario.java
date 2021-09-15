package clienteGUI;

import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.ActividadCampo;
import com.entities.Comun;
import com.entities.Formulario;
import com.servicios.ActividadCampoBeanRemote;
import com.servicios.FormularioBeanRemote;

public class ListadoACFormulario {

	private JFrame frmMenuInicial;

	private FormularioBeanRemote formularioBean;
	private ActividadCampoBeanRemote acBean;
	private JTable table;
	private Formulario formulario;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public ListadoACFormulario(Formulario form) {
		try {
			formulario = form;
			formularioBean = (FormularioBeanRemote) InitialContext
					.doLookup("IAGRO/FormularioBean!com.servicios.FormularioBeanRemote");
			acBean = (ActividadCampoBeanRemote) InitialContext
					.doLookup("IAGRO/ActividadCampoBean!com.servicios.ActividadCampoBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Actividad de campo por Formulario");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 774, 452);
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
		lblMsj.setBounds(10, 471, 774, 14);
		frmMenuInicial.getContentPane().add(lblMsj);

		if (MainWindow.getUsuario() instanceof Comun) {
			mostrarComun();
		} else {
			mostrar();
		}

	}

	public void mostrar() {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (ActividadCampo ac : acBean.obtenerTodos()) {
			if (ac.getFormulario().getIdFormulario() == formulario.getIdFormulario()) {
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

	public void mostrarComun() {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];

		for (ActividadCampo ac : acBean.obtenerTodos()) {
			if (ac.getUsuario().getNombUsuario().equals(MainWindow.getUsuario().getNombUsuario())) {
				if (ac.getFormulario().getIdFormulario() == formulario.getIdFormulario()) {
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
	}

}
