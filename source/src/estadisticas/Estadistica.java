package estadisticas;

import java.util.Calendar;
import java.util.Vector;
import java.util.Hashtable;
import productos.Producto;

public abstract class Estadistica {
	
//Estructura
	private Calendar fecha;

	
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
	
	public Hashtable<Producto,Integer> getEstadistica(Vector<Producto> p){
	
		
	}

}
