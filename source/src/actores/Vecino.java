package actores;

import java.util.Vector;

import productos.Producto;
import productos.ProductoRegistrado;

public class Vecino extends Usuario {
	private Vector<ProductoRegistrado> productos;
	
	public Vecino(String nick, String contraseña, String email) {
		super.setNick(nick);
		super.setEmail(email);
		super.setContraseña(contraseña);
	}
	
	public void registrarProducto(ProductoRegistrado producto, int cantidad) {
		//ProductoRegistrado productoagregar = new ProductoRegistrado(producto, cantidad);     //Se hace en Acceso Base de datos
		productos.add(producto);
	}
	
	public String getEstadisticasPersonales() {
		return "Maxi se la come";
	}
}
