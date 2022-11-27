package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Usuario;
import clases.UsuarioPublico;

public class DBManager {

	private Connection conn = null;

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:src/baseDatos/baseDatosProyecto.db");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexión a la base de datos");
		}

	}

	public void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.format("Error cerrando la conexión con la BD", e);
		}
	}

	public List<UsuarioPublico> crearLista() {
		List<UsuarioPublico> up = new ArrayList<UsuarioPublico>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT idUsuario, nombreDeUsuario, contraseña, dineroDisponible, idLiga FROM usuario");

			while (rs.next()) {
				int idUsuario = rs.getInt("idUsuario");
				String usuario = rs.getString("nombreDeUsuario");
				String contraseina = rs.getString("contraseña");
				String idLIga = rs.getString("IdLIga");
				int dineroDisponible = rs.getInt("dineroDisponible");
				UsuarioPublico us = new UsuarioPublico(usuario, contraseina, idUsuario, idLIga, dineroDisponible);
				up.add(us);
			}
			return up;
		} catch (SQLException e) {
			System.out.format("Error creando lista", e);
		}
		return null;
	}

	public void actualizarUsuarios(UsuarioPublico usuarioP) {
		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO USUARIO (idUsuario, nombreDeUsuario, contraseña, IdLiga, dineroDisponible) VALUES (?, ?, ?,?,?)");
				Statement stmtForId = conn.createStatement()) {
			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS id FROM USUARIO");
			if (rs.next()) {
				int newId = rs.getInt("id");
				usuarioP.setIdUsuarioPublico(newId);
			}
			stmt.setInt(1, usuarioP.getIdUsuarioPublico());
			stmt.setString(2, usuarioP.getUsuario());
			stmt.setString(3, usuarioP.getContraseina());
			stmt.setString(4, usuarioP.getIdLiga());
			stmt.setInt(5, usuarioP.getDineroDisponible());

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.format("Error cargando usuario", e);
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(String nombreDeUsuario) {
		try (Statement stmt = conn.createStatement()) {
		int borrado = stmt.executeUpdate("DELETE FROM usuario where nombreDeUsuario = '" + nombreDeUsuario + "'");
	}catch (SQLException e) {
		System.out.format("Error eliminando usuario", e);
	}
}
}
