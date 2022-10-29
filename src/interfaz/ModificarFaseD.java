package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Fase;
import logica.Serie;

import com.toedter.calendar.JCalendar;

public class ModificarFaseD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblAgregarFase;
	private JLabel lblNombre;
	private JLabel lblFechaDeInicio;
	private JLabel lblFechaDeFin;
	private JTextField txtNombre;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JCalendar calendar;
	private JCalendar calendar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarFaseD dialog = new ModificarFaseD(new MostrarFasesD(new PantallaPrincipal(new Login(), 1), 1), 0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarFaseD(final MostrarFasesD anterior, final int x) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarFaseD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarEquipoD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 615, 296);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgregarFase = new JLabel("Agregar Fase:");
		lblAgregarFase.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgregarFase.setBounds(10, 11, 83, 15);
		contentPane.add(lblAgregarFase);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 37, 47, 15);
		contentPane.add(lblNombre);

		lblFechaDeInicio = new JLabel("Fecha de inicio:");
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeInicio.setBounds(10, 63, 84, 15);
		contentPane.add(lblFechaDeInicio);

		lblFechaDeFin = new JLabel("Fecha de fin:");
		lblFechaDeFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeFin.setBounds(323, 63, 71, 15);
		contentPane.add(lblFechaDeFin);

		txtNombre = new JTextField(Serie.getInstance().getFases().get(x).getNombre());
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(67, 35, 126, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(ModificarFaseD.this, "Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(499, 225, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				Date fechaI = calendar.getDate();
				fechaI.setHours(0);
				fechaI.setMinutes(0);
				fechaI.setSeconds(0);
				Date fechaF = calendar_1.getDate();
				fechaF.setHours(0);
				fechaF.setMinutes(0);
				fechaF.setSeconds(0);

				if(fechaI.getDate() != fechaF.getDate() && fechaI.getMonth() != fechaF.getMonth() && fechaI.getYear() != fechaF.getYear()){
					if(!fechaI.before(fechaF)){
						JOptionPane.showMessageDialog(ModificarFaseD.this, "La fecha de inicio debe ser anterior a la fecha de fin.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(x != 0){
					if(x != 3){
						if(!(fechaF.before(Serie.getInstance().getFases().get(x + 1).getFechaInicio())) || (Serie.getInstance().getFases().get(x + 1).getFechaInicio().getDate() == fechaF.getDate() && Serie.getInstance().getFases().get(x + 1).getFechaInicio().getMonth() == fechaF.getMonth() && Serie.getInstance().getFases().get(x + 1).getFechaInicio().getYear() != fechaF.getYear())){
							JOptionPane.showMessageDialog(ModificarFaseD.this, String.format("La fecha de fin debe ser anterior a la fecha de inicio de la fase \"%s\".", Serie.getInstance().getFases().get(x + 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else if(!(fechaI.after(Serie.getInstance().getFases().get(x - 1).getFechaFin())) || (fechaI.getDate() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getDate() && fechaI.getMonth() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getMonth() && fechaI.getYear() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getYear())){
							JOptionPane.showMessageDialog(ModificarFaseD.this, String.format("La fecha de inicio debe ser posterior a la fecha de fin de la fase \"%s\".", Serie.getInstance().getFases().get(x - 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							Serie.getInstance().modificarFase(Serie.getInstance().getFases().get(x), fechaI, fechaF);
							JOptionPane.showMessageDialog(ModificarFaseD.this, "Fase modificada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
							hide();
						}
					}
					if(!(fechaI.after(Serie.getInstance().getFases().get(x - 1).getFechaFin())) || (fechaI.getDate() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getDate() && fechaI.getMonth() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getMonth() && fechaI.getYear() == Serie.getInstance().getFases().get(x - 1).getFechaFin().getYear())){
						JOptionPane.showMessageDialog(ModificarFaseD.this, String.format("La fecha de inicio debe ser posterior a la fecha de fin de la fase \"%s\".", Serie.getInstance().getFases().get(x - 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else{
						Serie.getInstance().modificarFase(Serie.getInstance().getFases().get(x), fechaI, fechaF);
						JOptionPane.showMessageDialog(ModificarFaseD.this, "Fase modificada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
						hide();
					}
				}
				else if(!(fechaF.before(Serie.getInstance().getFases().get(x + 1).getFechaInicio())) || (Serie.getInstance().getFases().get(x + 1).getFechaInicio().getDate() == fechaF.getDate() && Serie.getInstance().getFases().get(x + 1).getFechaInicio().getMonth() == fechaF.getMonth() && Serie.getInstance().getFases().get(x + 1).getFechaInicio().getYear() != fechaF.getYear())){
					JOptionPane.showMessageDialog(ModificarFaseD.this, String.format("La fecha de fin debe ser anterior a la fecha de inicio de la fase \"%s\".", Serie.getInstance().getFases().get(x + 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Serie.getInstance().modificarFase(Serie.getInstance().getFases().get(x), fechaI, fechaF);
					JOptionPane.showMessageDialog(ModificarFaseD.this, "Fase modificada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					hide();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(400, 225, 89, 23);
		contentPane.add(btnAceptar);

		calendar = new JCalendar();
		calendar.setDate(Serie.getInstance().getFases().get(x).getFechaInicio());
		calendar.setBounds(104, 61, 184, 153);
		contentPane.add(calendar);

		calendar_1 = new JCalendar();
		calendar_1.setDate(Serie.getInstance().getFases().get(x).getFechaFin());
		calendar_1.setBounds(404, 61, 184, 153);
		contentPane.add(calendar_1);
	}

}
