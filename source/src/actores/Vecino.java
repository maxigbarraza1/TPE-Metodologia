package actores;

import java.util.HashMap;
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
	
	public void registrarProducto(ProductoRegistrado producto) {
		productos.add(producto);
	}
	
	public HashMap<Producto, Integer> getEstadisticasPersonales() {
			HashMap<Producto, Integer> mapaestadisticas = new HashMap<Producto,Integer>();
			for (int j=0;j<this.productos.size();j++) {
				if (mapaestadisticas.containsKey(this.productos.get(j).getProducto()))
					mapaestadisticas.put((this.productos.get(j).getProducto()), 
											mapaestadisticas.get(this.productos.get(j).getProducto())+1);
				else
					mapaestadisticas.put((this.productos.get(j).getProducto()), 1);	
			}
			return mapaestadisticas;
	}
}
