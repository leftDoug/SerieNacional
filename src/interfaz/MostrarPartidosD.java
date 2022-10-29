package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Serie;

public class MostrarPartidosD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarPartidosD dialog = new MostrarPartidosD(new PantallaPrincipal(new Login(), 1), 1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarPartidosD(final PantallaPrincipal anterior, final int perfil) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 589, 361);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Partidos:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 123, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 552, 242);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		cargarTabla();

		btnAgregar = new JButton("Agregar Partido");
		if(perfil == 0){
			btnAgregar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPartidoD ap = new AgregarPartidoD(MostrarPartidosD.this);
				ap.setVisible(true);
				cargarTabla();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(426, 289, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnAtrs.setBounds(10, 289, 89, 23);
		contentPane.add(btnAtrs);

	}

	public void cargarTabla(){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>hc = new ArrayList<Object>();
		ArrayList<Object>cHC = new ArrayList<Object>();
		ArrayList<Object>v = new ArrayList<Object>();
		ArrayList<Object>cV = new ArrayList<Object>();
		ArrayList<Object>e = new ArrayList<Object>();
		ArrayList<Object>fecha = new ArrayList<Object>();
		ArrayList<Object>a = new ArrayList<Object>();
		ArrayList<Object>fase = new ArrayList<Object>();

		for(int j = 0; j < Serie.getInstance().getFases().size(); j++){
			for(int i = 0; i < Serie.getInstance().getFases().get(j).getPartidos().size(); i++){
				hc.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getHomeClub().getNombre());
				v.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getVisitante().getNombre());
				cHC.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getCarrerasHomeClub());
				cV.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getCarrerasVisitante());
				e.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getEstadio().getNombre());
				fecha.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getFecha().getDate() + "/" + (Serie.getInstance().getFases().get(j).getPartidos().get(i).getFecha().getMonth() + 1) + "/" + (Serie.getInstance().getFases().get(j).getPartidos().get(i).getFecha().getYear() - 100));
				a.add(Serie.getInstance().getFases().get(j).getPartidos().get(i).getEstadio().getCapacidad());
				fase.add(Serie.getInstance().getFases().get(j).getNombre());
			}
		}

		modelo.addColumn("Home Club", hc.toArray());
		modelo.addColumn("Visitante", v.toArray());
		modelo.addColumn("Carreras Home Club", cHC.toArray());
		modelo.addColumn("Carreras Visitante", cV.toArray());
		modelo.addColumn("Estadio", e.toArray());
		modelo.addColumn("Audiencia", a.toArray());
		modelo.addColumn("Fase", fase.toArray());
		modelo.addColumn("Fecha", fecha.toArray());
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(150);
		table.getColumnModel().getColumn(5).setMaxWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(6).setMaxWidth(150);
		table.getColumnModel().getColumn(7).setMinWidth(150);
		table.getColumnModel().getColumn(7).setMaxWidth(150);
	}

}
