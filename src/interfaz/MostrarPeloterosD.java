package interfaz;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Entrenador;
import logica.Jugador;
import logica.Lanzador;
import logica.Serie;

public class MostrarPeloterosD extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarPeloterosD dialog = new MostrarPeloterosD(new PantallaPrincipal(new Login(), 1), 1, 0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnAtrs;
	private JButton btnAgregarEntrenador;

	/**
	 * Create the dialog.
	 */
	public MostrarPeloterosD(final PantallaPrincipal anterior, final int perfil, final int x) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(Serie.getInstance().getEquipos().get(x).getPeloteros().size() < 9){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea salir de esta ventana?\nActualmente este equipo no posee suficientes jugadores\npara disputar partidos, entonces será eliminado.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						hide();
					}
				}
				else{
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 708, 400);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Peloteros:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 130, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 672, 279);
		contentPane.add(scrollPane);

		btnEliminar = new JButton("Eliminar");
		if(perfil == 0){
			btnEliminar.setVisible(false);
		}
		if(Serie.getInstance().getFases().size() != 0){
			if(Serie.getInstance().getFases().get(0).getPartidos().size() != 0){
				btnEliminar.setVisible(false);
			}
		}
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, String.format("Está seguro de que desea eliminar el pelotero: \"%s\".", Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getNombre() + " " + Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getApellido()), "Eliminar Pelotero", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					Serie.getInstance().getEquipos().get(x).getPeloteros().remove(table.getSelectedRow());
					JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Pelotero eliminado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla(x);
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(593, 326, 89, 23);
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		if(perfil == 0){
			btnModificar.setVisible(false);
		}
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPeloteroD modp = new ModificarPeloteroD(MostrarPeloterosD.this, table.getSelectedRow(), x);
				modp.setVisible(true);
				cargarTabla(x);
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(494, 326, 89, 23);
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);

		table = new JTable(){
			public String getToolTipText (MouseEvent e){
				String s = null;
				java.awt.Point p = e.getPoint();
				int x = rowAtPoint(p);
				int y = columnAtPoint(p);
				if(getValueAt(x, y) instanceof Integer){
					s = String.format("%d", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof String){
					s = (String) getValueAt(x, y);
				}
				else if(getValueAt(x, y) instanceof Boolean){
					s = String.format("%b", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof Float){
					s = String.format("%.1f", getValueAt(x, y));
				}
				return s;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla(x);

		btnAgregar = new JButton("Agregar Pelotero");
		if(perfil == 0){
			btnAgregar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 1, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(347, 326, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Serie.getInstance().getEquipos().get(x).getPeloteros().size() < 9){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea salir de esta ventana?\nActualmente este equipo no posee suficientes jugadores\npara disputar partidos, entonces será eliminado.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						Serie.getInstance().getEquipos().remove(x);
						JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Este equipo acaba de ser eliminado.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
						hide();
					}
				}
				else{
					hide();
				}
			}
		});
		btnAtrs.setBounds(10, 326, 89, 23);
		contentPane.add(btnAtrs);

		btnAgregarEntrenador = new JButton("Agregar Entrenador");
		if(perfil == 0){
			btnAgregarEntrenador.setVisible(false);
		}
		btnAgregarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 0, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregarEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregarEntrenador.setBounds(180, 326, 155, 23);
		contentPane.add(btnAgregarEntrenador);
	}

	public void cargarTabla(int x){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>dorsal = new ArrayList<Object>();
		ArrayList<Object>nombre = new ArrayList<Object>();
		ArrayList<Object>posicion = new ArrayList<Object>();
		ArrayList<Object>equipo = new ArrayList<Object>();
		ArrayList<Object>aniosEq = new ArrayList<Object>();
		ArrayList<Object>aniosEx = new ArrayList<Object>();
		ArrayList<Object>lesionado = new ArrayList<Object>();
		ArrayList<Object>id = new ArrayList<Object>();
		ArrayList<Object>vecesAB = new ArrayList<Object>();
		ArrayList<Object>hits = new ArrayList<Object>();
		ArrayList<Object>homeRuns = new ArrayList<Object>();
		ArrayList<Object>errores = new ArrayList<Object>();
		ArrayList<Object>ave = new ArrayList<Object>();

		for(int j = 0; j < Serie.getInstance().getEquipos().get(x).getPeloteros().size(); j++){
			if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j) instanceof Jugador){
				posicion.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getPosicion());
				aniosEx.add("");
				lesionado.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).isLesionado());
				vecesAB.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getVecesAlBate());
				hits.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getHits());
				homeRuns.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getHomeRuns());
				errores.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getErrores());
				ave.add(((Jugador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getPromedioBateo());
			}
			else if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j) instanceof Lanzador){
				posicion.add(((Lanzador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getPosicion());
				aniosEx.add("");
				lesionado.add(((Lanzador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).isLesionado());
				vecesAB.add("");
				hits.add("");
				homeRuns.add("");
				errores.add("");
				ave.add("");
			}
			else{
				posicion.add("Entrenador");
				aniosEx.add(((Entrenador)Serie.getInstance().getEquipos().get(x).getPeloteros().get(j)).getAnosDeExperiencia());
				lesionado.add("");
				vecesAB.add("");
				hits.add("");
				homeRuns.add("");
				errores.add("");
				ave.add("");
			}
			dorsal.add(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j).getNumero());
			nombre.add(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j).getNombre() + " " + Serie.getInstance().getEquipos().get(x).getPeloteros().get(j).getApellido());
			equipo.add(Serie.getInstance().getEquipos().get(x).getNombre());
			aniosEq.add(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j).getAniosEnEquipo());
			id.add(Serie.getInstance().getEquipos().get(x).getPeloteros().get(j).getId());
		}

		modelo.addColumn("No.", dorsal.toArray());
		modelo.addColumn("Nombre", nombre.toArray());
		modelo.addColumn("Posición", posicion.toArray());
		modelo.addColumn("Equipo", equipo.toArray());
		modelo.addColumn("A. Equipo", aniosEq.toArray());
		modelo.addColumn("A. Exp", aniosEx.toArray());
		modelo.addColumn("Lesionado", lesionado.toArray());
		modelo.addColumn("ID", id.toArray());
		modelo.addColumn("Al Bate", vecesAB.toArray());
		modelo.addColumn("H", hits.toArray());
		modelo.addColumn("HR", homeRuns.toArray());
		modelo.addColumn("E", errores.toArray());
		modelo.addColumn("Ave.", ave.toArray());
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(125);
		table.getColumnModel().getColumn(1).setMaxWidth(125);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(125);
		table.getColumnModel().getColumn(3).setMaxWidth(125);
		table.getColumnModel().getColumn(4).setMinWidth(65);
		table.getColumnModel().getColumn(4).setMaxWidth(65);
		table.getColumnModel().getColumn(5).setMinWidth(45);
		table.getColumnModel().getColumn(5).setMaxWidth(45);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(75);
		table.getColumnModel().getColumn(7).setMinWidth(90);
		table.getColumnModel().getColumn(7).setMaxWidth(90);
		table.getColumnModel().getColumn(8).setMinWidth(60);
		table.getColumnModel().getColumn(8).setMaxWidth(60);
		table.getColumnModel().getColumn(9).setMinWidth(35);
		table.getColumnModel().getColumn(9).setMaxWidth(35);
		table.getColumnModel().getColumn(10).setMinWidth(35);
		table.getColumnModel().getColumn(10).setMaxWidth(35);
		table.getColumnModel().getColumn(11).setMinWidth(35);
		table.getColumnModel().getColumn(11).setMaxWidth(35);
		table.getColumnModel().getColumn(12).setMinWidth(50);
		table.getColumnModel().getColumn(12).setMaxWidth(50);
	}

	public MostrarPeloterosD(final MostrarEquiposD anterior, final int perfil, final int x) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				int jugador = 0;
				int lanzador = 0;
				for(int i = 0; i < Serie.getInstance().getEquipos().get(x).getPeloteros().size(); i++){
					if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(i) instanceof Jugador){
						jugador++;
					}
					else if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(i) instanceof Lanzador){
						lanzador++;
					}
				}
				if(lanzador == 0 || jugador < 8){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?\nEste equipo no posee la cantidad de jugadores\nnecesaria para discutir un partido, por lo tanto no será\ncreado si decide cancelar.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						JOptionPane.showMessageDialog(MostrarPeloterosD.this, "El equipo no fue creado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
						Serie.getInstance().getEquipos().remove(x);
						hide();
					}
				}
				else if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Equipo agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 708, 400);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Peloteros:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 130, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 672, 279);
		contentPane.add(scrollPane);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, String.format("Está seguro de que desea eliminar el pelotero: \"%s\".", Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getNombre() + " " + Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getApellido()), "Eliminar Pelotero", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					Serie.getInstance().getEquipos().get(x).getPeloteros().remove(table.getSelectedRow());
					JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Pelotero eliminado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla(x);
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(593, 326, 89, 23);
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPeloteroD modp = new ModificarPeloteroD(MostrarPeloterosD.this, table.getSelectedRow(), x);
				modp.setVisible(true);
				cargarTabla(x);
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(494, 326, 89, 23);
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);

		table = new JTable(){
			public String getToolTipText (MouseEvent e){
				String s = null;
				java.awt.Point p = e.getPoint();
				int x = rowAtPoint(p);
				int y = columnAtPoint(p);
				if(getValueAt(x, y) instanceof Integer){
					s = String.format("%d", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof String){
					s = (String) getValueAt(x, y);
				}
				else if(getValueAt(x, y) instanceof Boolean){
					s = String.format("%b", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof Float){
					s = String.format("%.1f", getValueAt(x, y));
				}
				return s;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla(x);

		btnAgregar = new JButton("Agregar Pelotero");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 1, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(347, 326, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int jugador = 0;
				int lanzador = 0;
				for(int i = 0; i < Serie.getInstance().getEquipos().get(x).getPeloteros().size(); i++){
					if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(i) instanceof Jugador){
						jugador++;
					}
					else if(Serie.getInstance().getEquipos().get(x).getPeloteros().get(i) instanceof Lanzador){
						lanzador++;
					}
				}
				if(lanzador == 0 || jugador < 8){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?\nEste equipo no posee la cantidad de jugadores\nnecesaria para discutir un partido, por lo tanto no será\ncreado si decide cancelar.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						JOptionPane.showMessageDialog(MostrarPeloterosD.this, "El equipo no fue creado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
						Serie.getInstance().getEquipos().remove(x);
						hide();
					}
				}
				else if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Equipo agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					hide();
				}
			}
		});
		btnAtrs.setBounds(10, 326, 89, 23);
		contentPane.add(btnAtrs);

		btnAgregarEntrenador = new JButton("Agregar Entrenador");
		if(perfil == 0){
			btnAgregarEntrenador.setVisible(false);
		}
		btnAgregarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 0, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregarEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregarEntrenador.setBounds(180, 326, 155, 23);
		contentPane.add(btnAgregarEntrenador);
	}

	public MostrarPeloterosD(final AgregarPartidoD anterior, final int perfil, final int x, final int a) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if((AgregarPartidoD.carrerasVsHC != 0 && a == 1) || (AgregarPartidoD.carrerasVsV != 0 && a == 0)){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?\nNo se han actualizado totalmente los datos de los jugadores\ncon respecto al partido, por lo tanto no se agregará.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						hide();
					}
				}
				else{
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 708, 400);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Peloteros:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 130, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 672, 279);
		contentPane.add(scrollPane);

		btnEliminar = new JButton("Eliminar");
		if(perfil == 0){
			btnEliminar.setVisible(false);
		}
		if(anterior instanceof AgregarPartidoD){
			btnEliminar.setVisible(false);
		}
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, String.format("Está seguro de que desea eliminar el pelotero: \"%s\".", Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getNombre() + " " + Serie.getInstance().getEquipos().get(x).getPeloteros().get(table.getSelectedRow()).getApellido()), "Eliminar Pelotero", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					Serie.getInstance().getEquipos().get(x).getPeloteros().remove(table.getSelectedRow());
					JOptionPane.showMessageDialog(MostrarPeloterosD.this, "Pelotero eliminado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla(x);
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(593, 326, 89, 23);
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		if(perfil == 0){
			btnModificar.setVisible(false);
		}
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPeloteroD modp = new ModificarPeloteroD(MostrarPeloterosD.this, table.getSelectedRow(), x, a);
				modp.setVisible(true);
				cargarTabla(x);
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(494, 326, 89, 23);
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);

		table = new JTable(){
			public String getToolTipText (MouseEvent e){
				String s = null;
				java.awt.Point p = e.getPoint();
				int x = rowAtPoint(p);
				int y = columnAtPoint(p);
				if(getValueAt(x, y) instanceof Integer){
					s = String.format("%d", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof String){
					s = (String) getValueAt(x, y);
				}
				else if(getValueAt(x, y) instanceof Boolean){
					s = String.format("%b", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof Float){
					s = String.format("%.1f", getValueAt(x, y));
				}
				return s;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla(x);

		btnAgregar = new JButton("Agregar Pelotero");
		if(perfil == 0){
			btnAgregar.setVisible(false);
		}
		if(anterior instanceof AgregarPartidoD){
			btnAgregar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 1, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(347, 326, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((AgregarPartidoD.carrerasVsHC != 0 && a == 1) || (AgregarPartidoD.carrerasVsV != 0 && a == 0)){
					if(JOptionPane.showConfirmDialog(MostrarPeloterosD.this, "Desea cancelar esta acción?\nNo se han actualizado totalmente los datos de los jugadores\ncon respecto al partido, por lo tanto no se agregará.", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
						hide();
					}
				}
				else{
					hide();
				}
			}
		});
		btnAtrs.setBounds(10, 326, 89, 23);
		contentPane.add(btnAtrs);

		btnAgregarEntrenador = new JButton("Agregar Entrenador");
		if(perfil == 0){
			btnAgregarEntrenador.setVisible(false);
		}
		if(anterior instanceof AgregarPartidoD){
			btnAgregarEntrenador.setVisible(false);
		}
		btnAgregarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarJugadorD ap = new AgregarJugadorD(MostrarPeloterosD.this, 0, x);
				ap.setVisible(true);
				cargarTabla(x);
			}
		});
		btnAgregarEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregarEntrenador.setBounds(180, 326, 155, 23);
		contentPane.add(btnAgregarEntrenador);
	}

}
