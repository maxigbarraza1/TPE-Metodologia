
public class mainDePrueba {

	public static void main(String[] args) {
		AccesoBaseDatos a = new AccesoBaseDatos();
		FuncionalidadVecino fv = new FuncionalidadVecino(a);
		Ubicacion u1 = new Ubicacion(1,1);
		fv.registrar("Maxi A", "1234", "maxi.alonso@hotmail.com.ar", u1);
		Ubicacion u2 = new Ubicacion(1,2);
		fv.registrar("Maxi B", "1234", "maxi.barraza@gmail.com", u2);
		Ubicacion u3 = new Ubicacion(2,1);
		fv.registrar("Juan T", "1234", "juanmatripodi@gmail.com", u3);
		String nick = "";
		String contraseña = "";
		if (!fv.login(nick, contraseña)) {
			//MENSAJE DE ERROR
		}
		
	}
}
