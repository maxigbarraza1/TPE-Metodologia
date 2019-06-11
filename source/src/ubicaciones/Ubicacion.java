package ubicaciones;

import java.util.Vector;

import estadisticas.Estadistica;


public abstract class Ubicacion {

	private Punto coordenada;
	
	public Ubicacion (double x, double y) {
		coordenada.setX(x);
		coordenada.setY(y);
	}

	public Punto getCoordenada() {
		return coordenada;											
	}																

	public void setCoordenada(Punto coordenada) {
		this.coordenada = coordenada;
	}
	
	public abstract Vector<Estadistica> getEstadisticas();			//Aca esta el estadisticas por zona
	

}
