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

import logica.Entrenador;
import logica.Estadio;
import logica.Jugador;
import logica.Lanzador;
import logica.Serie;

public class MostrarEstadiosD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarEstadiosD dialog = new MostrarEstadiosD(new PantallaPrincipal(new Login(), 1), 1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarEstadiosD(final PantallaPrincipal anterior, final int perfil) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 595, 400);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Estadios:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 130, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 553, 279);
		contentPane.add(scrollPane);

		btnEliminar = new JButton("Eliminar");if(perfil == 0){
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
				if(JOptionPane.showConfirmDialog(MostrarEstadiosD.this, String.format("Está seguro de que desea eliminar el estadio: \"%s\".", Serie.getInstance().getEstadios().get(table.getSelectedRow()).getNombre()), "Eliminar Estadio", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					Serie.getInstance().getEstadios().remove(table.getSelectedRow());
					JOptionPane.showMessageDialog(MostrarEstadiosD.this, "Estadio eliminado correctamente.", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla();
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			}
		});
		btnEliminar.setBounds(474, 326, 89, 23);
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		if(perfil == 0){
			btnModificar.setVisible(false);
		}
		if(Serie.getInstance().getFases().size() != 0){
			if(Serie.getInstance().getFases().get(0).getPartidos().size() != 0){
				btnModificar.setVisible(false);
			}
		}
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estadio e = Serie.getInstance().getEstadios().get(table.getSelectedRow());
				ModificarEstadioD modp = new ModificarEstadioD(MostrarEstadiosD.this, e);
				modp.setVisible(true);
				cargarTabla();
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(375, 326, 89, 23);
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
				else if(getValueAt(x, y) instanceof Boolean){
					s = String.format("%b", getValueAt(x, y));
				}
				else if(getValueAt(x, y) instanceof Float){
					s = String.format("%.1f", getValueAt(x, y));
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

		btnAgregar = new JButton("Agregar Estadio");
		if(perfil == 0){
			btnModificar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarEstadioD ae = new AgregarEstadioD(MostrarEstadiosD.this);
				ae.setVisible(true);
				cargarTabla();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(228, 326, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnAtrs.setBounds(10, 326, 89, 23);
		contentPane.add(btnAtrs);
	}

	public void cargarTabla(){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>nombre = new ArrayList<Object>();
		ArrayList<Object>provincia = new ArrayList<Object>();
		ArrayList<Object>capacidad = new ArrayList<Object>();

		for(int j = 0; j < Serie.getInstance().getEstadios().size(); j++){
			nombre.add(Serie.getInstance().getEstadios().get(j).getNombre());
			provincia.add(Serie.getInstance().getEstadios().get(j).getProvincia());
			capacidad.add(Serie.getInstance().getEstadios().get(j).getCapacidad());
		}

		modelo.addColumn("Nombre", nombre.toArray());
		modelo.addColumn("Provincia", provincia.toArray());
		modelo.addColumn("Capacidad", capacidad.toArray());
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
	}

}
