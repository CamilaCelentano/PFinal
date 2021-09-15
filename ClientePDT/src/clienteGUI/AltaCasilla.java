package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.entities.Casilla;
import com.entities.TipoValor;
import com.entities.UnidadMedida;
import com.exception.ServiciosException;
import com.servicios.CasillaBeanRemote;
import com.servicios.UnidadMedidaBeanRemote;

public class AltaCasilla {

	private JFrame frmMenuInicial;
	private JTextField txtParam;
	private JTextField txtDesc;

	private UnidadMedidaBeanRemote uMed;

	private CasillaBeanRemote cas;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaCasilla window = new AltaCasilla();
//					window.getFrmMenuInicial().setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public AltaCasilla() {
		try {
			uMed = (UnidadMedidaBeanRemote) InitialContext
					.doLookup("IAGRO/UnidadMedidaBean!com.servicios.UnidadMedidaBeanRemote");
			cas = (CasillaBeanRemote) InitialContext.doLookup("IAGRO/CasillaBean!com.servicios.CasillaBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Alta Casilla");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Parametro:");
		lblNewLabel.setBounds(255, 138, 66, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblMail = new JLabel("Descripcion:");
		lblMail.setBounds(255, 181, 99, 14);
		frmMenuInicial.getContentPane().add(lblMail);

		txtParam = new JTextField();
		txtParam.setBounds(413, 136, 130, 20);
		frmMenuInicial.getContentPane().add(txtParam);
		txtParam.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(413, 177, 130, 20);
		frmMenuInicial.getContentPane().add(txtDesc);

		JButton btnRegistrar = new JButton("Registro");
		btnRegistrar.setBounds(275, 500, 111, 47);
		frmMenuInicial.getContentPane().add(btnRegistrar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenuInicial.dispose();
			}
		});
		btnSalir.setBounds(432, 500, 111, 47);
		frmMenuInicial.getContentPane().add(btnSalir);

		JLabel lblMsj = new JLabel("");
		lblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsj.setBounds(10, 471, 774, 14);
		frmMenuInicial.getContentPane().add(lblMsj);

		JLabel lblUnidadDeMedida = new JLabel("Unidad de Medida:");
		lblUnidadDeMedida.setBounds(255, 233, 130, 14);
		frmMenuInicial.getContentPane().add(lblUnidadDeMedida);

		JLabel lblTipoDeValor = new JLabel("Tipo de Valor:");
		lblTipoDeValor.setBounds(255, 281, 130, 14);
		frmMenuInicial.getContentPane().add(lblTipoDeValor);

		JComboBox comboMedida = new JComboBox();
		for (UnidadMedida um : uMed.obtenerTodos()) {
			comboMedida.addItem(um.getNombre());
		}
		
		comboMedida.setBounds(413, 229, 130, 20);
		frmMenuInicial.getContentPane().add(comboMedida);

		JComboBox comboValor = new JComboBox();
		comboValor.setModel(new DefaultComboBoxModel(TipoValor.values()));
		comboValor.setBounds(413, 277, 130, 22);
		frmMenuInicial.getContentPane().add(comboValor);
		
		JLabel lblObligatorio = new JLabel("Obligatorio:");
		lblObligatorio.setBounds(256, 333, 130, 14);
		frmMenuInicial.getContentPane().add(lblObligatorio);
		
		JComboBox cbObli = new JComboBox();
		cbObli.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		cbObli.setBounds(413, 329, 130, 20);
		frmMenuInicial.getContentPane().add(cbObli);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtParam.getText().equals("")) {
					lblMsj.setText("Ingrese un parametro");
				}else {
					UnidadMedida unid = uMed.buscarPorNombre(comboMedida.getSelectedItem().toString());
					boolean obligatorio = false;
					if(cbObli.getSelectedIndex() == 0) {
						obligatorio = true;
					}
					
					Casilla casi = new Casilla(txtParam.getText(), txtDesc.getText(), unid, obligatorio, (TipoValor)comboValor.getSelectedItem());
					try {
						cas.crear(casi);
						lblMsj.setText("Casilla creada con exito.");
						borrarCampos();
					} catch (ServiciosException e) {
						lblMsj.setText(e.getMessage());
						e.printStackTrace();
					}
				}

			}
		});
	}

	public void borrarCampos() {
		txtParam.setText("");
		txtDesc.setText("");
	}
}
