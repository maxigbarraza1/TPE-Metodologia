package ubicaciones;

import java.util.Vector;

import estadisticas.Estadistica;

public class Direccion extends Ubicacion {										//Es necesaria la clase calle? Podriamos tomar como manzana
																				//y dejar solo la clase zona respetando la forma del rectangulo
//Estructura																	// Aunque si queremos mostrar la ubicacion del camion la tenemos que tener
	private String calle;
	private int altura;
	
//Constructor
	public Direccion(double x, double y, String c, int alt) {
		super(x, y);
		this.calle=c;
		this.altura=alt;
	}
	
//Metodos
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String toString() {                                                             //Sirve para cuando necesitamos
		
		String devolucion= (this.getCalle()+" "+this.getAltura());                         //comparar dos direcciones, le 
		return devolucion;                                                                 //pedimos el toString y comparamos
	}
	public boolean equals(Direccion d) {
		if((d.getAltura() == this.getAltura()) && (d.getCalle() == this.getCalle()))
			return true;
		return false;
	}
//	public Vector<Estadistica> getEstadisticas() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public Object getUbicacion() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
