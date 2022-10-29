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

import logica.Estadio;
import logica.Serie;
import extras.Validaciones;

public class ModificarEstadioD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblAgregarEquipo;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblCapacidad;
	private JSpinner spinner;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblProvincia;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarEstadioD dialog = new ModificarEstadioD(new MostrarEstadiosD(new PantallaPrincipal(new Login(), 1), 1), Serie.getInstance().getEstadios().get(0));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarEstadioD(final MostrarEstadiosD anterior, final Estadio e) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarEstadioD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEstadioD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 477, 182);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgregarEquipo = new JLabel("Agregar Estadio:");
		lblAgregarEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgregarEquipo.setBounds(10, 11, 102, 15);
		contentPane.add(lblAgregarEquipo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarEstadioD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(358, 106, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = Validaciones.ultimoEspacio(txtNombre);
				String provincia = (String) comboBox.getSelectedItem();
				int capacidad = (Integer) spinner.getValue();

				if(!txtNombre.getText().isEmpty()){
					if(Serie.getInstance().buscarEstadio(nombre, provincia) != null && !Serie.getInstance().buscarEstadio(nombre, provincia).equals(e)){
						JOptionPane.showMessageDialog(ModificarEstadioD.this, String.format("Ya existe un estadio con el nombre: \"%s\" en %s", nombre, provincia), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else{
						if(Serie.getInstance().modificarEstadio(e, nombre, provincia, capacidad)){
							JOptionPane.showMessageDialog(ModificarEstadioD.this, "Estadio modificado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
							hide();
						}
						else{
							JOptionPane.showMessageDialog(ModificarEstadioD.this, "No ha sido modificado ningún aspecto de este equipo.", "AVISO", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(ModificarEstadioD.this, "Existen campos sin rellenar.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(257, 106, 89, 23);
		contentPane.add(btnAceptar);

		lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(10, 67, 58, 15);
		contentPane.add(lblCapacidad);
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		spinner = new JSpinner();
		spinner.setBounds(79, 64, 71, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(1000, 1000, 50000, 100));
		spinner.setValue(e.getCapacidad());
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 39, 47, 15);
		contentPane.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNombre = new JTextField(e.getNombre());
		txtNombre.setBounds(69, 36, 139, 20);
		contentPane.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				Validaciones.textoConNum(txtNombre, arg0);
			}
		});
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setColumns(10);

		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(264, 39, 51, 15);
		contentPane.add(lblProvincia);
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		comboBox = new JComboBox<String>();
		comboBox.setBounds(327, 36, 120, 20);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pinar del R\u00EDo", "Artemisa", "La Habana", "Mayabeque", "Matanzas", "Villa Clara", "Cienfuegos", "Sancti Spiritus", "Ciego de \u00C1vila", "Camag\u00FCey", "Las Tunas", "Holgu\u00EDn", "Granma", "Santiago de Cuba", "Guant\u00E1namo", "Isla de la Juventud"}));
		comboBox.setSelectedItem(e.getProvincia());
	}

}
