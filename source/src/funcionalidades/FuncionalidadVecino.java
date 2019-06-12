package funcionalidades;
import java.util.ArrayList;

import actores.PuntoLimpioItinerante;
import funcionalidades.AccesoBaseDatos;

public class FuncionalidadVecino {
	
//Estructura
	private AccesoBaseDatos b;
	private String nick;
	
//Constructor	

///Metodos
	public FuncionalidadVecino(AccesoBaseDatos b) {
		this.b=b;
	}
	public void registrar(String nick,String contraseņa,String email) {
		if (!b.verificarUsario(nick))
			b.registrarUsuario(nick, contraseņa, email);
			
	}
	public boolean login(String nick,String contraseņa) {             //Verifica con la base de datos que los 
		if (b.loginUsuario(nick, contraseņa)) {						  //datos suministrados son correspondientes
			this.nick=nick;											  // a un usuario, de ser asi guarda el nick 
			return true;											  //y asi poder hacer las consultas proximas sobre ese nick
		}
		return false;
	}
	
	public void registrarProducto(int id,int cantidad) {
		if (b.verificarIdProducto(id)) {
			ArrayList<PuntoLimpioItinerante> aux= b.getPtosRecoleccion();
			
		}
	}
	
}
