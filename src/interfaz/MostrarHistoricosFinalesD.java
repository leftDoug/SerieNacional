package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.HistoricosFinales;
import logica.Serie;

public class MostrarHistoricosFinalesD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblListadoDePeloteros;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarHistoricosFinalesD dialog = new MostrarHistoricosFinalesD(new PantallaPrincipal(new Login(), 1), 0);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarHistoricosFinalesD(final PantallaPrincipal anterior, final int x) {
		setModal(true);
		setTitle("Serie Nacional de Beisbol");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEquiposD.class.getResource("/imagenes/iconom.gif")));
		setBounds(100, 100, 310, 399);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblListadoDePeloteros = new JLabel("Hist\u00F3ricos Finales de la Serie " + (x + 53));
		lblListadoDePeloteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListadoDePeloteros.setBounds(10, 11, 273, 15);
		contentPane.add(lblListadoDePeloteros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 273, 279);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		cargarTabla(x);

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

	public void cargarTabla(int x){
		DefaultTableModel modelo = new DefaultTableModel(){
			public boolean  isCellEditable(int i,int c){
				return false;
			}
		};
		ArrayList<Object>posicion = new ArrayList<Object>();
		ArrayList<Object>equipo = new ArrayList<Object>();
		ArrayList<Object>puntos = new ArrayList<Object>();

		for(int j = 0; j < HistoricosFinales.getInstance().getSeries().get(x).tablaPosiciones().size(); j++){
				posicion.add(j + 1);
				equipo.add(HistoricosFinales.getInstance().getSeries().get(x).tablaPosiciones().get(j).getNombre());
				puntos.add(HistoricosFinales.getInstance().getSeries().get(x).tablaPosiciones().get(j).getPuntos());
		}

		modelo.addColumn("Posición", posicion.toArray());
		modelo.addColumn("Equipo", equipo.toArray());
		modelo.addColumn("Puntos", puntos.toArray());
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(65);
		table.getColumnModel().getColumn(0).setMaxWidth(65);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(55);
		table.getColumnModel().getColumn(2).setMaxWidth(55);
	}

}
