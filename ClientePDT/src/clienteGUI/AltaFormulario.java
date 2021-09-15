package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.entities.Casilla;
import com.entities.Formulario;
import com.entities.TipoValor;
import com.exception.ServiciosException;
import com.servicios.FormularioBeanRemote;

public class AltaFormulario {

	private JFrame frmMenuInicial;
	private JTextField txtNom;
	private JTextField txtResumen;

	private FormularioBeanRemote formularioBean;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaFormulario window = new AltaFormulario();
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

	public AltaFormulario() {
		try {
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
		frmMenuInicial.setTitle("Alta Formulario");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(234, 231, 66, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblMail = new JLabel("Resumen:");
		lblMail.setBounds(234, 268, 99, 14);
		frmMenuInicial.getContentPane().add(lblMail);

		txtNom = new JTextField();
		txtNom.setBounds(392, 229, 130, 20);
		frmMenuInicial.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtResumen = new JTextField();
		txtResumen.setColumns(10);
		txtResumen.setBounds(392, 264, 130, 20);
		frmMenuInicial.getContentPane().add(txtResumen);

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

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNom.getText().equals("")) {
					lblMsj.setText("Debe de ingresar un nombre.");
				} else {
					Formulario f = new Formulario();
					f.setNombre(txtNom.getText());
					f.setResumen(txtResumen.getText());
					try {
						formularioBean.crear(f);
						lblMsj.setText("Formulario creado con exito.");
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
		txtNom.setText("");
		txtResumen.setText("");
	}

}
