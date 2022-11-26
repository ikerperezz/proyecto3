package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.BaseDatos;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VentanaClasificacion extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Usuario> model;
	private JList<Usuario> list;
	private ArrayList<Usuario> users;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaClasificacion frame = new VentanaClasificacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaClasificacion() {
		setTitle("Clasificación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(247, 34, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(469, 92, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(247, 92, 102, 14);
		contentPane.add(lblNewLabel_2);

		JList list = new JList();
		list.setBounds(150, 117, 256, 250);
		contentPane.add(list);
		cargarJlist();

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion v = new InicioSesion();
				v.setVisible(true);
				VentanaClasificacion.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 346, 89, 23);
		contentPane.add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 88, 108, 22);
		contentPane.add(comboBox);

		String[] numeroJornada = { "1", "2", "3", "4", "5", "6", "7" };
		comboBox.setModel(new DefaultComboBoxModel(numeroJornada));

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // aqui hacemos la suma de los puntos del once inicial
				// TODO Auto-generated method stub
				int[] puntos = Integer.parseInt();

						lblNewLabel.setText(puntos);

			}

		});

		JLabel lblNewLabel_3 = new JLabel("Jornada");
		lblNewLabel_3.setBounds(39, 63, 49, 14);
		contentPane.add(lblNewLabel_3);
	}

	public void cargarJlist() {
		// TODO Auto-generated method stub
		model = new DefaultListModel<Usuario>();
		for (Usuario usuario : users) {
			model.addElement(usuario);

		}
		list.setModel(model);

	}
}
