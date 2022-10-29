package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Serie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class MostrarEquiposD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDeEquipos;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarEquiposD dialog = new MostrarEquiposD(new PantallaPrincipal(new Login(), 1), 1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarEquiposD(final PantallaPrincipal anterior, final int perfil) {
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

		btnEliminar = new JButton("Eliminar");
		if(perfil == 0){
			btnEliminar.setVisible(false);
		}
		if(Serie.getInstance().getFases().size() != 0){
			if(Serie.getInstance().getFases().get(0).getPartidos().size() != 0){
				btnEliminar.setVisible(false);
			}
		}
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MostrarEquiposD.this, String.format("Está seguro de que desea eliminar el equipo: \"%s\".", Serie.getInstance().getEquipos().get(table.getSelectedRow()).getNombre()), "Eliminar Equipo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					Serie.getInstance().getEquipos().remove(table.getSelectedRow());
					JOptionPane.showMessageDialog(MostrarEquiposD.this, "Equipo eliminado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla();
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(524, 327, 89, 23);
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		if(perfil == 0){
			btnModificar.setVisible(false);
		}
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equipo e = Serie.getInstance().getEquipos().get(table.getSelectedRow());
				ModificarEquipoD mode = new ModificarEquipoD(MostrarEquiposD.this, e);
				mode.setVisible(true);
				cargarTabla();
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(425, 327, 89, 23);
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);

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
				return s;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla();

		btnAgregar = new JButton("Agregar Equipo");
		if(perfil == 0){
			btnAgregar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarEquipoD ae = new AgregarEquipoD(MostrarEquiposD.this);
				ae.setVisible(true);
				cargarTabla();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(292, 327, 123, 23);
		contentPane.add(btnAgregar);

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
		ArrayList<Object>provincia = new ArrayList<Object>();
		ArrayList<Object>col = new ArrayList<Object>();
		ArrayList<Object>mas = new ArrayList<Object>();
		ArrayList<Object>campP = new ArrayList<Object>();
		ArrayList<Object>campG = new ArrayList<Object>();
		ArrayList<Object>dir = new ArrayList<Object>();

		for(int i = 0; i < Serie.getInstance().getEquipos().size(); i++){
			equipo.add(Serie.getInstance().getEquipos().get(i).getNombre());
			provincia.add(Serie.getInstance().getEquipos().get(i).getProvincia());
			col.add(Serie.getInstance().getEquipos().get(i).getColor());
			mas.add(Serie.getInstance().getEquipos().get(i).getMascota());
			campP.add(Serie.getInstance().getEquipos().get(i).getCampeonatosParticipados());
			campG.add(Serie.getInstance().getEquipos().get(i).getCampeonatosGanados());
			dir.add(Serie.getInstance().getEquipos().get(i).getNombreDirector() + " " + Serie.getInstance().getEquipos().get(i).getApellido());
		}

		modelo.addColumn("Equipo", equipo.toArray());
		modelo.addColumn("Provincia", provincia.toArray());
		modelo.addColumn("Color", col.toArray());
		modelo.addColumn("Mascota", mas.toArray());
		modelo.addColumn("CP", campP.toArray());
		modelo.addColumn("CG", campG.toArray());
		modelo.addColumn("Director", dir.toArray());
		table.setModel(modelo);

		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);

		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);

		table.getColumnModel().getColumn(2).setMaxWidth(80);
		table.getColumnModel().getColumn(2).setMinWidth(80);

		table.getColumnModel().getColumn(3).setMaxWidth(110);
		table.getColumnModel().getColumn(3).setMinWidth(110);

		table.getColumnModel().getColumn(4).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(50);

		table.getColumnModel().getColumn(5).setMaxWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(50);

		table.getColumnModel().getColumn(6).setMaxWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
	}
}

