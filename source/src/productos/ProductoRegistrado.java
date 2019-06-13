package productos;

import java.util.Calendar;

public class ProductoRegistrado {

	private int cantidad;
	private Calendar fecha;
	private Producto producto;

	public ProductoRegistrado(Producto producto_a_usar, int cantidad_produc) {
		this.fecha.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
		this.setCantidad(cantidad_produc);
		this.producto = producto_a_usar;
	}

	public double getVolumen() {
		return this.producto.getVolumen();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	public boolean equals (ProductoRegistrado p) {
		return ((this.producto.getID()==p.getProducto().getID()) && (this.getCantidad()==p.getCantidad()) && (this.fecha == p.getFecha()));
	}
}
