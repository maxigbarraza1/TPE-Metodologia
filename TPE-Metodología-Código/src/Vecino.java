import java.util.ArrayList;
import java.util.HashMap;

public class Vecino extends Usuario {
	private ArrayList<ProductoRegistrado> productos;
	private Ubicacion ubicacion;

	public Vecino(String n, String c, String e, Ubicacion u) {
		super(n,c,e);
		this.ubicacion = u;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void registrarProducto(ProductoRegistrado producto) {
		productos.add(producto);
	}

	public HashMap<Producto, Integer> getEstadisticasPersonales() {
		CalculoEstadisticas aux = new CalculoEstadisticas();
		return aux.getEstadisticas(this.getProductos());
	}

	public ArrayList<ProductoRegistrado> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoRegistrado> productos) {
		this.productos = productos;
	}
}