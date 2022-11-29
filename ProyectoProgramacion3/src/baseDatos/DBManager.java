package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Liga;
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
				int idLIga = rs.getInt("IdLIga");
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
				"INSERT INTO USUARIO ( nombreDeUsuario, contraseña, IdLiga, dineroDisponible) VALUES (?, ?,?,?)");
				Statement stmtForId = conn.createStatement()) {
			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS id FROM USUARIO");
			
			stmt.setString(1, usuarioP.getUsuario());
			stmt.setString(2, usuarioP.getContraseina());
			stmt.setInt(3, usuarioP.getIdLiga());
			stmt.setInt(4, usuarioP.getDineroDisponible());

			stmt.executeUpdate();
			if (rs.next()) {
				int newId = rs.getInt("id");
				usuarioP.setIdUsuarioPublico(newId);
			}
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
	
	
	public void update(UsuarioPublico usuarioPublico, String nombreDeUsuario) {
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET nombreDeUsuario=?, contraseña=? WHERE nombreDeUsuario = '"+ nombreDeUsuario +"'")) {
			stmt.setString(1, usuarioPublico.getUsuario());
			stmt.setString(2, usuarioPublico.getContraseina());	
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.format("No se pudo guardar el usuario en la BD", e);
		}
	}
	public void updateLigaEnUsuario(UsuarioPublico usuarioPublico, String nombreDeUsuario) {
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET idLiga=? WHERE nombreDeUsuario = '"+ nombreDeUsuario +"'")) {
			stmt.setInt(1, usuarioPublico.getIdLiga());	
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.format("No se pudo guardar el usuario en la BD", e);
		}
	}
	
	
	public int actualizarLigas(Liga liga) {
		int newId = 0;
		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO LIGA (nombreLiga) VALUES (?)");
				Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, liga.getNombreLiga());
			stmt.executeUpdate();
			
			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS idLiga FROM LIGA");
			if (rs.next()) {
				newId = rs.getInt("idLiga");
				liga.setIdLiga(newId);
				
			}
			
			
			
			return newId ;
		} catch (SQLException e) {
			System.out.format("Error actualizando liga", e);
			e.printStackTrace();
			return 0;
		}
		
		
	
	}	


	public List<Liga> crearListaLiga(){
		
		List<Liga> liga = new ArrayList<Liga>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT idLiga, nombreLiga FROM Liga");

			while (rs.next()) {
				int idLiga = rs.getInt("idLiga");
				String nombre = rs.getString("nombreLiga");
				Liga lig = new Liga(idLiga, nombre);
				liga.add(lig);
			}
			return liga;
		} catch (SQLException e) {
			System.out.format("Error creando lista", e);
		}
		return null;
	}
}
