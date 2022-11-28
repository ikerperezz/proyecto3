package clases;

public class Liga {
	private String idLiga;
	private String nombreLiga;
	public String getIdLiga() {
		return idLiga;
	}
	public void setIdLiga(String idLiga) {
		this.idLiga = idLiga;
	}
	public String getNombreLiga() {
		return nombreLiga;
	}
	public void setNombreLiga(String nombreLiga) {
		this.nombreLiga = nombreLiga;
	}
	public Liga(String idLiga, String nombreLiga) {
		super();
		this.idLiga = idLiga;
		this.nombreLiga = nombreLiga;
	}
	
}
