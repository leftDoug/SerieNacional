package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import extras.Datos;
import extras.Seguridad;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import logica.Serie;

public class Login extends JFrame {


	private static final long serialVersionUID = 622568625858553394L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JTextField txtUsuario;
	private JLabel lblClicAquiPara;
	private JButton btnConsultor;
	private JLabel lblBienvenido;
	private JPasswordField pwdContrasenia;
	private JLabel lblLogoinder;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(Login.this, "¿Esta seguro que desea salir?",
						"Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					System.exit(0);
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/iconom.gif")));
		setResizable(false);
		setTitle("Serie Nacional de Beisbol");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(107, 196, 53, 19);
		contentPane.add(lblUsuario);

		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasenia.setBounds(81, 225, 79, 19);
		contentPane.add(lblContrasenia);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == txtUsuario){
					String u = new String(txtUsuario.getText());
					String c = new String(pwdContrasenia.getPassword());
					if(Seguridad.acceso(u, c)){
						setVisible(false);
						PantallaPrincipal pantalla = new PantallaPrincipal(Login.this, 1);
						pantalla.setVisible(true);
					}
					else{
						txtUsuario.setText("");
						pwdContrasenia.setText("");
						JOptionPane.showMessageDialog(Login.this, "¡Credenciales incorrectas!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		txtUsuario.setBounds(172, 194, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblBienvenido = new JLabel("¡Bienvenido!");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(12, 155, 420, 25);
		contentPane.add(lblBienvenido);

		lblClicAquiPara = new JLabel("Clic aqui para hacer solo consultas>>");
		lblClicAquiPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClicAquiPara.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClicAquiPara.setBounds(124, 332, 201, 15);
		contentPane.add(lblClicAquiPara);

		btnConsultor = new JButton("Consultor");
		btnConsultor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getSerie() == null){
					Datos.inicializarDatos();
				}
				setVisible(false);
				PantallaPrincipal pantalla = new PantallaPrincipal(Login.this, 0);
				pantalla.setVisible(true);
			}
		});
		btnConsultor.setBounds(335, 326, 97, 25);
		contentPane.add(btnConsultor);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u = new String(txtUsuario.getText());
				String c = new String(pwdContrasenia.getPassword());
				if(Seguridad.acceso(u, c)){
					setVisible(false);
					PantallaPrincipal pantalla = new PantallaPrincipal(Login.this, 1);
					pantalla.setVisible(true);
				}
				else{
					txtUsuario.setText("");
					pwdContrasenia.setText("");
					JOptionPane.showMessageDialog(Login.this, "¡Credenciales incorrectas!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setBounds(182, 269, 97, 25);
		contentPane.add(btnEntrar);

		pwdContrasenia = new JPasswordField();
		pwdContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == pwdContrasenia){
					String u = new String(txtUsuario.getText());
					String c = new String(pwdContrasenia.getPassword());
					if(Seguridad.acceso(u, c)){
						setVisible(false);
						PantallaPrincipal pantalla = new PantallaPrincipal(Login.this, 1);
						pantalla.setVisible(true);
					}
					else{
						txtUsuario.setText("");
						pwdContrasenia.setText("");
						JOptionPane.showMessageDialog(Login.this, "¡Credenciales incorrectas!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		pwdContrasenia.setBounds(172, 224, 116, 22);
		contentPane.add(pwdContrasenia);

		lblLogoinder = new JLabel("");
		lblLogoinder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoinder.setIcon(new ImageIcon(Login.class.getResource("/imagenes/ZYTFggZe_400x400.png")));
		lblLogoinder.setBounds(12, 13, 420, 129);
		contentPane.add(lblLogoinder);
		
	}
}
