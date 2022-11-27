package clases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Logger {

	static Logger logger = Logger.getLogger(Logger.class.getName());

	private static Logger getLogger(String name) {
		return null;
	}

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "No se pudo leer el fichero de configuración del logger");
		}

		logger.info("Programa comenzado");

		for (int i = 0; i < 10; i++) {
			logger.log(Level.FINE, "Voy por la iteración " + i);

			logger.info("Programa Terminado");
		}

	}

	public String info(String msg) {
		return msg;

	}

	private void log(Level severe, String string) {
	}

}
