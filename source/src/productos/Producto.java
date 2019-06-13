package productos;

public class Producto {
	private int ID;
	private String nombre;
	private double ancho;
	private double alto;
	private double largo;

	public Producto(int ID, String nombre, double ancho, double alto, double largo) {
		this.ID = ID;
		this.nombre = nombre;
		this.ancho = ancho;
		this.alto = alto;
		this.largo = largo;
	}

	public double getVolumen() {
		return ((this.alto) * (this.ancho) * (this.largo));
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

}
