package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearLiga extends JFrame {

	private JPanel contentPane;
	static JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public VentanaCrearLiga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JLabel lblNombreLiga_1 = new JLabel("Nombre liga:");
		panel_6.add(lblNombreLiga_1);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_8.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnCrearLiga = new JButton("Crear liga");
		btnCrearLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_3.add(btnCrearLiga);
	}
}
