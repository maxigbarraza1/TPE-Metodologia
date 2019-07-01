import java.util.ArrayList;
import java.util.HashMap;

public class FuncionalidadVecino {
	private AccesoBaseDatos b;
	private ArrayList<String> usuarioslog;
	
	public FuncionalidadVecino(AccesoBaseDatos b) {
		this.b = b;
	}

	public void registrar(String n, String c, String e, Ubicacion u) {
		if (!b.verificarUsuario(n))
			b.registrarUsuario(n,c,e,u);
	}

	public boolean login(String nick, String contraseña) {
		if (b.loginUsuario(nick,contraseña)) {
			this.usuarioslog.add(nick);
			return true;
		}
		return false;
	}
	
	public void logout(String nick) {
		this.usuarioslog.remove(nick);
	}

	public void registrarProducto(int id, int cantidad, String nick, int keyPLI) {
		b.registrarProducto(nick, id, cantidad, keyPLI);
	}

	public HashMap<Producto, Integer> getEstadisticasPersonales(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getEstadisticasPersonales(nick);
		return null;
	}

	public HashMap<Integer, Producto> getProductosReciclables(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getProdReciclables();
		return null;
	}

	public ArrayList<ONG> getEstadisticasONG(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getInfoONG();
		return null;
	}

	public HashMap<Producto, Integer> getEstadisticasVecinoPromedio(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getEstadisticasVecinoPromedio();
		return null;
	}

	public HashMap<Integer, Direccion> getDireccionPLIs(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getDireccionPLIs();
		return null;
	}

	public HashMap<String, Ubicacion> getUbicacionCamiones(String nick) {
		if (this.usuarioslog.contains(nick))
			return b.getUbicacionCamiones();
		return null;
	}
}