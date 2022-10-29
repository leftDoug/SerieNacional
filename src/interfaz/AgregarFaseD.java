package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JTextField;

import logica.Serie;

import com.toedter.calendar.JDateChooser;

import extras.Validaciones;

import com.toedter.calendar.JCalendar;

public class AgregarFaseD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblAgregarFase;
	private JLabel lblNombre;
	private JLabel lblFechaDeInicio;
	private JLabel lblFechaDeFin;
	private JCalendar calendar;
	private JCalendar calendar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarFaseD dialog = new AgregarFaseD(new MostrarFasesD(new PantallaPrincipal(new Login(), 1), 1));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarFaseD(final MostrarFasesD anterior) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarFaseD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
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

		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		if(Serie.getInstance().getFases().size() == 0){
			txtNombre.setText("Primera Ronda");
		}
		if(Serie.getInstance().getFases().size() == 1){
			txtNombre.setText("Segunda Ronda");
		}
		if(Serie.getInstance().getFases().size() == 2){
			txtNombre.setText("Play Off");
		}
		if(Serie.getInstance().getFases().size() == 3){
			txtNombre.setText("Final");
		}
		txtNombre.setBounds(67, 35, 126, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarFaseD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
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

				if(fechaI.getDate() != fechaF.getDate() || fechaI.getMonth() != fechaF.getMonth() || fechaI.getYear() != fechaF.getYear()){
					if(!fechaI.before(fechaF)){
						JOptionPane.showMessageDialog(AgregarFaseD.this, "La fecha de inicio debe ser anterior a la fecha de fin.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(Serie.getInstance().getFases().size() > 0){
						if((!fechaI.after(Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin()) || (fechaI.getDate() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getDate() && fechaI.getMonth() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getMonth() && fechaI.getYear() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getYear()))){
							JOptionPane.showMessageDialog(AgregarFaseD.this, String.format("La fecha de inicio debe ser posterior a la fecha de fin de la fase \"%s\".", Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else{
							Serie.getInstance().agregarFase(nombre, fechaI, fechaF);
							JOptionPane.showMessageDialog(AgregarFaseD.this, "Fase agregada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
							hide();
						}
					}
					else{
						Serie.getInstance().agregarFase(nombre, fechaI, fechaF);
						JOptionPane.showMessageDialog(AgregarFaseD.this, "Fase agregada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
						hide();
					}
				}
				else if(Serie.getInstance().getFases().size() > 0){
					if((!fechaI.after(Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin()) || (fechaI.getDate() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getDate() && fechaI.getMonth() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getMonth() && fechaI.getYear() == Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getFechaFin().getYear()))){
						JOptionPane.showMessageDialog(AgregarFaseD.this, String.format("La fecha de inicio debe ser posterior a la fecha de fin de la fase \"%s\".", Serie.getInstance().getFases().get(Serie.getInstance().getFases().size() - 1).getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else{
						Serie.getInstance().agregarFase(nombre, fechaI, fechaF);
						JOptionPane.showMessageDialog(AgregarFaseD.this, "Fase agregada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
						hide();
					}
				}
				else{
					Serie.getInstance().agregarFase(nombre, fechaI, fechaF);
					JOptionPane.showMessageDialog(AgregarFaseD.this, "Fase agregada correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					hide();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(400, 225, 89, 23);
		contentPane.add(btnAceptar);

		calendar = new JCalendar();
		calendar.setBounds(104, 61, 184, 153);
		contentPane.add(calendar);

		calendar_1 = new JCalendar();
		calendar_1.setBounds(404, 61, 184, 153);
		contentPane.add(calendar_1);
	}
}
