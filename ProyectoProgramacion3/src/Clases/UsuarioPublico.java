package Clases;

public class UsuarioPublico extends Usuario {
		private int idUsuarioPublico;
		private String idLiga;
		private int dineroDisponible;
	
		
	public String getIdLiga() {
			return idLiga;
		}

		public void setIdLiga(String idLiga) {
			this.idLiga = idLiga;
		}

		public int getDineroDisponible() {
			return dineroDisponible;
		}

		public void setDineroDisponible(int dineroDisponible) {
			this.dineroDisponible = dineroDisponible;
		}

	public UsuarioPublico(String usuario, String contraseina, int idUsuarioPublico,String idLiga, int dineroDisponible) {
		super(usuario, contraseina);
		this.idUsuarioPublico=idUsuarioPublico;
		this.idLiga=idLiga;
		this.dineroDisponible=dineroDisponible;
	}

	public int getIdUsuarioPublico() {
		return idUsuarioPublico;
	}

	public void setIdUsuarioPublico(int idUsuarioPublico) {
		this.idUsuarioPublico = idUsuarioPublico;
	}

}
