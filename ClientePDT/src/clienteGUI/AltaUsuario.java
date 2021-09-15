package clienteGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Experto;
import com.servicios.AdministradorBeanRemote;
import com.servicios.ComunBeanRemote;
import com.servicios.ExpertoBeanRemote;
import javax.swing.JPasswordField;

public class AltaUsuario {

	private JFrame frmMenuInicial;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtUsu;
	private JTextField txtMail;
	private JTextField txtCI;
	private JTextField txtProf;
	private JTextField txtInst;

	private ExpertoBeanRemote expertoBean;
	private ComunBeanRemote comunBean;
	private AdministradorBeanRemote adminBean;
	private JPasswordField txtPas;

	public JFrame getFrmMenuInicial() {
		return frmMenuInicial;
	}

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public AltaUsuario() {
		try {
			expertoBean = (ExpertoBeanRemote) InitialContext
					.doLookup("IAGRO/ExpertoBean!com.servicios.ExpertoBeanRemote");
			comunBean = (ComunBeanRemote) InitialContext.doLookup("IAGRO/ComunBean!com.servicios.ComunBeanRemote");
			adminBean = (AdministradorBeanRemote) InitialContext
					.doLookup("IAGRO/AdministradorBean!com.servicios.AdministradorBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setResizable(false);
		frmMenuInicial.setTitle("Alta Usuario");
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Rol:");
		lblNewLabel_1.setBounds(219, 46, 66, 24);
		frmMenuInicial.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(217, 97, 66, 14);
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(217, 205, 66, 14);
		frmMenuInicial.getContentPane().add(lblApellido);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(217, 134, 46, 14);
		frmMenuInicial.getContentPane().add(lblMail);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(217, 242, 66, 14);
		frmMenuInicial.getContentPane().add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(217, 163, 77, 14);
		frmMenuInicial.getContentPane().add(lblContrasea);

		txtNom = new JTextField();
		txtNom.setBounds(375, 95, 130, 20);
		frmMenuInicial.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(375, 199, 130, 20);
		frmMenuInicial.getContentPane().add(txtApe);

		txtUsu = new JTextField();
		txtUsu.setColumns(10);
		txtUsu.setBounds(375, 236, 130, 20);
		frmMenuInicial.getContentPane().add(txtUsu);

		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(375, 130, 130, 20);
		frmMenuInicial.getContentPane().add(txtMail);

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(217, 282, 60, 14);
		frmMenuInicial.getContentPane().add(lblCedula);

		txtCI = new JTextField();
		txtCI.setColumns(10);
		txtCI.setBounds(375, 276, 130, 20);
		frmMenuInicial.getContentPane().add(txtCI);

		JLabel lblProfesion = new JLabel("Profesion:");
		lblProfesion.setVisible(false);
		lblProfesion.setBounds(217, 342, 77, 14);
		frmMenuInicial.getContentPane().add(lblProfesion);

		txtProf = new JTextField();
		txtProf.setVisible(false);
		txtProf.setColumns(10);
		txtProf.setBounds(375, 338, 130, 20);
		frmMenuInicial.getContentPane().add(txtProf);

		txtInst = new JTextField();
		txtInst.setColumns(10);
		txtInst.setBounds(375, 307, 130, 20);
		frmMenuInicial.getContentPane().add(txtInst);

		JLabel lblInstituto = new JLabel("Instituto:");
		lblInstituto.setBounds(217, 313, 66, 14);
		frmMenuInicial.getContentPane().add(lblInstituto);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboBox.getSelectedIndex() == 0) {
					lblCedula.setVisible(true);
					txtCI.setVisible(true);
					lblInstituto.setVisible(true);
					txtInst.setVisible(true);
					lblProfesion.setVisible(false);
					txtProf.setVisible(false);
				} else if (comboBox.getSelectedIndex() == 1) {
					lblCedula.setVisible(true);
					txtCI.setVisible(true);
					lblProfesion.setVisible(true);
					txtProf.setVisible(true);
					lblInstituto.setVisible(false);
					txtInst.setVisible(false);
				} else {
					lblCedula.setVisible(false);
					txtCI.setVisible(false);
					lblProfesion.setVisible(false);
					txtProf.setVisible(false);
					lblInstituto.setVisible(false);
					txtInst.setVisible(false);
				}
			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Administrador", "Experto", "Comun" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(332, 46, 135, 24);
		frmMenuInicial.getContentPane().add(comboBox);

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
		
		txtPas = new JPasswordField();
		txtPas.setBounds(375, 160, 130, 20);
		frmMenuInicial.getContentPane().add(txtPas);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNom.getText().equals("") || txtApe.getText().equals("") || txtPas.getText().equals("")
						|| txtMail.getText().equals("") || txtUsu.getText().equals("")) {
					lblMsj.setText("Debe completar todos los campos.");
				} else {
					if (!validarMail(txtMail.getText())) {
						lblMsj.setText("El formato del mail no es valido.");
					} else if (!validarSinNumeros(txtUsu.getText())) {
						lblMsj.setText("El nombre de usuario debe de tener minimo 8 caracteres no numericos.");
					} else if (!validarPass(txtPas.getText())) {
						lblMsj.setText("La contraseña debe contener al menos 8 caracteres, numeros y letras.");
					} else {
						if (comboBox.getSelectedIndex() == 0) {
							if (txtCI.getText().equals("") && txtInst.getText().equals("")) {
								lblMsj.setText("Debe completar la cedula e insituto.");
							} else {
								Administrador adm = new Administrador(txtApe.getText(), txtPas.getText(),
										txtMail.getText(), txtUsu.getText(), txtNom.getText(), txtCI.getText(),
										txtInst.getText());
								try {
									adminBean.crear(adm);
									lblMsj.setText("Usuario Administrador dado de alta!.");
									borrarCampos();
								} catch (Exception e) {
									lblMsj.setText(e.getMessage());
									e.printStackTrace();
								}
							}
						} else if (comboBox.getSelectedIndex() == 1) {
							if (txtCI.getText().equals("") && txtProf.getText().equals("")) {
								lblMsj.setText("Debe completar la cedula y profesion.");
							} else {
								Experto exp = new Experto(txtApe.getText(), txtPas.getText(), txtMail.getText(),
										txtUsu.getText(), txtNom.getText(), txtCI.getText(), txtProf.getText());
								try {
									expertoBean.crear(exp);
									lblMsj.setText("Usuario Experto dado de alta!.");
									borrarCampos();
								} catch (Exception e) {
									lblMsj.setText(e.getMessage());
									e.printStackTrace();
								}
							}
						} else {
							Comun co = new Comun(txtApe.getText(), txtPas.getText(), txtMail.getText(),
									txtUsu.getText(), txtNom.getText());
							try {
								comunBean.crear(co);
								lblMsj.setText("Usuario Comun dado de alta!.");
								borrarCampos();
							} catch (Exception e) {
								lblMsj.setText(e.getMessage());
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
	}

	public void borrarCampos() {
		txtApe.setText("");
		txtCI.setText("");
		txtPas.setText("");
		txtInst.setText("");
		txtMail.setText("");
		txtNom.setText("");
		txtProf.setText("");
		txtUsu.setText("");
	}

	public boolean validarMail(String mail) {
		boolean ret = false;
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(mail);

		if (mather.find() == true) {
			ret = true;
		}

		return ret;
	}

	public boolean validarSinNumeros(String s) {
		boolean ret = true;
		for (int x = 0; x < s.length(); x++) {
			if (isNumeric(Character.toString(s.charAt(x)))) {
				ret = false;
			}
		}
		if (s.length() >= 8 && ret) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarPass(String p) {
		boolean let = false;
		boolean num = false;
		if (p.length() >= 8) {
			for (int x = 0; x < p.length(); x++) {
				if (isNumeric(Character.toString(p.charAt(x)))) {
					num = true;
				} else {
					let = true;
				}
			}
		}
		if (let && num) {
			return true;
		} else {
			return false;
		}
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
