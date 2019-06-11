package actores;

import java.util.Vector;

import productos.Producto;
import productos.ProductoRegistrado;

public class Vecino extends Usuario {
	private Vector<ProductoRegistrado> productos;
	
	public Vecino(String nick, String contrase�a, String email) {
		super.setNick(nick);
		super.setEmail(email);
		super.setContrase�a(contrase�a);
	}
	
	public void registrarProducto(Producto producto, int cantidad) {
		ProductoRegistrado productoagregar = new ProductoRegistrado(producto, cantidad);
		productos.add(productoagregar);
	}
	
	public String getEstadisticasPersonales() {
		return "Maxi se la come";
	}
}
