package actores;


public class EmpMunicipio extends Usuario{

	public EmpMunicipio(String nick, String contraseña, String email) {
		super.setNick(nick);
		super.setEmail(email);
		super.setContraseña(contraseña);
	}

	public boolean notificarPLIVacio(PuntoLimpioItinerante p) {
		return true;
	}
}
