package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;

import logica.Serie;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarEquipoD extends JDialog {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SeleccionarEquipoD dialog = new SeleccionarEquipoD(new PantallaPrincipal(new Login(), 1), 1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel contentPane;
	private JLabel lblSeleccioneElEquipo;
	private JLabel lblEquipo;
	private JComboBox<String> comboBox;

	/**
	 * Create the dialog.
	 */
	public SeleccionarEquipoD(final PantallaPrincipal anterior, final int perfil) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 368, 145);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSeleccioneElEquipo = new JLabel("Seleccione el equipo del cual desea mostrar los peloteros");
		lblSeleccioneElEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneElEquipo.setBounds(10, 11, 311, 15);
		contentPane.add(lblSeleccioneElEquipo);
		
		lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipo.setBounds(10, 37, 41, 15);
		contentPane.add(lblEquipo);
		
		comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(2);
		String [] eq = new String [Serie.getInstance().getEquipos().size()];
		for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
			eq[i] = Serie.getInstance().getEquipos().get(i).getNombre();
		}
		comboBox.setModel(new DefaultComboBoxModel<String>(eq));
		comboBox.setBounds(61, 35, 146, 20);
		contentPane.add(comboBox);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(253, 73, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarPeloterosD mp = new MostrarPeloterosD(anterior, perfil, comboBox.getSelectedIndex());
				hide();
				mp.setVisible(true);
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(154, 74, 89, 23);
		contentPane.add(btnAceptar);
		
	}
}
