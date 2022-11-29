package ventanas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDatos.DBManager;
import clases.BaseDatos;

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
	private DefaultListModel<BaseDatos> model;
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

		JList list = new JList();
		list.setBounds(140, 96, 240, 244);
		contentPane.add(list);
		cargarJList();

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 53, 108, 22);
		contentPane.add(comboBox);

		String[] opciones = { "4-3-3", "4-4-2", "4-2-3-1", "3-4-3", "4-4-1-1" };
		comboBox.setModel(new DefaultComboBoxModel(opciones));

	}

	public void VerPlantilla() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/baseDatos/baseDatosProyecto.db");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombreJugador, posicion, equipo, punSem1, punSem2 from jugadores");

			while (rs.next()) {
				String nombreJugador = rs.getString("nombreJugador");
				String posicion = rs.getString("posicion");
				String equipo = rs.getString("equipo");
				int punSem1 = rs.getInt("punSem1");
				int punSem2 = rs.getInt("punSem2");

			}

			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexión a la base de datos");
		}
	}

	public ArrayList<BaseDatos> getJugadores() {
		return nombreJugador;
	}

	public void setUsers(ArrayList<BaseDatos> nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public void cargarJList() {

		model = new DefaultListModel<BaseDatos>();
		for (BaseDatos baseDatos : nombreJugador) {
			model.addElement(baseDatos);

		}
		list.setModel(model);

	}
}
