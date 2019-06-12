package estadisticas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import productos.ProductoRegistrado;

public class Estadistica {
	
//Estructura
	private Calendar fecha;
	Hashtable<ProductoRegistrado,Integer> productos;

	
//Constructor
	public Estadistica() {
		// TODO Auto-generated constructor stub
	}
	
//Metodos
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public Hashtable<ProductoRegistrado,Integer> getProductos(){
		return this.productos;
	}

}
