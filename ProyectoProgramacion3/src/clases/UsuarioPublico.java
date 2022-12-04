package clases;

public class UsuarioPublico extends Usuario {
	private int idUsuarioPublico;
	private int idLiga;
	private int dineroDisponible;
	private static int puntos;

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(int dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}

	public UsuarioPublico(String usuario, String contraseina, int idUsuarioPublico, int idLiga, int dineroDisponible,
			int puntos) {
		super(usuario, contraseina);
		this.idUsuarioPublico = idUsuarioPublico;
		this.idLiga = idLiga;
		this.dineroDisponible = dineroDisponible;
	}

	public int getIdUsuarioPublico() {
		return idUsuarioPublico;
	}

	public void setIdUsuarioPublico(int idUsuarioPublico) {
		this.idUsuarioPublico = idUsuarioPublico;
	}

	@Override
	public String toString() {
		return usuario + "-" + puntos;
	}

	public static int compare(int puntos1, int puntos2) {
		if(puntos1 > puntos2) {
			return puntos1;
		
		}else {
			if(puntos1 > puntos2) {
				return puntos2;
			}
		}
		return puntos;
	}
	
	@Override   //criterio de igualdad
	public boolean equals(Object o) {
		
		if (!(o instanceof Usuario)) {
			return false; }
		
		
		UsuarioPublico p=(UsuarioPublico) o;
		
		boolean condicion=(this.idUsuarioPublico==(p.idUsuarioPublico)) && 
		(this.idLiga==(p.idLiga)) && (this.dineroDisponible==(p.dineroDisponible))&&
		(this.puntos==(p.puntos) && (this.usuario.equals(p.usuario)) 
		&& (this.getContraseina().equals(p.getContraseina())));
		
		return condicion;
		
	}
}
