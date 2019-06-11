package estadisticas;

import java.util.Calendar;

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
	
	public abstract Estadistica getEstadistica();
	

}
