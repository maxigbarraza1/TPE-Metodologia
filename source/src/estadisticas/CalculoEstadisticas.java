package estadisticas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import productos.Producto;
import productos.ProductoRegistrado;

public class CalculoEstadisticas {
	private Calendar fechafin;
	private Calendar fechainicio;

	public CalculoEstadisticas(Calendar fechaf, Calendar fechaini) {
		this.fechafin = fechaf;
		this.fechainicio = fechaini;
	}

	public HashMap<Producto, Integer> getEstadisticasPorFecha(ArrayList<ProductoRegistrado> p) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (int i = 0; i < p.size(); i++) { // Recorro toda la lista p
			if ((p.get(i).getFecha().before(fechafin)) && (p.get(i).getFecha().after(fechainicio))) { // Si esta dentro
																										// de las fechas
				if (stats.containsKey(p.get(i))) { // Si el mapa ya contiene el producto a agregar
					stats.put(p.get(i).getProducto(), stats.get(p.get(i)) + p.get(i).getCantidad()); // Agrego el
																										// producto y
																										// sumo las
																										// cantidades
				} else // si no...
					stats.put(p.get(i).getProducto(), p.get(i).getCantidad()); // Agrego el producto con su cantidad
																				// correspondiente
			}
		}
		return stats;
	}
}
