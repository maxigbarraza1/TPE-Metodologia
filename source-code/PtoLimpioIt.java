import java.util.ArrayList;
import java.util.HashMap;

public class PtoLimpioIt {
	private ArrayList<ProductoRegistrado> productosdentro;
	private double cargaMax;
	private Direccion direccion;

	public PtoLimpioIt(double cargaMax, Direccion direccion) {
		this.cargaMax = cargaMax;
		this.direccion = direccion;
		this.productosdentro = new ArrayList<ProductoRegistrado>();
	}

	public double getCargamax() {
		return cargaMax;
	}

	public void setCargamax(double cargamax) {
		this.cargaMax = cargamax;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public double getVolumenActual() {
		double volumen = 0;
		for (int i = 0; i < productosdentro.size(); i++) {
			volumen = volumen + productosdentro.get(i).getVolumen();
		}
		return volumen;
	}
	
	public HashMap<Producto, Integer> getProductosReciclados() {
		HashMap<Producto, Integer> p = new HashMap<Producto, Integer>();
		for(int i = 0; i<this.productosdentro.size(); i++) {
			p.put(this.productosdentro.get(i).getProducto(), this.productosdentro.get(i).getCantidad());
		}
		return p;
	}

	public boolean estaVacio() {
		return productosdentro.isEmpty();
	}

	public boolean estaLleno() {
		return (this.getVolumenActual() >= this.cargaMax);
	}

	public void vaciar() {
		productosdentro.clear();
	}

	public boolean entraProducto(double v) {
		return ((this.getVolumenActual()+v)<=this.cargaMax);
	}

	public void addProducto(ProductoRegistrado producto) {
		this.productosdentro.add(producto);
	}
}