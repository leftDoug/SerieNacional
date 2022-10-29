package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.HistoricosFinales;
import logica.Serie;

public class SeleccionarSerieD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblSeleccioneElEquipo;
	private JLabel lblEquipo;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SeleccionarSerieD dialog = new SeleccionarSerieD(new PantallaPrincipal(new Login(), 1));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SeleccionarSerieD(final PantallaPrincipal anterior) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 368, 145);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSeleccioneElEquipo = new JLabel("Seleccione la serie de la cual desea ver los hist\u00F3ridos:");
		lblSeleccioneElEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneElEquipo.setBounds(10, 11, 288, 15);
		contentPane.add(lblSeleccioneElEquipo);
		
		lblEquipo = new JLabel("Serie:");
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipo.setBounds(10, 37, 31, 15);
		contentPane.add(lblEquipo);
		
		comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(2);
		String [] ser = new String [HistoricosFinales.getInstance().getSeries().size()];
		for(int i = 0; i < HistoricosFinales.getInstance().getSeries().size(); i++){
			ser[i] = String.format("Serie %d", 53 + i);
		}
		comboBox.setModel(new DefaultComboBoxModel<String>(ser));
		comboBox.setBounds(51, 37, 146, 20);
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
				MostrarHistoricosFinalesD mhf = new MostrarHistoricosFinalesD(anterior, comboBox.getSelectedIndex());
				hide();
				mhf.setVisible(true);
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(154, 74, 89, 23);
		contentPane.add(btnAceptar);
		
	}

}
