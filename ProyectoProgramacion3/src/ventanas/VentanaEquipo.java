package ventanas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import baseDatos.DBManager;
import clases.BaseDatos;
import clases.Jugador;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> model;
	private JList<BaseDatos> list;
	private ArrayList<BaseDatos> nombreJugador;



	/**
	 * Create the frame.
	 */
	public VentanaEquipo() {
		setTitle("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(219, 11, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Plantilla");
		lblNewLabel_2.setBounds(219, 53, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(418, 53, 49, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion v = new InicioSesion();
				v.setVisible(true);
				VentanaEquipo.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 317, 89, 23);
		contentPane.add(btnNewButton);
		cargarJList();
		
		JList list = new JList(model);
		list.setBounds(140, 96, 240, 244);
		contentPane.add(list);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 53, 108, 22);
		contentPane.add(comboBox);

		String[] opciones = { "4-3-3", "4-4-2", "4-2-3-1", "3-4-3", "4-4-1-1" };
		comboBox.setModel(new DefaultComboBoxModel(opciones));

	}

	



	public void cargarJList() {
		// TODO Auto-generated method stub
		DBManager dbmanager= new DBManager();
		dbmanager.conectar();
		List<Jugador> jug = dbmanager.crearListaPlantilla(InterfazDeUsuarioPublico.usP);
	
		model = new DefaultListModel<String>();
		for (int i = 0; i < jug.size(); i++) {
			model.addElement(jug.get(i).toString());
		}
			

		
	

	}
}
