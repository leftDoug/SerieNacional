package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Entrenador;
import logica.Jugador;
import logica.Lanzador;
import logica.Pelotero;
import logica.Serie;
import extras.Validaciones;

import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JRadioButton;

public class ModificarPeloteroD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblModificarPelotero;
	private JPanel panel;
	private JLabel lblNombre;
	private JLabel lblPosicion;
	private JLabel lblID;
	private JLabel lblDorsal;
	private JLabel lblAniosEq;
	private JLabel lblAniosExp;
	private JTextField txtNombre;
	private JTextField txtID;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JComboBox<String> comboBox;
	private JPanel panel_1;
	private JLabel lblPrimerApellidoDel;
	private JTextField txtApellido;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblLesionado;
	private JSpinner spinner_2;
	private JPanel panel_2;
	private JLabel lblHits;
	private JSpinner spinner_3;
	private JLabel lblHomeRuns;
	private JSpinner spinner_4;
	private JLabel lblErrores;
	private JSpinner spinner_5;
	private JLabel lblEntradasLanzadas;
	private JSpinner spinner_6;
	private JLabel lblCarrerasPermitidas;
	private JSpinner spinner_7;
	private ButtonGroup grupo;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JLabel lblVecesAlBate;
	private JSpinner spinner_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarPeloteroD dialog = new ModificarPeloteroD(new MostrarPeloterosD(new PantallaPrincipal(new Login(), 1), 1, 1), 0, 0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarPeloteroD(final MostrarPeloterosD anterior, final int x, final int e) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarPeloteroD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEquipoD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 585, 375);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModificarPelotero = new JLabel("Modificar Pelotero:");
		lblModificarPelotero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModificarPelotero.setBounds(10, 11, 116, 15);
		contentPane.add(lblModificarPelotero);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 37, 547, 133);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 24, 47, 15);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblPosicion = new JLabel("Posici\u00F3n:");
		lblPosicion.setBounds(283, 76, 51, 15);
		panel.add(lblPosicion);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			lblPosicion.setVisible(false);
		}
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblID = new JLabel("CI:");
		lblID.setBounds(10, 50, 15, 15);
		panel.add(lblID);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setBounds(283, 50, 36, 15);
		panel.add(lblDorsal);
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAniosEq = new JLabel("Cantidad de a\u00F1os en el equipo:");
		lblAniosEq.setBounds(10, 76, 170, 15);
		panel.add(lblAniosEq);
		lblAniosEq.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAniosExp = new JLabel("Cantidad de a\u00F1os de experiencia:");
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			lblAniosExp.setEnabled(true);
		}
		else{
			lblAniosExp.setEnabled(false);
		}
		lblAniosExp.setBounds(10, 102, 181, 15);
		panel.add(lblAniosExp);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			lblAniosExp.setVisible(false);
		}
		lblAniosExp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombre = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre());
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtNombre, arg0);
			}
		});
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(67, 22, 120, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtID = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId());
		txtID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.ID(txtID, arg0);
			}
		});
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtID.setBounds(35, 47, 120, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(190, 73, 47, 20);
		spinner.setValue(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo());
		panel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setBounds(201, 99, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			spinner_1.setEnabled(true);
			spinner_1.setValue(((Entrenador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getAnosDeExperiencia());
		}
		else{
			spinner_1.setEnabled(false);
		}
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_1.setVisible(false);
		}
		panel.add(spinner_1);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primera Base", "Segunda Base", "Tercera Base", "Receptor", "Lanzador", "Campocorto", "Jard\u00EDn Izquierdo", "Jard\u00EDn Central", "Jard\u00EDn Derecho"}));
		comboBox.setBounds(339, 74, 120, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			comboBox.setSelectedItem(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getPosicion());
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			comboBox.setSelectedIndex(4);
		}
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			comboBox.setVisible(false);
		}
		panel.add(comboBox);

		lblPrimerApellidoDel = new JLabel("Primer apellido:");
		lblPrimerApellidoDel.setBounds(283, 24, 82, 15);
		panel.add(lblPrimerApellidoDel);
		lblPrimerApellidoDel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtApellido = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido());
		txtApellido.setBounds(375, 21, 120, 20);
		panel.add(txtApellido);
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtApellido, arg0);
			}
		});
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellido.setColumns(10);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_2.setBounds(329, 47, 47, 20);
		spinner_2.setValue(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero());
		panel.add(spinner_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Lesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(387, 181, 170, 51);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			panel_1.setVisible(false);
		}
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblLesionado = new JLabel("Lesionado:");
		lblLesionado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLesionado.setBounds(10, 24, 58, 15);
		panel_1.add(lblLesionado);

		grupo = new ButtonGroup();

		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.setBounds(74, 21, 35, 23);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			if(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnSi.setSelected(true);
			}
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			if(((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnSi.setSelected(true);
			}
		}
		panel_1.add(rdbtnSi);
		grupo.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(123, 21, 41, 23);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			if(!((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnNo.setSelected(true);
			}
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			if(!((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnNo.setSelected(true);
			}
		}
		panel_1.add(rdbtnNo);
		grupo.add(rdbtnNo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarPeloteroD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(468, 303, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = Validaciones.ultimoEspacio(txtNombre);
				String apellido = Validaciones.ultimoEspacio(txtApellido);
				String id = txtID.getText();
				String posicion = (String) comboBox.getSelectedItem();
				int aniosEq = (Integer) spinner.getValue();
				int aniosExp = (Integer) spinner_1.getValue();
				int dorsal = (Integer) spinner_2.getValue();
				int hits = (Integer) spinner_3.getValue();
				int homeR = (Integer) spinner_4.getValue();
				int errores = (Integer) spinner_5.getValue();
				int entradasL = (Integer) spinner_6.getValue();
				int carrerasP = (Integer) spinner_7.getValue();
				int vecesAB = (Integer) spinner_8.getValue();
				boolean lesionado;

				if(rdbtnSi.isSelected()){
					lesionado = true;
				}
				else{
					lesionado = false;
				}

				if(!(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty())){
					if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
						if(aniosExp >= aniosEq){
							if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null && dorsal != Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero()){
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
							}
							else if(id.length() == 11){
								if(Serie.getInstance().getEquipos().get(e).buscarPelotero(id) != null && !id.equals(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId())){
									JOptionPane.showMessageDialog(ModificarPeloteroD.this, String.format("Ya existe un pelotero con el carnet de identidad:\n\"%s\"", id), "ERROR", JOptionPane.ERROR_MESSAGE);
								}
								else{
									if(Serie.getInstance().getEquipos().get(e).modificarEntrenador(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo(), ((Entrenador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getAnosDeExperiencia(), nombre, apellido, dorsal, id, aniosEq, aniosExp)){
										JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Pelotero modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
										hide();
									}
									else{
										JOptionPane.showMessageDialog(ModificarPeloteroD.this, "No ha sido modificado ningún aspecto de este pelotero.", "AVISO", JOptionPane.WARNING_MESSAGE);
									}
								}
							}
							else{
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, "El carnet de identidad debe tener 11 dígitos", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de años de experiencia no puede ser\nmenor que la cantidad de años en el equipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
						if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null && dorsal != Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero()){
							JOptionPane.showMessageDialog(ModificarPeloteroD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							if(Serie.getInstance().getEquipos().get(e).modificarLanzador(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getEntradasLanzadas(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getCarrerasPermitidas(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado(), nombre, apellido, dorsal, id, aniosEq, entradasL, carrerasP, errores, lesionado)){
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Pelotero modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
								hide();
							}
							else{
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, "No ha sido modificado ningún aspecto de este pelotero.", "AVISO", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					else{
						if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null && dorsal != Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero()){
							JOptionPane.showMessageDialog(ModificarPeloteroD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							if(Serie.getInstance().getEquipos().get(e).modificarJugador(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getPosicion(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getVecesAlBate(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHits(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHomeRuns(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado(), nombre, apellido, dorsal, posicion, id, aniosEq, vecesAB, hits, homeR, errores, lesionado)){
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Pelotero modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
								hide();
							}
							else{
								JOptionPane.showMessageDialog(ModificarPeloteroD.this, "No ha sido modificado ningún aspecto de este pelotero.", "AVISO", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Existen campos sin rellenar.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(369, 303, 89, 23);
		contentPane.add(btnAceptar);

		panel_2 = new JPanel();
		panel_2.setEnabled(false);
		panel_2.setBorder(new TitledBorder(null, "Datos Estad\u00EDsticos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 181, 367, 111);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblHits = new JLabel("Hits:");
		lblHits.setEnabled(false);
		lblHits.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHits.setBounds(10, 24, 24, 15);
		panel_2.add(lblHits);

		lblHomeRuns = new JLabel("Home runs:");
		lblHomeRuns.setEnabled(false);
		lblHomeRuns.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHomeRuns.setBounds(10, 49, 63, 15);
		panel_2.add(lblHomeRuns);

		lblErrores = new JLabel("Errores:");
		lblErrores.setEnabled(false);
		lblErrores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrores.setBounds(191, 78, 42, 15);
		panel_2.add(lblErrores);

		spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_3.setBounds(44, 22, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_3.setValue(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHits());
		}
		panel_2.add(spinner_3);

		spinner_4 = new JSpinner();
		spinner_4.setEnabled(false);
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_4.setBounds(83, 47, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_4.setValue(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHomeRuns());
		}
		panel_2.add(spinner_4);

		spinner_5 = new JSpinner();
		spinner_5.setEnabled(false);
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_5.setBounds(243, 75, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_5.setValue(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores());
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_5.setValue(((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores());
		}
		panel_2.add(spinner_5);

		lblEntradasLanzadas = new JLabel("Entradas lanzadas:");
		lblEntradasLanzadas.setEnabled(false);
		lblEntradasLanzadas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEntradasLanzadas.setBounds(191, 25, 99, 15);
		panel_2.add(lblEntradasLanzadas);

		lblCarrerasPermitidas = new JLabel("Carreras permitidas:");
		lblCarrerasPermitidas.setEnabled(false);
		lblCarrerasPermitidas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarrerasPermitidas.setBounds(191, 50, 106, 15);
		panel_2.add(lblCarrerasPermitidas);

		spinner_6 = new JSpinner();
		spinner_6.setEnabled(false);
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spinner_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_6.setBounds(300, 22, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_6.setValue(((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getEntradasLanzadas());
		}
		panel_2.add(spinner_6);

		spinner_7 = new JSpinner();
		spinner_7.setEnabled(false);
		spinner_7.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		spinner_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_7.setBounds(307, 47, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_7.setValue(((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getCarrerasPermitidas());
		}
		panel_2.add(spinner_7);

		lblVecesAlBate = new JLabel("Veces al bate:");
		lblVecesAlBate.setEnabled(false);
		lblVecesAlBate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVecesAlBate.setBounds(10, 75, 78, 15);
		panel_2.add(lblVecesAlBate);

		spinner_8 = new JSpinner();
		spinner_8.setEnabled(false);
		spinner_8.setModel(new SpinnerNumberModel(0, 0, 500, 1));
		spinner_8.setBounds(98, 76, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_8.setValue(((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getVecesAlBate());
		}
		panel_2.add(spinner_8);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public ModificarPeloteroD(final MostrarPeloterosD anterior, final int x, final int e, final int a) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarPeloteroD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEquipoD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 585, 375);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModificarPelotero = new JLabel("Modificar Pelotero:");
		lblModificarPelotero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModificarPelotero.setBounds(10, 11, 116, 15);
		contentPane.add(lblModificarPelotero);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 37, 547, 133);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 24, 47, 15);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblPosicion = new JLabel("Posici\u00F3n:");
		lblPosicion.setBounds(283, 76, 51, 15);
		panel.add(lblPosicion);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			lblPosicion.setVisible(false);
		}
		lblPosicion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblID = new JLabel("CI:");
		lblID.setBounds(10, 50, 15, 15);
		panel.add(lblID);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setBounds(283, 50, 36, 15);
		panel.add(lblDorsal);
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAniosEq = new JLabel("Cantidad de a\u00F1os en el equipo:");
		lblAniosEq.setBounds(10, 76, 170, 15);
		panel.add(lblAniosEq);
		lblAniosEq.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblAniosExp = new JLabel("Cantidad de a\u00F1os de experiencia:");
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			lblAniosExp.setEnabled(true);
		}
		else{
			lblAniosExp.setEnabled(false);
		}
		lblAniosExp.setBounds(10, 102, 181, 15);
		panel.add(lblAniosExp);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			lblAniosExp.setVisible(false);
		}
		lblAniosExp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombre = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre());
		txtNombre.setEnabled(false);
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtNombre, arg0);
			}
		});
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(67, 22, 120, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtID = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId());
		txtID.setEnabled(false);
		txtID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.ID(txtID, arg0);
			}
		});
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtID.setBounds(35, 47, 120, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(190, 73, 47, 20);
		spinner.setValue(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo());
		panel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setBounds(201, 99, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			spinner_1.setEnabled(true);
			spinner_1.setValue(((Entrenador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getAnosDeExperiencia());
		}
		else{
			spinner_1.setEnabled(false);
		}
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador || Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_1.setVisible(false);
		}
		panel.add(spinner_1);

		comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primera Base", "Segunda Base", "Tercera Base", "Receptor", "Lanzador", "Campocorto", "Jard\u00EDn Izquierdo", "Jard\u00EDn Central", "Jard\u00EDn Derecho"}));
		comboBox.setBounds(339, 74, 120, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			comboBox.setSelectedItem(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getPosicion());
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			comboBox.setSelectedIndex(4);
		}
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			comboBox.setVisible(false);
		}
		panel.add(comboBox);

		lblPrimerApellidoDel = new JLabel("Primer apellido:");
		lblPrimerApellidoDel.setBounds(283, 24, 82, 15);
		panel.add(lblPrimerApellidoDel);
		lblPrimerApellidoDel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtApellido = new JTextField(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido());
		txtApellido.setEnabled(false);
		txtApellido.setBounds(375, 21, 120, 20);
		panel.add(txtApellido);
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtApellido, arg0);
			}
		});
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellido.setColumns(10);

		spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_2.setBounds(329, 47, 47, 20);
		spinner_2.setValue(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero());
		panel.add(spinner_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Lesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(387, 181, 170, 51);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Entrenador){
			panel_1.setVisible(false);
		}
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblLesionado = new JLabel("Lesionado:");
		lblLesionado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLesionado.setBounds(10, 24, 58, 15);
		panel_1.add(lblLesionado);

		grupo = new ButtonGroup();

		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.setBounds(74, 21, 35, 23);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			if(((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnSi.setSelected(true);
			}
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			if(((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnSi.setSelected(true);
			}
		}
		panel_1.add(rdbtnSi);
		grupo.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(123, 21, 41, 23);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			if(!((Jugador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnNo.setSelected(true);
			}
		}
		else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			if(!((Lanzador)Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado()){
				rdbtnNo.setSelected(true);
			}
		}
		panel_1.add(rdbtnNo);
		grupo.add(rdbtnNo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarPeloteroD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(468, 303, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = Validaciones.ultimoEspacio(txtNombre);
				String apellido = Validaciones.ultimoEspacio(txtApellido);
				String id = txtID.getText();
				String posicion = (String) comboBox.getSelectedItem();
				int aniosEq = (Integer) spinner.getValue();
				int dorsal = (Integer) spinner_2.getValue();
				int hits = (Integer) spinner_3.getValue();
				int homeR = (Integer) spinner_4.getValue();
				int errores = (Integer) spinner_5.getValue();
				int entradasL = (Integer) spinner_6.getValue();
				int carrerasP = (Integer) spinner_7.getValue();
				int vecesAB = (Integer) spinner_8.getValue();
				boolean lesionado;

				if(rdbtnSi.isSelected()){
					lesionado = true;
				}
				else{
					lesionado = false;
				}

				if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
					if(entradasL == 0 && carrerasP != 0){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Si el número de entradas lanzadas en cero, entonces\nno puede haber carreras permitidas.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if((carrerasP > AgregarPartidoD.carrerasVsHC && a == 1) || (carrerasP > AgregarPartidoD.carrerasVsV && a == 0)){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de carreras permitidas no puede ser mayor a la\ncantidad de carreras en contra del equipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(Serie.getInstance().getEquipos().get(e).modificarLanzador(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getEntradasLanzadas(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getCarrerasPermitidas(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado(), nombre, apellido, dorsal, id, aniosEq, entradasL + ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getEntradasLanzadas(), carrerasP + ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getCarrerasPermitidas(), errores + ((Lanzador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), lesionado)){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Pelotero modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
						if(a == 1){
							AgregarPartidoD.carrerasVsHC -= carrerasP;
						}
						else{
							AgregarPartidoD.carrerasVsV -= carrerasP;
						}
						hide();
					}
					else{
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "No ha sido modificado ningún aspecto de este pelotero.", "AVISO", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
					if(hits > vecesAB){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de veces al bate no pueden ser menor a la cantidad de hits.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(homeR > vecesAB){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de veces al bate no pueden ser menor a la cantidad de home runs.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(homeR > hits){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de home runs no pueden ser mayor a la cantidad de hits.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if((homeR > AgregarPartidoD.carrerasHC && a == 1) || (homeR > AgregarPartidoD.carrerasV && a == 0)){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de home runs no pueden ser mayor a la cantidad\nde carreras del equipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if((vecesAB < AgregarPartidoD.carrerasHC && a == 1) || (vecesAB < AgregarPartidoD.carrerasV && a == 0)){
						JOptionPane.showMessageDialog(ModificarPeloteroD.this, "La cantidad de veces al bate no pueden ser menor a la cantidad\nde carreras del equipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(Serie.getInstance().getEquipos().get(e).modificarJugador(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNombre(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getApellido(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getNumero(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getPosicion(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getId(), Serie.getInstance().getEquipos().get(e).getPeloteros().get(x).getAniosEnEquipo(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getVecesAlBate(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHits(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHomeRuns(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).isLesionado(), nombre, apellido, dorsal, posicion, id, aniosEq, vecesAB + ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getVecesAlBate(), hits + ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHits(), homeR + ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getHomeRuns(), errores + ((Jugador) Serie.getInstance().getEquipos().get(e).getPeloteros().get(x)).getErrores(), lesionado)){
							JOptionPane.showMessageDialog(ModificarPeloteroD.this, "Pelotero modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
							if(a == 1){
								AgregarPartidoD.carrerasHC -= homeR;
							}
							else{
								AgregarPartidoD.carrerasV -= homeR;
							}
							hide();
						}
						else{
							JOptionPane.showMessageDialog(ModificarPeloteroD.this, "No ha sido modificado ningún aspecto de este pelotero.", "AVISO", JOptionPane.WARNING_MESSAGE);
						}
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(369, 303, 89, 23);
		contentPane.add(btnAceptar);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos Estad\u00EDsticos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 181, 367, 111);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblHits = new JLabel("Hits:");
		lblHits.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHits.setBounds(10, 24, 24, 15);
		panel_2.add(lblHits);

		lblHomeRuns = new JLabel("Home runs:");
		lblHomeRuns.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHomeRuns.setBounds(10, 49, 63, 15);
		panel_2.add(lblHomeRuns);

		lblErrores = new JLabel("Errores:");
		lblErrores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrores.setBounds(191, 78, 42, 15);
		panel_2.add(lblErrores);

		spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_3.setBounds(44, 22, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_3.setEnabled(true);
		}
		panel_2.add(spinner_3);

		spinner_4 = new JSpinner();
		spinner_4.setEnabled(false);
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_4.setBounds(83, 47, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_4.setEnabled(true);
		}
		panel_2.add(spinner_4);

		spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_5.setBounds(243, 75, 47, 20);
		panel_2.add(spinner_5);

		lblEntradasLanzadas = new JLabel("Entradas lanzadas:");
		lblEntradasLanzadas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEntradasLanzadas.setBounds(191, 25, 99, 15);
		panel_2.add(lblEntradasLanzadas);

		lblCarrerasPermitidas = new JLabel("Carreras permitidas:");
		lblCarrerasPermitidas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarrerasPermitidas.setBounds(191, 50, 106, 15);
		panel_2.add(lblCarrerasPermitidas);

		spinner_6 = new JSpinner();
		spinner_6.setEnabled(false);
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spinner_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_6.setBounds(300, 22, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_6.setEnabled(true);
		}
		panel_2.add(spinner_6);

		spinner_7 = new JSpinner();
		spinner_7.setEnabled(false);
		spinner_7.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		spinner_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_7.setBounds(307, 47, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Lanzador){
			spinner_7.setEnabled(true);
		}
		panel_2.add(spinner_7);

		lblVecesAlBate = new JLabel("Veces al bate:");
		lblVecesAlBate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVecesAlBate.setBounds(10, 75, 78, 15);
		panel_2.add(lblVecesAlBate);

		spinner_8 = new JSpinner();
		spinner_8.setEnabled(false);
		spinner_8.setModel(new SpinnerNumberModel(0, 0, 500, 1));
		spinner_8.setBounds(98, 76, 47, 20);
		if(Serie.getInstance().getEquipos().get(e).getPeloteros().get(x) instanceof Jugador){
			spinner_8.setEnabled(true);
		}
		panel_2.add(spinner_8);
	}
}
