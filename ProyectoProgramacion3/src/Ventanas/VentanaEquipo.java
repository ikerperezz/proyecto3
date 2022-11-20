package Ventanas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaEquipo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
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
	public VentanaEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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
}
