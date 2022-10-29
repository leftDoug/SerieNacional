package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Entrenador;
import logica.Jugador;
import logica.Lanzador;
import logica.Serie;
import extras.Validaciones;

public class AgregarJugadorD extends JDialog {

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
	private JLabel lblPrimerApellidoDel;
	private JTextField txtApellido;
	private JSpinner spinner_2;
	private JPanel panel_1;
	private JLabel lblLesionado;
	private ButtonGroup grupo;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarJugadorD dialog = new AgregarJugadorD(new MostrarPeloterosD(new PantallaPrincipal(new Login(), 1), 1, 0), 1, 0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarJugadorD(final MostrarPeloterosD anterior, final int tipo, final int e) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarJugadorD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEquipoD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 585, 291);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModificarPelotero = new JLabel("Agregar Pelotero:");
		lblModificarPelotero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModificarPelotero.setBounds(10, 11, 109, 15);
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
		if(tipo == 0){
			lblPosicion.setVisible(false);
			lblPosicion.setEnabled(false);
		}
		panel.add(lblPosicion);
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
		lblAniosExp.setBounds(10, 102, 181, 15);
		panel.add(lblAniosExp);
		if(tipo == 1){
			lblAniosExp.setVisible(false);
			lblAniosExp.setEnabled(false);
		}
		lblAniosExp.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtNombre, arg0);
			}
		});
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(67, 22, 120, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtID = new JTextField();
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
		panel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setBounds(201, 99, 47, 20);
		if(tipo == 1){
			spinner_1.setVisible(false);
			spinner_1.setEnabled(false);
		}
		panel.add(spinner_1);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primera Base", "Segunda Base", "Tercera Base", "Receptor", "Lanzador", "Campocorto", "Jard\u00EDn Izquierdo", "Jard\u00EDn Central", "Jard\u00EDn Derecho"}));
		comboBox.setBounds(344, 74, 120, 20);
		if(tipo == 0){
			comboBox.setVisible(false);
			comboBox.setEnabled(false);
		}
		panel.add(comboBox);

		lblPrimerApellidoDel = new JLabel("Primer apellido:");
		lblPrimerApellidoDel.setBounds(283, 24, 82, 15);
		panel.add(lblPrimerApellidoDel);
		lblPrimerApellidoDel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtApellido = new JTextField();
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
		panel.add(spinner_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Lesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 181, 170, 51);
		if(tipo == 0){
			panel_1.setVisible(false);
			panel_1.setEnabled(false);
		}
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblLesionado = new JLabel("Lesionado:");
		lblLesionado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLesionado.setBounds(10, 24, 58, 15);
		if(tipo == 0){
			lblLesionado.setVisible(false);
			lblLesionado.setEnabled(false);
		}
		panel_1.add(lblLesionado);

		grupo = new ButtonGroup();

		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSi.setBounds(74, 21, 35, 23);
		if(tipo == 0){
			rdbtnSi.setVisible(false);
			rdbtnSi.setEnabled(false);
		}
		panel_1.add(rdbtnSi);
		grupo.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNo.setBounds(123, 21, 41, 23);
		rdbtnNo.setSelected(true);
		if(tipo == 0){
			rdbtnNo.setVisible(false);
			rdbtnNo.setEnabled(false);
		}
		panel_1.add(rdbtnNo);
		grupo.add(rdbtnNo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarJugadorD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(468, 209, 89, 23);
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
				boolean lesionado;

				if(rdbtnSi.isSelected()){
					lesionado = true;
				}
				else{
					lesionado = false;
				}

				if(!(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty())){
					if(tipo == 0){
						if(aniosExp >= aniosEq){
							if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null){
								JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
							}
							else if(id.length() == 11){
								if(Serie.getInstance().getEquipos().get(e).buscarPelotero(id) != null){
									JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el carnet de identidad:\n\"%s\"", id), "ERROR", JOptionPane.ERROR_MESSAGE);
									txtID.setText("");
								}
								else{
									if(Serie.getInstance().getEquipos().get(e).agregarEntrenador(nombre, apellido, id, dorsal, aniosEq, aniosExp)){
										JOptionPane.showMessageDialog(AgregarJugadorD.this, "Pelotero agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
										txtNombre.setText("");
										txtApellido.setText("");
										txtID.setText("");
										comboBox.setSelectedIndex(0);
										spinner.setValue(0);
										spinner_1.setValue(0);
										spinner_2.setValue(0);
										hide();
									}
								}
							}
							else{
								JOptionPane.showMessageDialog(AgregarJugadorD.this, "El carnet de identidad debe tener 11 dígitos", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(AgregarJugadorD.this, "La cantidad de años de experiencia no puede ser\nmenor que la cantidad de años en el equipo.", "ERROR", JOptionPane.ERROR_MESSAGE);
							spinner.setValue(0);
							spinner_1.setValue(0);
						}
					}
					else if(posicion.equals("Lanzador")){
						if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null){
							JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else if(id.length() == 11){
							if(Serie.getInstance().getEquipos().get(e).buscarPelotero(id) != null){
								JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el carnet de identidad:\n\"%s\"", id), "ERROR", JOptionPane.ERROR_MESSAGE);
								txtID.setText("");
							}
							else{
								if(Serie.getInstance().getEquipos().get(e).agregarLanzador(nombre, apellido, id, dorsal, aniosEq, lesionado)){
									JOptionPane.showMessageDialog(AgregarJugadorD.this, "Pelotero agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
									txtNombre.setText("");
									txtApellido.setText("");
									txtID.setText("");
									comboBox.setSelectedIndex(0);
									spinner.setValue(0);
									spinner_1.setValue(0);
									spinner_2.setValue(0);
									hide();
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(AgregarJugadorD.this, "El carnet de identidad debe tener 11 dígitos", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						if(Serie.getInstance().getEquipos().get(e).buscarPelotero(dorsal) != null){
							JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el dorsal: \"%d\"", dorsal), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else if(id.length() == 11){
							if(Serie.getInstance().getEquipos().get(e).buscarPelotero(id) != null){
								JOptionPane.showMessageDialog(AgregarJugadorD.this, String.format("Ya existe un pelotero con el carnet de identidad:\n\"%s\"", id), "ERROR", JOptionPane.ERROR_MESSAGE);
								txtID.setText("");
							}
							else{
								if(Serie.getInstance().getEquipos().get(e).agregarJugador(nombre, apellido, id, dorsal, aniosEq, posicion, lesionado)){
									JOptionPane.showMessageDialog(AgregarJugadorD.this, "Pelotero agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
									txtNombre.setText("");
									txtApellido.setText("");
									txtID.setText("");
									comboBox.setSelectedIndex(0);
									spinner.setValue(0);
									spinner_1.setValue(0);
									spinner_2.setValue(0);
									hide();
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(AgregarJugadorD.this, "El carnet de identidad debe tener 11 dígitos", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
					else{
						JOptionPane.showMessageDialog(AgregarJugadorD.this, "Existen campos sin rellenar.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(369, 209, 89, 23);
		contentPane.add(btnAceptar);
		}

	}
