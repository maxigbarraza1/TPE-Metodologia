package funcionalidades;
import java.util.ArrayList;

import actores.PuntoLimpioItinerante;
import funcionalidades.AccesoBaseDatos;

public class FuncionalidadVecino {
	private AccesoBaseDatos b;
	private String nick;
	public FuncionalidadVecino(AccesoBaseDatos b) {
		this.b=b;
	}
	public void registrar(String nick,String contrase�a,String email) {
		if (!b.verificarUsario(nick))
			b.registrarUsuario(nick, contrase�a, email);
			
	}
	public boolean login(String nick,String contrase�a) {             //Verifica con la base de datos que los 
		if (b.loginUsuario(nick, contrase�a)) {						  //datos suministrados son correspondientes
			this.nick=nick;											  // a un usuario, de ser asi guarda el nick 
			return true;											  //y asi poder hacer las consultas proximas sobre ese nick
		}
		return false;
	}
	public void registrarProducto(int id,int cantidad) {
		if (b.verificarIdProducto(id))
			ArrayList<PuntoLimpioItinerante> aux= b.getPtosRecoleccion();
	}
}
