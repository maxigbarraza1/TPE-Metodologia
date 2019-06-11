package estadisticas;

import productos.Producto;

public class EstadisticaIndividual extends Estadistica{
	
//Estructura
	private Producto producto;										//Esta estadistica se utiliza para generar una estadistica sobre un
	private double volumen;											//producto en particular
	
//Constructor
	public EstadisticaIndividual(Producto p, double v) {
		this.producto=p;
		this.volumen=v;
	}

//Metodos
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	@Override
	public Estadistica getEstadistica() {
		// TODO Auto-generated method stub
		return null;
	}

}
