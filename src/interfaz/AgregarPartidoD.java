package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import logica.Equipo;
import logica.Estadio;
import logica.Serie;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AgregarPartidoD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JButton btnAceptar;
	private JCalendar calendar;
	private JButton btnCancelar;
	private JLabel lblAgregarPartido;
	private JLabel lblHomeClub;
	private JComboBox<String> comboBox;
	private JLabel lblCarrerasDelHome;
	private JSpinner spinner;
	private JLabel lblEstadio;
	private JComboBox<String> comboBox_2;
	private JLabel lblFase;
	private JLabel lblVisitante;
	private JComboBox<String> comboBox_1;
	private JLabel lblCarrerasDelVisitante;
	private JSpinner spinner_1;
	private JLabel lblAudiencia;
	private JSpinner spinner_2;
	private JLabel lblFecha;
	private JComboBox<String> comboBox_3;
	public static int carrerasVsHC;
	public static int carrerasHC;
	public static int carrerasVsV;
	public static int carrerasV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarPartidoD dialog = new AgregarPartidoD(new MostrarPartidosD(new PantallaPrincipal(new Login(), 1), 1));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarPartidoD(final MostrarPartidosD anterior) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarPartidoD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					hide();
				}
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 746, 246);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgregarPartido = new JLabel("Agregar Partido:");
		lblAgregarPartido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAgregarPartido.setBounds(10, 11, 102, 15);
		contentPane.add(lblAgregarPartido);

		lblHomeClub = new JLabel("Home club:");
		lblHomeClub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHomeClub.setBounds(10, 37, 62, 15);
		contentPane.add(lblHomeClub);

		lblVisitante = new JLabel("Visitante:");
		lblVisitante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVisitante.setBounds(10, 63, 51, 15);
		contentPane.add(lblVisitante);

		lblCarrerasDelHome = new JLabel("Carreras del home club:");
		lblCarrerasDelHome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarrerasDelHome.setBounds(264, 37, 128, 15);
		contentPane.add(lblCarrerasDelHome);

		lblCarrerasDelVisitante = new JLabel("Carreras del visitante:");
		lblCarrerasDelVisitante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCarrerasDelVisitante.setBounds(264, 63, 116, 15);
		contentPane.add(lblCarrerasDelVisitante);

		lblEstadio = new JLabel("Estadio:");
		lblEstadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadio.setBounds(10, 89, 43, 15);
		contentPane.add(lblEstadio);

		lblAudiencia = new JLabel("Audiencia:");
		lblAudiencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAudiencia.setBounds(264, 89, 56, 15);
		contentPane.add(lblAudiencia);

		lblFase = new JLabel("Fase:");
		lblFase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFase.setBounds(10, 115, 28, 15);
		contentPane.add(lblFase);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(483, 11, 36, 15);
		contentPane.add(lblFecha);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(AgregarPartidoD.this, "¿Desea cancelar esta acción?", "Cancelar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
					hide();
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(631, 173, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipo hc = Serie.getInstance().tablaPosiciones().get(comboBox.getSelectedIndex());
				Equipo v = Serie.getInstance().tablaPosiciones().get(comboBox_1.getSelectedIndex());
				Date fecha = calendar.getDate();
				Estadio e = Serie.getInstance().getEstadios().get(comboBox_2.getSelectedIndex());
				int cHC = (Integer) spinner.getValue();
				int cV = (Integer) spinner_1.getValue();
				int audiencia = (Integer) spinner_2.getValue();
				String fase = (String) comboBox_3.getSelectedItem();

				if((fecha.getDate() != Serie.getInstance().buscarFase(fase).getFechaFin().getDate() || fecha.getMonth() != Serie.getInstance().buscarFase(fase).getFechaFin().getMonth() || fecha.getYear() != Serie.getInstance().buscarFase(fase).getFechaFin().getYear()) || (fecha.getDate() != Serie.getInstance().buscarFase(fase).getFechaInicio().getDate() || fecha.getMonth() != Serie.getInstance().buscarFase(fase).getFechaInicio().getMonth() || fecha.getYear() != Serie.getInstance().buscarFase(fase).getFechaInicio().getYear())){
					if(!(fecha.before(Serie.getInstance().buscarFase(fase).getFechaFin()))){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, "La fecha del partido debe ser anterior a la fecha de fin de la fase.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(!(fecha.after(Serie.getInstance().buscarFase(fase).getFechaInicio()))){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, "La fecha del partido debe ser posterior a la fecha de inicio de la fase.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(fase.equals("Segunda Ronda") && comboBox.getSelectedIndex() > 7){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(fase.equals("Play Off") && comboBox.getSelectedIndex() > 3){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(fase.equals("Final") && comboBox.getSelectedIndex() > 1){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(hc.equals(v)){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, "El home club debe ser distinto del visitante", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if(audiencia > e.getCapacidad()){
						JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El estadio\"%s\" no posee capacidad para esta cantidad de expectadores.", e.getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else{
						carrerasHC = cHC;
						carrerasVsHC = cV;
						carrerasV = cV;
						carrerasVsV = cHC;
						MostrarPeloterosD mpHC = new MostrarPeloterosD(AgregarPartidoD.this, 1, comboBox.getSelectedIndex(), 1);
						mpHC.setVisible(true);
						if(carrerasVsHC == 0){
							MostrarPeloterosD mpV = new MostrarPeloterosD(AgregarPartidoD.this, 1, comboBox_1.getSelectedIndex(), 0);
							mpV.setVisible(true);
							if(carrerasVsV == 0){
								Serie.getInstance().buscarFase(fase).agregarPartido(v, hc, fecha, e, cV, cHC, audiencia);
								JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
								hide();
							}
							else{
								JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido no agregado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido no agregado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
						}
						hide();
					}
				}
				else if(fase.equals("Segunda Ronda") && comboBox.getSelectedIndex() > 7){
					JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(fase.equals("Play Off") && comboBox.getSelectedIndex() > 3){
					JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(fase.equals("Final") && comboBox.getSelectedIndex() > 1){
					JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El equipo \"%s\" no está en las posiciones necesarias\npara competir en la fase \"%s\".", hc.getNombre(), fase), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(hc.equals(v)){
					JOptionPane.showMessageDialog(AgregarPartidoD.this, "El home club debe ser distinto del visitante", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(audiencia > e.getCapacidad()){
					JOptionPane.showMessageDialog(AgregarPartidoD.this, String.format("El estadio\"%s\" no posee capacidad para esta cantidad de expectadores.", e.getNombre()), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else{
					carrerasHC = cHC;
					carrerasVsHC = cV;
					carrerasV = cV;
					carrerasVsV = cHC;
					MostrarPeloterosD mpHC = new MostrarPeloterosD(AgregarPartidoD.this, 1, comboBox.getSelectedIndex(), 1);
					mpHC.setVisible(true);
					if(carrerasVsHC == 0){
						MostrarPeloterosD mpV = new MostrarPeloterosD(AgregarPartidoD.this, 1, comboBox_1.getSelectedIndex(), 0);
						mpV.setVisible(true);
						if(carrerasVsV == 0){
							Serie.getInstance().buscarFase(fase).agregarPartido(v, hc, fecha, e, cV, cHC, audiencia);
							JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido agregado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
							hide();
						}
						else{
							JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido no agregado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(AgregarPartidoD.this, "Partido no agregado.", "Acción Fallida", JOptionPane.ERROR_MESSAGE);
					}
					hide();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(532, 173, 89, 23);
		contentPane.add(btnAceptar);

		calendar = new JCalendar();
		calendar.setBounds(529, 9, 184, 153);
		contentPane.add(calendar);

		comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(6);
		for(int i = 0; i < Serie.getInstance().tablaPosiciones().size(); i++){
			comboBox.addItem(Serie.getInstance().tablaPosiciones().get(i).getNombre());
		}
		comboBox.setBounds(82, 35, 146, 20);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setMaximumRowCount(6);
		for(int i = 0; i < Serie.getInstance().tablaPosiciones().size(); i++){
			comboBox_1.addItem(Serie.getInstance().tablaPosiciones().get(i).getNombre());
		}
		comboBox_1.setBounds(71, 61, 146, 20);
		contentPane.add(comboBox_1);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		spinner.setBounds(402, 35, 46, 20);
		contentPane.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		spinner_1.setBounds(390, 61, 46, 20);
		contentPane.add(spinner_1);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 20000, 1));
		spinner_2.setBounds(330, 87, 62, 20);
		contentPane.add(spinner_2);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.setMaximumRowCount(6);
		for(int j = 0; j < Serie.getInstance().getEstadios().size(); j++){
			comboBox_2.addItem(Serie.getInstance().getEstadios().get(j).getNombre());
		}
		comboBox_2.setBounds(63, 87, 146, 20);
		contentPane.add(comboBox_2);

		comboBox_3 = new JComboBox<String>();
		for(int k = 0; k < Serie.getInstance().getFases().size(); k++){
			comboBox_3.addItem(Serie.getInstance().getFases().get(k).getNombre());
		}
		if(Serie.getInstance().getFases().size() == 4){
			if(Serie.getInstance().getFases().get(3).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Segunda Ronda");
				comboBox_3.removeItem("Play Off");
			}
			else if(Serie.getInstance().getFases().get(2).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Segunda Ronda");
			}
			else if(Serie.getInstance().getFases().get(1).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Final");
			}
			else if(Serie.getInstance().getFases().get(0).getPartidos().size() == 0){
				comboBox_3.removeItem("Segunda Ronda");
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
			else{
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
		}
		else if(Serie.getInstance().getFases().size() == 3){
			if(Serie.getInstance().getFases().get(2).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Segunda Ronda");
			}
			else if(Serie.getInstance().getFases().get(1).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Final");
			}
			else if(Serie.getInstance().getFases().get(0).getPartidos().size() == 0){
				comboBox_3.removeItem("Segunda Ronda");
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
			else{
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
		}
		else if(Serie.getInstance().getFases().size() == 2){
			if(Serie.getInstance().getFases().get(1).getPartidos().size() != 0){
				comboBox_3.removeItem("Primera Ronda");
				comboBox_3.removeItem("Final");
			}
			else if(Serie.getInstance().getFases().get(0).getPartidos().size() == 0){
				comboBox_3.removeItem("Segunda Ronda");
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
			else{
				comboBox_3.removeItem("Play Off");
				comboBox_3.removeItem("Final");
			}
		}
		comboBox_3.setBounds(48, 113, 146, 20);
		contentPane.add(comboBox_3);

	}
}
