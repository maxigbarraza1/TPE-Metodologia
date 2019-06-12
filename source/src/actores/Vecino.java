package actores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import estadisticas.CalculoEstadisticas;

import java.util.Calendar;
import productos.Producto;
import productos.ProductoRegistrado;


public class Vecino extends Usuario {
	private ArrayList<ProductoRegistrado> productos;
	
	public Vecino(String nick, String contraseña, String email) {
		super.setNick(nick);
		super.setEmail(email);
		super.setContraseña(contraseña);
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
