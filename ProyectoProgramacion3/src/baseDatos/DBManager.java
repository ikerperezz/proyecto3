package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.UsuarioPublico;

public class DBManager {
	
	private Connection conn = null;
	
public void conectar(){
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver de la base de datos");
	}
	
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:src/baseDatos/baseDatosProyecto.db");
		
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


public ArrayList<UsuarioPublico> crearLista(){
	ArrayList<UsuarioPublico> up = new ArrayList<UsuarioPublico>();
	try (Statement stmt = conn.createStatement()){
		ResultSet rs = stmt.executeQuery("SELECT nombreDeUsuario, contraseña, dineroDisponible, idLiga FROM usuario");

		while (rs.next()) {
			String usuario = rs.getString("nombreDeUsuario");
			String contraseina = rs.getString("contraseña");
			String idLIga = rs.getString("IdLIga");
			int dineroDisponible =rs.getInt("dineroDisponible");
			UsuarioPublico us= new UsuarioPublico(usuario, contraseina, idLIga, dineroDisponible);
			up.add(us);
		}
	return up;
	}catch(SQLException e) {
		System.out.format("Error creando lista", e);
	}
	return null;
}


}
