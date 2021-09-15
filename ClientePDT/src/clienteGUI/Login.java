package clienteGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.entities.Usuario;
import com.servicios.UsuarioBeanRemote;

public class Login {

	private JFrame frmAgrotecLogin;

	private JTextField userName;
	private JPasswordField userPsw;

	private JLabel lblNewLabel;
	private JLabel lblContrasea;

	private UsuarioBeanRemote usuario;
	private JLabel lblError;

	public JFrame getFrmAgrotecLogin() {
		return frmAgrotecLogin;
	}

	public static void main(String[] args) throws NamingException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAgrotecLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() throws NamingException {
		initialize();
		usuario = (UsuarioBeanRemote) InitialContext.doLookup("IAGRO/UsuarioBean!com.servicios.UsuarioBeanRemote");
	}

	private void initialize() {
		frmAgrotecLogin = new JFrame();
		frmAgrotecLogin.setResizable(false);
		frmAgrotecLogin.setType(Type.UTILITY);
		frmAgrotecLogin.setTitle("Agrotec Login");
		frmAgrotecLogin.setBounds(100, 100, 358, 471);
		frmAgrotecLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgrotecLogin.getContentPane().setLayout(null);

		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 335, 316, 31);
		frmAgrotecLogin.getContentPane().add(lblError);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresar.setBounds(126, 384, 100, 31);
		frmAgrotecLogin.getContentPane().add(btnIngresar);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(34, 293, 104, 31);
		frmAgrotecLogin.getContentPane().add(lblContrasea);

		lblNewLabel = new JLabel("Nombre Usuario:");
		lblNewLabel.setBounds(34, 253, 104, 31);
		frmAgrotecLogin.getContentPane().add(lblNewLabel);

		userName = new JTextField("");

		userName.setForeground(Color.GRAY);
		userName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userName.setToolTipText("Ingrese Nombre de Usuario.");
		userName.setColumns(10);
		userName.setBounds(149, 251, 160, 31);
		frmAgrotecLogin.getContentPane().add(userName);

		userPsw = new JPasswordField();
		userPsw.setToolTipText("Ingrese Contrase\u00F1a.");
		userPsw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userPsw.setBounds(148, 293, 161, 33);
		frmAgrotecLogin.getContentPane().add(userPsw);

		JLabel labelBackground = new JLabel("");
		labelBackground.setVerticalAlignment(SwingConstants.TOP);
		labelBackground.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBackground.setIcon(new ImageIcon(Login.class.getResource("/images/agro1.jpg")));
		labelBackground.setBounds(0, 0, 342, 432);
		frmAgrotecLogin.getContentPane().add(labelBackground);
		
		frmAgrotecLogin.getRootPane().setDefaultButton(btnIngresar);//CON EL ENTER DOY CLICK EN LOGIN.

		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!userName.getText().equals("") && !userPsw.getText().equals("")) {
					Usuario u = usuario.buscarPorNombreUsuario(userName.getText());
					if (u != null) {
						if (u.getContraseña().equals(userPsw.getText())) {
							lblError.setText("Exito");
							MainWindow mw = new MainWindow(u);
							mw.getFrame().setVisible(true);
							frmAgrotecLogin.dispose();
						} else {
							lblError.setText("Contraseña incorrecta.");
						}
					} else {
						lblError.setText("El Usuario es incorrecto.");
					}
				} else {
					lblError.setText("Ingrese Usuario y contraseña.");
				}
			}
		});
	}
}
