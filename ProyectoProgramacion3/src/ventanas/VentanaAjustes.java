package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAjustes extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public VentanaAjustes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ajustes");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazDeUsuarioPublico  v = new InterfazDeUsuarioPublico(null, null,VentanaAjustes.this);
				v.setVisible(true);
				VentanaAjustes.this.setVisible(false);
			}
		});
		btnVolver.setBounds(337, 229, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnEditarUsuario = new JButton("Editar Usuario");
		btnEditarUsuario.setBounds(63, 100, 127, 55);
		contentPane.add(btnEditarUsuario);
		
		JButton btnEliminarCuenta = new JButton("Eliminar Usuario");
		btnEliminarCuenta.setBounds(254, 100, 127, 55);
		contentPane.add(btnEliminarCuenta);
	}
}
