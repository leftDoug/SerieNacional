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

import logica.Estadio;
import logica.Serie;

public class MostrarFasesD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarFasesD dialog = new MostrarFasesD(new PantallaPrincipal(new Login(), 1), 1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarFasesD(final PantallaPrincipal anterior, final int perfil) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 490, 227);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Listado de Fases:");
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 104, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 453, 110);
		contentPane.add(scrollPane);

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
				ModificarFaseD modf = new ModificarFaseD(MostrarFasesD.this, table.getSelectedRow());
				modf.setVisible(true);
				cargarTabla();
				btnModificar.setEnabled(false);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setBounds(374, 157, 89, 23);
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				btnModificar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);
		cargarTabla();

		btnAgregar = new JButton("Agregar Fase");
		if(perfil == 0){
			btnAgregar.setVisible(false);
		}
		if(Serie.getInstance().getFases().size() == 4){
			btnAgregar.setVisible(false);
		}
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarFaseD af = new AgregarFaseD(MostrarFasesD.this);
				af.setVisible(true);
				cargarTabla();
				if(Serie.getInstance().getFases().size() == 4){
					btnAgregar.setVisible(false);
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregar.setBounds(227, 157, 137, 23);
		contentPane.add(btnAgregar);

		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnAtrs.setBounds(10, 157, 89, 23);
		contentPane.add(btnAtrs);
	}

	public void cargarTabla(){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>nombre = new ArrayList<Object>();
		ArrayList<Object>fechaI = new ArrayList<Object>();
		ArrayList<Object>fechaF = new ArrayList<Object>();

		for(int j = 0; j < Serie.getInstance().getFases().size(); j++){
			nombre.add(Serie.getInstance().getFases().get(j).getNombre());
			fechaI.add(Serie.getInstance().getFases().get(j).getFechaInicio().getDate() + "/" + (Serie.getInstance().getFases().get(j).getFechaInicio().getMonth() + 1) + "/" + (Serie.getInstance().getFases().get(j).getFechaInicio().getYear() - 100));
			fechaF.add(Serie.getInstance().getFases().get(j).getFechaFin().getDate() + "/" + (Serie.getInstance().getFases().get(j).getFechaFin().getMonth() + 1) + "/" + (Serie.getInstance().getFases().get(j).getFechaFin().getYear() - 100));
		}

		modelo.addColumn("Nombre", nombre.toArray());
		modelo.addColumn("Fecha de Inicio", fechaI.toArray());
		modelo.addColumn("Fecha de Fin", fechaF.toArray());
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(150);
	}

}
