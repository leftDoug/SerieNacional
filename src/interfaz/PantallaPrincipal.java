package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import extras.Datos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import logica.HistoricosFinales;
import logica.Serie;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenu mnArchivo;
	private JMenu mnOpciones;
	private JMenuItem mntmMostrarPeloteros;
	private JMenuItem mntmMostrarEquipos;
	private JMenuItem mntmMostrarEstadios;
	private JMenuItem mntmMostrarFases;
	private JMenuItem mntmMostrarPartidos;
	private JMenuItem mntmTablaDePosiciones;
	private JMenuItem mntmHistricosFinales;
	private JMenuItem mntmConsultarReportes;
	private JMenuItem mntmActualizarHistricosFinales;
	private JMenuItem mntmCargarDatos;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmCrditos;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmSalir;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JMenuItem mntmMostrarEstadisticasGenerales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal(new Login(), 1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal(final Login anterior, final int perfil) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(PantallaPrincipal.this, "¿Esta seguro que desea salir?",
						"Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					System.exit(0);
				}
			}
		});
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaPrincipal.class.getResource("/imagenes/iconom.gif")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 723, 455);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 768, 21);
		contentPane.add(menuBar);

		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmMostrarPeloteros = new JMenuItem("Mostrar Peloteros");
		mntmMostrarPeloteros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getEquipos().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen equipos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir equipos\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					SeleccionarEquipoD se = new SeleccionarEquipoD(PantallaPrincipal.this, perfil);
					se.setVisible(true);
				}
			}
		});
		mnArchivo.add(mntmMostrarPeloteros);

		mntmMostrarEquipos = new JMenuItem("Mostrar Equipos");
		mntmMostrarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarEquiposD me = new MostrarEquiposD(PantallaPrincipal.this, perfil);
				me.setVisible(true);
			}
		});
		mnArchivo.add(mntmMostrarEquipos);

		mntmMostrarEstadios = new JMenuItem("Mostrar Estadios");
		mntmMostrarEstadios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarEstadiosD me = new MostrarEstadiosD(PantallaPrincipal.this, perfil);
				me.setVisible(true);
			}
		});
		mnArchivo.add(mntmMostrarEstadios);

		mntmMostrarFases = new JMenuItem("Mostrar Fases");
		mntmMostrarFases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarFasesD mf = new MostrarFasesD(PantallaPrincipal.this, perfil);
				mf.setVisible(true);
			}
		});
		mnArchivo.add(mntmMostrarFases);

		mntmMostrarPartidos = new JMenuItem("Mostrar Partidos");
		mntmMostrarPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getEquipos().size() < 9 || Serie.getInstance().getFases().size() == 0 || Serie.getInstance().getEstadios().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen partidos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir al menos\nnueve equipos, una fase y un estadio en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					MostrarPartidosD mp = new MostrarPartidosD(PantallaPrincipal.this, perfil);
					mp.setVisible(true);
				}
			}
		});
		mnArchivo.add(mntmMostrarPartidos);

		mntmTablaDePosiciones = new JMenuItem("Mostrar Tabla de Posiciones");
		mntmTablaDePosiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getEquipos().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen equipos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir equipos\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					MostrarTablaPosicionesD mtp = new MostrarTablaPosicionesD(PantallaPrincipal.this);
					mtp.setVisible(true);
				}
			}
		});
		mnArchivo.add(mntmTablaDePosiciones);

		mntmHistricosFinales = new JMenuItem("Mostrar Hist\u00F3ricos Finales");
		mntmHistricosFinales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(perfil == 0){
					Datos.cargarHistoricos();
				}
				else{
					JOptionPane.showMessageDialog(PantallaPrincipal.this, "No han sido inicializados los datos aún.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
				}
				SeleccionarSerieD ss = new SeleccionarSerieD(PantallaPrincipal.this);
				ss.setVisible(true);
			}
		});

		mntmMostrarEstadisticasGenerales = new JMenuItem("Mostrar Estad\u00EDsticas Generales");
		mntmMostrarEstadisticasGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getEquipos().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen equipos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir equipos\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					MostrarEstadisticas me = new MostrarEstadisticas(PantallaPrincipal.this);
					me.setVisible(true);
				}
			}
		});
		mnArchivo.add(mntmMostrarEstadisticasGenerales);
		mnArchivo.add(mntmHistricosFinales);

		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		mnArchivo.add(separator);

		mntmActualizarHistricosFinales = new JMenuItem("Actualizar Hist\u00F3ricos Finales");
		if(perfil == 0){
			mntmActualizarHistricosFinales.setVisible(false);
			separator.setVisible(false);
		}
		mntmActualizarHistricosFinales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getFases().size() != 4){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen partidos pertenecientes a la fase final en la actual\nSerie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla debe existir fase final\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(Serie.getInstance().getFases().get(3).getPartidos().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen partidos pertenecientes a la fase final en la actual\nSerie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir partidos pertenecientes\na la fase final en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					//					Serie.getInstance().actualizarHistoricos(Serie.getInstance());
					HistoricosFinales.getInstance().agregarSerie(Serie.getInstance());
					JOptionPane.showMessageDialog(PantallaPrincipal.this, "Historicos finales actualizados correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmActualizarHistricosFinales);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		mnArchivo.add(separator_1);

		mntmConsultarReportes = new JMenuItem("Consultar Reportes");
		mntmConsultarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getFases().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen partidos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir partidos\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(Serie.getInstance().getFases().get(0).getPartidos().size() == 0){
					if(perfil == 0){
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "No existen partidos en la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(PantallaPrincipal.this, "Para acceder a esta pantalla deben existir partidos\nen la actual Serie Nacional.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					ReportesD r = new ReportesD(PantallaPrincipal.this);
					r.setVisible(true);
				}
			}
		});
		mnArchivo.add(mntmConsultarReportes);

		separator_2 = new JSeparator();
		mnArchivo.add(separator_2);

		mntmCargarDatos = new JMenuItem("Cargar Datos");
		if(perfil == 0){
			mntmCargarDatos.setVisible(false);
			separator_2.setVisible(false);
		}
		mntmCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Datos.inicializarDatos();
				Datos.cargarHistoricos();
				JOptionPane.showMessageDialog(PantallaPrincipal.this, "Datos cargados correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
				mntmCargarDatos.setEnabled(false);
			}
		});
		mnArchivo.add(mntmCargarDatos);

		mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);

		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda a = new Ayuda(PantallaPrincipal.this);
				a.setVisible(true);
			}
		});
		mnOpciones.add(mntmAyuda);

		mntmCrditos = new JMenuItem("Cr\u00E9ditos");
		mntmCrditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreditosD c = new CreditosD(PantallaPrincipal.this);
				c.setVisible(true);
			}
		});
		mnOpciones.add(mntmCrditos);

		mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(PantallaPrincipal.this, "¿Esta seguro que desea cerrar la sesión actual?",
						"Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					setVisible(false);
					anterior.setVisible(true);
				}
			}
		});
		mnOpciones.add(mntmCerrarSesin);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(PantallaPrincipal.this, "¿Esta seguro que desea salir?",
						"Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					System.exit(0);
				}
			}
		});
		mnOpciones.add(mntmSalir);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/imagenes/IMG_20190604_212717.jpg")));
		label.setBounds(0, 21, 720, 409);
		contentPane.add(label);

		if(perfil == 1){

		}
	}
}
