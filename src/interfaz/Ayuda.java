package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda(new PantallaPrincipal(new Login(), 1));
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda(final PantallaPrincipal anterior) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreditosD.class.getResource("/imagenes/iconom.gif")));
		setTitle("Ayuda");
		setBounds(100, 100, 450, 361);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 414, 261);
		contentPane.add(scrollPane);
		
		JTextArea txtrAlMomentoDe = new JTextArea();
		txtrAlMomentoDe.setEditable(false);
		scrollPane.setViewportView(txtrAlMomentoDe);
		txtrAlMomentoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrAlMomentoDe.setText("Al momento de crear un equipo hay que garantizar que este tenga \r\nal menos 8 jugadores adem\u00E1s del lanzador para que el equipo sea \r\ncapaz de disputar un partido. Solo despu\u00E9s de que esto se cumpla se \r\nagregar\u00E1 el equipo satisfactoriamente.\r\n\r\nSolo es posible modificar las estad\u00EDsticas de los jugadores al momento \r\nde registrar un partido, con esto se asegura que los datos sean fieles a la \r\ninformaci\u00F3n de los partidos disputados por los equipos.\r\n\r\nAl momento de consultar los reportes se tendr\u00E1n en cuenta solo los \r\njugadores que hallan disputado al menos un partido.");
		
		JLabel lblAyuda = new JLabel("Ayuda:");
		lblAyuda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAyuda.setBounds(10, 11, 43, 15);
		contentPane.add(lblAyuda);
	}
}
