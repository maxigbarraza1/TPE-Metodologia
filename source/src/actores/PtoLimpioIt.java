package actores;
import java.util.Calendar;

import productos.ProductoRegistrado;
import ubicaciones.Direccion;

import java.util.ArrayList;

public class PtoLimpioIt{
	private ArrayList<ProductoRegistrado> productosdentro; 
	private double cargaMax;
	private Calendar h_apertura;
	private Calendar h_cierre;
	private Direccion direccion;
	
	public PtoLimpioIt(double cargaMax, Calendar h_apertura, Calendar h_cierre, Direccion direccion) {
		this.h_apertura=h_apertura;
		this.h_cierre=h_cierre;
		this.cargaMax=cargaMax;
		this.direccion=direccion;
		this.productosdentro= new ArrayList<ProductoRegistrado>();
	}
	
	public double getCargamax() {
		return cargaMax;
	}

	public void setCargamax(double cargaMax) {
		this.cargaMax = cargaMax;
	}

	public Calendar getH_apertura() {
		return h_apertura;
	}

	public void setH_apertura(Calendar h_apertura) {
		this.h_apertura = h_apertura;
	}

	public Calendar getH_cierre() {
		return h_cierre;
	}

	public void setH_cierre(Calendar h_cierre) {
		this.h_cierre = h_cierre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public double getVolumenActual() {
		double volumen=0;
		 for (int i=0; i<productosdentro.size();i++){
			 volumen=volumen+productosdentro.get(i).getVolumen();
		 }
		return volumen;
	}
	
	public boolean estaVacio() {
		return productosdentro.isEmpty();
	}
	
	public boolean estaLleno() {
		return (this.getVolumenActual()>=this.cargaMax);
	}
	
	public void vaciar() {
		for (int j=0; j<productosdentro.size();)
			this.productosdentro.remove(j);
	}
	
	public boolean entraProducto(double volumen) {
		return ((this.cargaMax-this.getVolumenActual())>volumen);
	}

	public void addProducto(ProductoRegistrado producto) {
		productosdentro.add(producto);
	}
}
