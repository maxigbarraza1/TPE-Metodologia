package actores;
package productos;

import java.util.ArrayList
import java.util.Calendar;
import java.util.HashMap;

import source.src.estadisticas.CalculoEstadisticas;
import source.src.productos.Producto;
import source.src.productos.ProductoRegistrado;


public class Vecino extends Usuario {
	private ArrayList<ProductoRegistrado> productos;
	
	public Vecino(String n, String c, String e) {
		super(n,c,e);
	}
	
	public void registrarProducto(ProductoRegistrado producto) {
		productos.add(producto);
	}
	
	public HashMap<Producto, Integer> getEstadisticasPersonales(Calendar ini, Calendar fin) { 
		//Creamos una variable auxiliar de estadisticas con la finalidad de que calcule las estadisticas que se devolveran en las demas clases
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
