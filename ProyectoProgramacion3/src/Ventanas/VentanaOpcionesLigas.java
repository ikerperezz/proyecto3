package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaOpcionesLigas {

	private JFrame frame;
	private CrearCuenta padre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesLigas window = new VentanaOpcionesLigas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param crearCuenta 
	 */
	public VentanaOpcionesLigas(CrearCuenta crearCuenta) {
		initialize(crearCuenta);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(CrearCuenta padre) {
		this.padre = padre;
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Crear liga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(63, 93, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unirse a liga");
		btnNewButton_1.setBounds(328, 93, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
