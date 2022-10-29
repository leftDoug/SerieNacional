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

import logica.Equipo;
import logica.Serie;

public class MostrarEstadisticas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDeEquipos;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarEstadisticas dialog = new MostrarEstadisticas(new PantallaPrincipal(new Login(), 1));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarEstadisticas(final PantallaPrincipal anterior) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 639, 398);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDeEquipos = new JLabel("Listado de Equipos:");
		lblListadoDeEquipos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDeEquipos.setBounds(10, 11, 120, 15);
		contentPane.add(lblListadoDeEquipos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 603, 279);
		contentPane.add(scrollPane);

		table = new JTable(){
			public String getToolTipText (MouseEvent e){
				String s = null;
				java.awt.Point p = e.getPoint();
				int x = rowAtPoint(p);
				int y = columnAtPoint(p);
				if(getValueAt(x, y) instanceof Integer){
					s = String.format("%d", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof String){
					s = (String) getValueAt(x, y);
				}
				else if(getValueAt(x, y) instanceof Float){
					s = String.format("%.1f", getValueAt(x, y));
				}
				return s;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane.setViewportView(table);
		cargarTabla();

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnAtrs.setBounds(10, 327, 89, 23);
		contentPane.add(btnAtrs);
	}

	public void cargarTabla(){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>equipo = new ArrayList<Object>();
		ArrayList<Object>vecesAB = new ArrayList<Object>();
		ArrayList<Object>lesiones = new ArrayList<Object>();
		ArrayList<Object>pcl = new ArrayList<Object>();
		ArrayList<Object>ave = new ArrayList<Object>();
		ArrayList<Object>hits = new ArrayList<Object>();
		ArrayList<Object>homeR = new ArrayList<Object>();
		ArrayList<Object>errores = new ArrayList<Object>();

		for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
			equipo.add(Serie.getInstance().getEquipos().get(i).getNombre());
			vecesAB.add(Serie.getInstance().getEquipos().get(i).cantVecesAlBate());
			lesiones.add(Serie.getInstance().getEquipos().get(i).cantLesionados());
			if(Serie.getInstance().getEquipos().get(i).calcPromCarrerasLimpias() != -1){
			pcl.add(String.format("%.1f", Serie.getInstance().getEquipos().get(i).calcPromCarrerasLimpias()));
			}
			else{
				pcl.add("");
			}
			if(Serie.getInstance().getEquipos().get(i).calcPromBateo() != -1){
			ave.add(Serie.getInstance().getEquipos().get(i).calcPromBateo());
			}
			else{
				ave.add("");
			}
			hits.add(Serie.getInstance().getEquipos().get(i).cantHits());
			homeR.add(Serie.getInstance().getEquipos().get(i).cantHomeRuns());
			errores.add(Serie.getInstance().getEquipos().get(i).cantErrores());
		}

		modelo.addColumn("Equipo", equipo.toArray());
		modelo.addColumn("Veces al Bate", vecesAB.toArray());
		modelo.addColumn("Lesiones", lesiones.toArray());
		modelo.addColumn("PCL", pcl.toArray());
		modelo.addColumn("Ave.", ave.toArray());
		modelo.addColumn("Hits", hits.toArray());
		modelo.addColumn("Home Runs", homeR.toArray());
		modelo.addColumn("Errores", errores.toArray());
		table.setModel(modelo);

		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);

		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);

		table.getColumnModel().getColumn(2).setMaxWidth(80);
		table.getColumnModel().getColumn(2).setMinWidth(80);

		table.getColumnModel().getColumn(3).setMaxWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);

		table.getColumnModel().getColumn(4).setMaxWidth(60);
		table.getColumnModel().getColumn(4).setMinWidth(60);

		table.getColumnModel().getColumn(5).setMaxWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(50);

		table.getColumnModel().getColumn(6).setMaxWidth(80);
		table.getColumnModel().getColumn(6).setMinWidth(80);

		table.getColumnModel().getColumn(7).setMaxWidth(60);
		table.getColumnModel().getColumn(7).setMinWidth(60);
	}

}
