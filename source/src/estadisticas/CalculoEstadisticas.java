import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashMap;

import productos.Producto;
import productos.ProductoRegistrado;
package estadisticas;


public class CalculoEstadisticas {
	private Calendar fechafin;
	private Calendar fechainicio;
	
	public CalculoEstadisticas(Calendar fechaf, Calendar fechaini) {
		this.fechafin=fechaf;
		this.fechainicio=fechaini;
	}
	
	public HashMap<Producto, Integer> getEstadisticasPorFecha(ArrayList<ProductoRegistrado> p) {
		for (int i=0; i<p.size();i++) {
			if (p.get(i).getFecha())
		}
	}
}
