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

	@Override
	public Vector<Estadistica> getEstadisticas() {
		// TODO Auto-generated method stub
		return null;
	}

}
