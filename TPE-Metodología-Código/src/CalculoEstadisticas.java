import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CalculoEstadisticas {
	private Calendar fechainicio;
	private Calendar fechafin;

	public CalculoEstadisticas() {
		this.fechainicio = null;
		this.fechafin = null;
	}
	
	public CalculoEstadisticas(Calendar fechaini, Calendar fechaf) {
		this.fechainicio = fechaini;
		this.fechafin = fechaf;
	}

	public HashMap<Producto, Integer> getEstadisticasPorFecha(ArrayList<ProductoRegistrado> p) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (int i = 0; i < p.size(); i++) { // Recorro toda la lista p
			if ((p.get(i).getFecha().before(fechafin)) && (p.get(i).getFecha().after(fechainicio))) { // Si esta dentro de las fechas
				if (stats.containsKey(p.get(i).getProducto())) // Si el mapa ya contiene el producto a agregar
					stats.put(p.get(i).getProducto(), stats.get(p.get(i).getProducto()) + p.get(i).getCantidad()); // Agrego el producto y sumo las cantidades 
				else
					stats.put(p.get(i).getProducto(), p.get(i).getCantidad()); // Agrego el producto con su cantidad correspondiente
			}
		}
		return stats;
	}
	
	public HashMap<Producto, Integer> getEstadisticasHistoricas(ArrayList<ProductoRegistrado> p) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (int i = 0; i < p.size(); i++) {
			if (stats.containsKey(p.get(i).getProducto()))
				stats.put(p.get(i).getProducto(), stats.get(p.get(i).getProducto()) + p.get(i).getCantidad());
			else
				stats.put(p.get(i).getProducto(), p.get(i).getCantidad());
		}
		return stats;
	}
}