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
	
	public HashMap<Producto, Integer> getEstadisticas(ArrayList<ProductoRegistrado> p) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (int i = 0; i < p.size(); i++) {
			if (stats.containsKey(p.get(i).getProducto()))
				stats.put(p.get(i).getProducto(), stats.get(p.get(i).getProducto()) + p.get(i).getCantidad());
			else
				stats.put(p.get(i).getProducto(), p.get(i).getCantidad());
		}
		return stats;
	}
	
	public HashMap<Producto, Integer> getEstadisticasVecinoPromedio(HashMap<String, Vecino> vecinos) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (HashMap.Entry<String, Vecino> entry : vecinos.entrySet()) {
			ArrayList<ProductoRegistrado> productos = entry.getValue().getProductos();
			for (int i = 0; i<productos.size(); i++) {
				if (stats.containsKey(productos.get(i).getProducto())) 
					stats.put(productos.get(i).getProducto(), stats.get(productos.get(i).getProducto()) + productos.get(i).getCantidad());
				else
					stats.put(productos.get(i).getProducto(), productos.get(i).getCantidad());
			}
		}
		for (HashMap.Entry<Producto, Integer> entry : stats.entrySet()) {
			int cantPromedio = (entry.getValue()/stats.size());
			stats.put(entry.getKey(), cantPromedio);
		}
		return stats;
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
	
	public HashMap<Producto, Integer> getEstadisticasGeolocalizadas(Zona z, ArrayList<Vecino> vecinos) {
		HashMap<Producto, Integer> stats = new HashMap<Producto, Integer>();
		for (int i = 0; i < vecinos.size(); i++) {
			if (z.contains(vecinos.get(i).getUbicacion().getCoordenada())) {
				ArrayList<ProductoRegistrado> p = vecinos.get(i).getProductos();
				for (int j = 0; j < p.size(); j++) {
					if ((p.get(i).getFecha().before(fechafin)) && (p.get(i).getFecha().after(fechainicio))) {
						if (stats.containsKey(p.get(i).getProducto()))
							stats.put(p.get(i).getProducto(), stats.get(p.get(i).getProducto()) + p.get(i).getCantidad());
						else
							stats.put(p.get(i).getProducto(), p.get(i).getCantidad());
					}
				}
			}
		}
		return stats;
	}
	
	
	
}