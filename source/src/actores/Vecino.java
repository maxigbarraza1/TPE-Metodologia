package actores;
import java.util.Vector;
public class Vecino extends Usuario {
	private Vector<ProductoRegistrado> productos;
	
	public Vecino() {
		
	}
	
	public void registrarProducto(Producto producto, int cantidad) {
		ProductoRegistrado productoagregar = new ProductoRegistrado(producto, cantidad);
		productos.add(productoagregar);
	}
	
	public String getEstadisticasPersonales() {
		return "Maxi se la come";
	}
}
