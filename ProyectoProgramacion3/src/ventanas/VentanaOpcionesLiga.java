package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaOpcionesLiga extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesLiga frame = new VentanaOpcionesLiga(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param crearCuenta 
	 */
	public VentanaOpcionesLiga(CrearCuenta crearCuenta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearLiga = new JButton("Crear liga");
		btnCrearLiga.setBounds(51, 98, 144, 23);
		contentPane.add(btnCrearLiga);
		
		JButton btnUnirse = new JButton("Unirse a liga");
		btnUnirse.setBounds(266, 98, 144, 23);
		contentPane.add(btnUnirse);
	}
}
