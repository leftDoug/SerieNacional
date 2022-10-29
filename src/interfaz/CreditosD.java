package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class CreditosD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JLabel lblSoftwareDesarrolladoEn;
	private JLabel lblUniversidadTecnolgicaDe;
	private JLabel lbljosAntonioEcheverra;
	private JLabel label;
	private JLabel lblAutores;
	private JLabel lblDouglasIzquierdoArmenteros;
	private JLabel lblMnicaMontotoMontan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreditosD dialog = new CreditosD(new PantallaPrincipal(new Login(), 1));
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreditosD(final PantallaPrincipal anterior) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreditosD.class.getResource("/imagenes/iconom.gif")));
		setTitle("Cr\u00E9ditos");
		setBounds(100, 100, 450, 361);
		setLocationRelativeTo(anterior);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSoftwareDesarrolladoEn = new JLabel("Software desarrollado en:");
		lblSoftwareDesarrolladoEn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoftwareDesarrolladoEn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoftwareDesarrolladoEn.setBounds(10, 11, 424, 14);
		contentPane.add(lblSoftwareDesarrolladoEn);
		
		lblUniversidadTecnolgicaDe = new JLabel("Universidad Tecnol\u00F3gica de La Habana");
		lblUniversidadTecnolgicaDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUniversidadTecnolgicaDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversidadTecnolgicaDe.setBounds(10, 36, 424, 14);
		contentPane.add(lblUniversidadTecnolgicaDe);
		
		lbljosAntonioEcheverra = new JLabel("\"Jos\u00E9 Antonio Echeverr\u00EDa\"");
		lbljosAntonioEcheverra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbljosAntonioEcheverra.setHorizontalAlignment(SwingConstants.CENTER);
		lbljosAntonioEcheverra.setBounds(10, 61, 424, 14);
		contentPane.add(lbljosAntonioEcheverra);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CreditosD.class.getResource("/imagenes/logo de la cujae.jpg")));
		label.setBounds(148, 84, 150, 150);
		contentPane.add(label);
		
		lblAutores = new JLabel("Autores:");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setBounds(10, 245, 424, 14);
		contentPane.add(lblAutores);
		
		lblDouglasIzquierdoArmenteros = new JLabel("Douglas Izquierdo Armenteros  No. 11  1er A\u00F1o  Grupo 13");
		lblDouglasIzquierdoArmenteros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDouglasIzquierdoArmenteros.setHorizontalAlignment(SwingConstants.CENTER);
		lblDouglasIzquierdoArmenteros.setBounds(10, 270, 424, 14);
		contentPane.add(lblDouglasIzquierdoArmenteros);
		
		lblMnicaMontotoMontan = new JLabel("M\u00F3nica Montoto Montan\u00E9  No. 18  1er A\u00F1o  Grupo 13");
		lblMnicaMontotoMontan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMnicaMontotoMontan.setHorizontalAlignment(SwingConstants.CENTER);
		lblMnicaMontotoMontan.setBounds(10, 295, 424, 14);
		contentPane.add(lblMnicaMontotoMontan);
	}

}
