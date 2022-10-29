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

import logica.Equipo;
import logica.Serie;
import extras.Validaciones;

public class ModificarEquipoD extends JDialog {

	private JPanel contentPane;
	private JLabel lblModificarEquipo;
	private JPanel panel;
	private JLabel lblNombre;
	private JLabel lblProvincia;
	private JLabel lblMascota;
	private JLabel lblColor;
	private JLabel lblCantidadDeCampeonatos;
	private JLabel lblCantidadDeCampeonatos_1;
	private JTextField txtNombreEquipo;
	private JTextField txtMascota;
	private JTextField txtColor;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JComboBox<String> comboBox;
	private JPanel panel_1;
	private JLabel lblNombreDelDirector;
	private JLabel lblPrimerApellidoDel;
	private JTextField txtNombreDirector;
	private JTextField txtApellido;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarEquipoD dialog = new ModificarEquipoD(new MostrarEquiposD(new PantallaPrincipal(new Login(), 1), 1), Serie.getInstance().getEquipos().get(2));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarEquipoD(final MostrarEquiposD anterior, final Equipo e) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarEquipoD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEquipoD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 465, 395);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModificarEquipo = new JLabel("Modificar Equipo:");
		lblModificarEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModificarEquipo.setBounds(10, 11, 106, 15);
		contentPane.add(lblModificarEquipo);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 37, 429, 184);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 24, 47, 15);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(10, 50, 51, 15);
		panel.add(lblProvincia);
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblMascota = new JLabel("Mascota:");
		lblMascota.setBounds(10, 76, 48, 15);
		panel.add(lblMascota);
		lblMascota.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 102, 31, 15);
		panel.add(lblColor);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblCantidadDeCampeonatos = new JLabel("Cantidad de campeonatos en los que ha participado el equipo:");
		lblCantidadDeCampeonatos.setBounds(10, 128, 341, 15);
		panel.add(lblCantidadDeCampeonatos);
		lblCantidadDeCampeonatos.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblCantidadDeCampeonatos_1 = new JLabel("Cantidad de campeonatos que ha ganado el equipo:");
		lblCantidadDeCampeonatos_1.setBounds(10, 154, 286, 15);
		panel.add(lblCantidadDeCampeonatos_1);
		lblCantidadDeCampeonatos_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombreEquipo = new JTextField(e.getNombre());
		txtNombreEquipo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtNombreEquipo, arg0);
			}
		});
		txtNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombreEquipo.setBounds(67, 22, 120, 20);
		panel.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);

		txtMascota = new JTextField(e.getMascota());
		txtMascota.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtMascota, arg0);
			}
		});
		txtMascota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMascota.setBounds(68, 74, 120, 20);
		panel.add(txtMascota);
		txtMascota.setColumns(10);

		txtColor = new JTextField(e.getColor());
		txtColor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtColor, arg0);
			}
		});
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setBounds(51, 100, 120, 20);
		panel.add(txtColor);
		txtColor.setColumns(10);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(361, 126, 47, 20);
		spinner.setValue(e.getCampeonatosParticipados());
		panel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner_1.setBounds(304, 152, 47, 20);
		spinner_1.setValue(e.getCampeonatosGanados());
		panel.add(spinner_1);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Pinar del R\u00EDo", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Villa Clara", "Cienfuegos", "Sancti Spiritus", "Ciego de \u00C1vila", "Camag\u00FCey", "Las Tunas", "Holgu\u00EDn", "Granma", "Santiago de Cuba", "Guant\u00E1namo", "Isla de la Juventud"}));
		comboBox.setBounds(71, 48, 120, 20);
		comboBox.setSelectedItem(e.getProvincia());
		panel.add(comboBox);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Director", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 232, 429, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNombreDelDirector = new JLabel("Nombre:");
		lblNombreDelDirector.setBounds(10, 24, 47, 15);
		panel_1.add(lblNombreDelDirector);
		lblNombreDelDirector.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblPrimerApellidoDel = new JLabel("Primer apellido:");
		lblPrimerApellidoDel.setBounds(10, 50, 82, 15);
		panel_1.add(lblPrimerApellidoDel);
		lblPrimerApellidoDel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombreDirector = new JTextField(e.getNombreDirector());
		txtNombreDirector.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtNombreDirector, arg0);
			}
		});
		txtNombreDirector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombreDirector.setBounds(67, 22, 120, 20);
		panel_1.add(txtNombreDirector);
		txtNombreDirector.setColumns(10);

		txtApellido = new JTextField(e.getApellido());
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.texto(txtApellido, arg0);
			}
		});
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtApellido.setBounds(101, 48, 120, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarEquipoD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(350, 322, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreE = Validaciones.ultimoEspacio(txtNombreEquipo);
				String provincia = (String) comboBox.getSelectedItem();
				String mascota = Validaciones.ultimoEspacio(txtMascota);
				String color = Validaciones.ultimoEspacio(txtColor);
				int cp = (Integer) spinner.getValue();
				int cg = (Integer) spinner_1.getValue();
				String nombreD = Validaciones.ultimoEspacio(txtNombreDirector);
				String apellido = Validaciones.ultimoEspacio(txtApellido);

				if(!(txtNombreEquipo.getText().isEmpty() || txtMascota.getText().isEmpty() || txtColor.getText().isEmpty() || txtNombreDirector.getText().isEmpty() || txtApellido.getText().isEmpty())){
					if(cp >= cg){
						if(Serie.getInstance().buscarEquipo(nombreE) != null && !nombreE.equalsIgnoreCase(e.getNombre())){
							JOptionPane.showMessageDialog(ModificarEquipoD.this, String.format("Ya existe un equipo con el nombre: \"%s\"", nombreE), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							if(Serie.getInstance().modificarEquipo(e.getNombre(), provincia, cp, cg, mascota, color, nombreD, apellido, nombreE)){
								JOptionPane.showMessageDialog(ModificarEquipoD.this, "Equipo modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
								hide();
							}
							else{
								JOptionPane.showMessageDialog(ModificarEquipoD.this, "No ha sido modificado ningún aspecto de este equipo.", "AVISO", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(ModificarEquipoD.this, "La cantidad de campeonatos participados no puede ser\nmenor que la cantidad de campeonatos ganados.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(ModificarEquipoD.this, "Existen campos sin rellenar.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(251, 322, 89, 23);
		contentPane.add(btnAceptar);
	}

}
