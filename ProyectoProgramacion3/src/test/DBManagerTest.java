package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import baseDatos.DBManager;
import clases.Usuario;
import clases.UsuarioPublico;

public class DBManagerTest {

	private DBManager con;
	private DBManager discon;
	private DBManager usuario;

	@Before
	public void setUp() throws Exception {
		con.conectar();
	}

	@After
	public void tearDown() throws Exception {
		discon.disconnect();
	}

	@Test // para asegurarnos de que no da error al crear lista
	public void testCrearLista() {

		try {

			usuario.crearLista();

		} catch (Exception e) {
// TODO: handle exception

			fail("Error a la hora de crear lista");

		}

	}

	@Test // para ver que cuando añadimos un usuario, el tamaño del array incrementa
	public void testActualizarUsuarios() {

		List<UsuarioPublico> up = new ArrayList<>();

		up = usuario.crearLista();
		int largoLista = up.size();

		usuario.actualizarUsuarios(null);

		assertEquals(largoLista + 1, usuario.crearLista().size());

	}

	@Test // para ver que cuando eliminamos un usuario, el tamaño del array disminuye
	public void testEliminarUsuario() {

		List<UsuarioPublico> up = new ArrayList<>();

		up = usuario.crearLista();
		int largoLista = up.size();

		usuario.eliminarUsuario(null);

		assertEquals(largoLista - 1, usuario.crearLista().size());

	}

	
}