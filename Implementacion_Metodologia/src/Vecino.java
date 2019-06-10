import java.util.Vector;
public class Vecino extends Usuario {
	private Vector<ProductoRegistrado> productos;
	
	public Vecino() {
		
	}
	
	public void registrarProducto(Producto producto) {
		ProductoRegistrado productoagregar = new ProductoRegistrado(producto.getID(), producto.getNombre(), 
											producto.getAncho(), producto.getAlto(), producto.getLargo());
		productos.add(productoagregar);
	}
	
	public String getEstadisticasPersonales() {
		
	}
}
