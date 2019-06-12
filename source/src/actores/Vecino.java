package actores;

import java.util.List;

import productos.Producto;
import productos.ProductoRegistrado;

public class Vecino extends Usuario {
	private List<ProductoRegistrado> productos;
	
	public Vecino(String n, String c, String e) {
		super(n,c,e);
	}
	
	public void registrarProducto(ProductoRegistrado producto, int cantidad) {
		//ProductoRegistrado productoagregar = new ProductoRegistrado(producto, cantidad);     //Se hace en Acceso Base de datos
		productos.add(producto);
	}
	
	public String getEstadisticasPersonales() {
		return "Maxi se la come";
	}
}
