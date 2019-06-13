package actores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import estadisticas.CalculoEstadisticas;
import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Ubicacion;

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

	public HashMap<Producto, Integer> getEstadisticasPersonales(Calendar ini, Calendar fin) {
		// Creamos una variable auxiliar de estadisticas con la finalidad de que calcule
		// las estadisticas que se devolveran en las demas clases
		CalculoEstadisticas aux = new CalculoEstadisticas(ini, fin);
		return aux.getEstadisticasPorFecha(this.productos);
	}

	public ArrayList<ProductoRegistrado> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoRegistrado> productos) {
		this.productos = productos;
	}
}
