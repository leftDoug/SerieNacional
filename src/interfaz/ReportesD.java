package interfaz;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Serie;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import extras.Datos;

public class ReportesD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComponent contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JButton btnAtrs;
	private JList<String> list;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportesD dialog = new ReportesD(new PantallaPrincipal(new Login(), 1));
			Datos.inicializarDatos();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportesD(final PantallaPrincipal anterior) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 703, 422);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de reportes:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 124, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 667, 105);
		contentPane.add(scrollPane);

		list = new JList<String>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				switch(list.getSelectedIndex()){
				case 0:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().mejorAveJugador().size(); i++){
					textArea.append("Jugador: " + Serie.getInstance().mejorAveJugador().get(i).getNombre() + " " + Serie.getInstance().mejorAveJugador().get(i).getApellido() +
							"\nDorsal: " + Serie.getInstance().mejorAveJugador().get(i).getNumero() +
							"\nAve: " + Serie.getInstance().mejorAveJugador().get(i).getPromedioBateo() +
							"\nEquipo: " + Serie.getInstance().mejorAveEquipo().get(i).getNombre() + "\n");
					}
					break;
				case 1:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
						if(Serie.getInstance().getEquipos().get(i).mejorAve().size() == 0){
							textArea.append("Equipo: " + Serie.getInstance().getEquipos().get(i).getNombre() +
									"\nEste equipo no ha jugado ningún partido.\n\n\n");
						}
						else{
							for(int j = 0; j < Serie.getInstance().getEquipos().get(i).mejorAve().size(); j++){
							textArea.append("Jugador: " + Serie.getInstance().getEquipos().get(i).mejorAve().get(j).getNombre() + " " + Serie.getInstance().getEquipos().get(i).mejorAve().get(j).getApellido() +
									"\nDorsal: " + Serie.getInstance().getEquipos().get(i).mejorAve().get(j).getNumero() +
									"\nAve: " + Serie.getInstance().getEquipos().get(i).mejorAve().get(j).getPromedioBateo() +
									"\nEquipo: " + Serie.getInstance().getEquipos().get(i).getNombre() + "\n\n\n");
							}
						}
					}
					break;
				case 2:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().mejorPCLLanzador().size(); i++){
					textArea.append("Jugador: " + Serie.getInstance().mejorPCLLanzador().get(i).getNombre() + " " + Serie.getInstance().mejorPCLLanzador().get(i).getApellido() +
							"\nDorsal: " + Serie.getInstance().mejorPCLLanzador().get(i).getNumero() +
							"\nPCL: " + Serie.getInstance().mejorPCLLanzador().get(i).getPromCarrerasLimpias() +
							"\nEquipo: " + Serie.getInstance().mejorPCLEquipo().get(i).getNombre() + "\n\n\n");
					}
					break;
				case 3:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
						if(Serie.getInstance().getEquipos().get(i).mejorPCL().size() == 0){
							textArea.append("Equipo: " + Serie.getInstance().getEquipos().get(i).getNombre() +
									"\nEste equipo no ha jugado ningún partido.\n\n\n");
						}
						else{
							for(int j = 0; j < Serie.getInstance().getEquipos().get(i).mejorPCL().size(); j++){
							textArea.append("Jugador: " + Serie.getInstance().getEquipos().get(i).mejorPCL().get(j).getNombre() + " " + Serie.getInstance().getEquipos().get(i).mejorPCL().get(j).getApellido() +
									"\nDorsal: " + Serie.getInstance().getEquipos().get(i).mejorPCL().get(j).getNumero() +
									"\nPCL: " + Serie.getInstance().getEquipos().get(i).mejorPCL().get(j).getPromCarrerasLimpias() +
									"\nEquipo: " + Serie.getInstance().getEquipos().get(i).getNombre() + "\n\n\n");
							}
						}
					}
					break;
				case 4:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().mayorHomeRunJugador().size(); i++){
					textArea.append("Jugador: " + Serie.getInstance().mayorHomeRunJugador().get(i).getNombre() + " " + Serie.getInstance().mayorHomeRunJugador().get(i).getApellido() +
							"\nDorsal: " + Serie.getInstance().mayorHomeRunJugador().get(i).getNumero() +
							"\nHome Runs: " + Serie.getInstance().mayorHomeRunJugador().get(i).getHomeRuns() +
							"\nEquipo: " + Serie.getInstance().mayorHomeRunEquipo().get(i).getNombre() + "\n");
					}
					break;
				case 5:
					textArea.setText("");
					for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
						if(Serie.getInstance().getEquipos().get(i).mayorHomeRuns().size() == 0){
							textArea.append("Equipo: " + Serie.getInstance().getEquipos().get(i).getNombre() +
									"\nEste equipo no ha jugado ningún partido.\n\n\n");
						}
						else{
							for(int j = 0; j < Serie.getInstance().getEquipos().get(i).mayorHomeRuns().size(); j++){
							textArea.append("Jugador: " + Serie.getInstance().getEquipos().get(i).mayorHomeRuns().get(j).getNombre() + " " + Serie.getInstance().getEquipos().get(i).mayorHomeRuns().get(j).getApellido() +
									"\nDorsal: " + Serie.getInstance().getEquipos().get(i).mayorHomeRuns().get(j).getNumero() +
									"\nHome Runs: " + Serie.getInstance().getEquipos().get(i).mayorHomeRuns().get(j).getHomeRuns() +
									"\nEquipo: " + Serie.getInstance().getEquipos().get(i).getNombre() + "\n\n\n");
							}
						}
					}
				}
			}
		});
		list.setVisibleRowCount(6);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1- L\u00EDder en promedio de bateo de la Serie.", "2- L\u00EDder en promedio de bateo por equipos.", "3- L\u00EDder en promedio de carreras limpias de la Serie.", "4- L\u00EDder en promedio de carreras limpias por equipos.", "5- L\u00EDder en home runs de la Serie.", "6- L\u00EDder en home runs por equipos."};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnAtrs.setBounds(10, 352, 89, 23);
		contentPane.add(btnAtrs);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 151, 667, 190);
		contentPane.add(scrollPane_1);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
	}
}
