package clienteGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.entities.Administrador;
import com.entities.Comun;
import com.entities.Experto;
import com.entities.Usuario;

public class MainWindow {

	private JFrame frmMenuInicial;
	private static Usuario usuario;

	public JFrame getFrame() {
		return frmMenuInicial;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public MainWindow(Usuario usu) {
		usuario = usu;
		initialize();
	}

	private void initialize() {
		frmMenuInicial = new JFrame();
		frmMenuInicial.setTitle("Menu inicial | " + usuario.getNombUsuario());
		frmMenuInicial.setBounds(100, 100, 800, 600);
		frmMenuInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuInicial.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 21, 1024, 768);
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/verde.jpg")));
		frmMenuInicial.getContentPane().add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1008, 22);
		frmMenuInicial.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Usuarios");

		if (usuario instanceof Administrador) {// SI ES ADMINISTADOR HABILITA EL MENU DE USUARIOS
			menuBar.add(mnNewMenu);
		}

		JMenuItem mntmNewMenuItem = new JMenuItem("Crear");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AltaUsuario alta = new AltaUsuario();
				alta.getFrmMenuInicial().setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Listado");
		mntmNewMenuItem_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoUsuario mu = new ListadoUsuario();
				mu.getFrame().setVisible(true);
			}
		});

		mnNewMenu.add(mntmNewMenuItem_1_1);
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnFormularios = new JMenu("Formularios");
		menuBar.add(mnFormularios);

		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AltaFormulario af = new AltaFormulario();
				af.getFrame().setVisible(true);
			}
		});

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean com = false;
				if (usuario instanceof Comun) {
					com = true;
				}
				ListadoFormulario lf = new ListadoFormulario(com);
				lf.getFrame().setVisible(true);
			}
		});
		mnFormularios.add(mntmListar);

		JMenu mnSalir = new JMenu("Salir");

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login log;
				try {
					log = new Login();
					log.getFrmAgrotecLogin().setVisible(true);
					frmMenuInicial.dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnSalir.add(mntmSalir);

		JMenu mnCasillas = new JMenu("Casillas");

		JMenuItem mntmCrear_1 = new JMenuItem("Crear");
		mntmCrear_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AltaCasilla ac = new AltaCasilla();
				ac.getFrame().setVisible(true);
			}
		});

		mnCasillas.add(mntmCrear_1);

		

		JMenu mnListados = new JMenu("Analisis de muestreos");

		JMenuItem mntmAcForm = new JMenuItem("Actividad por Estacion");
		mntmAcForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoACEstacion lace = new ListadoACEstacion();
				lace.getFrame().setVisible(true);
			}
		});
		mnListados.add(mntmAcForm);

		JMenuItem mntmActividadPorFecha = new JMenuItem("Actividad por Fecha");
		mntmActividadPorFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoACFecha lacf = new ListadoACFecha();
				lacf.getFrame().setVisible(true);
			}
		});
		mnListados.add(mntmActividadPorFecha);

		JMenuItem mntmActividadPorExperto = new JMenuItem("Actividad por Experto");
		mntmActividadPorExperto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoACExperto lace = new ListadoACExperto();
				lace.getFrame().setVisible(true);
			}
		});
		mnListados.add(mntmActividadPorExperto);
		if (usuario instanceof Administrador || usuario instanceof Experto) {// SI ES ADMINISTADOR O EXPERTO HABILITA EL
			// MENU DE USUARIOS
			mnFormularios.add(mntmCrear);
			menuBar.add(mnCasillas);
			menuBar.add(mnListados);

		}
		menuBar.add(mnSalir);
	}
}
