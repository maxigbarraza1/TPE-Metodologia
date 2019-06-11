package ubicaciones;

import java.util.Vector;

import estadisticas.Estadistica;

public class Zona extends Ubicacion{
	

//Estructura
	private int altura;											//Se definio la zona como un rectangulo, por lo tanto hereda
	private int ancho;											//el punto la clase Ubicacion, y por la altura y el ancho genera el rectangulo
	
	
//Constructor
	public Zona(double x, double y,int w,int h) {
		super(x, y);
		this.altura=w;
		this.ancho=h;
	}
	
//Metodos
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	//Para ver si un punto esta dentro de nuestra zona
	public boolean contains (Punto p) {
		Punto aux=this.getCoordenada();
		return (aux.getX() < p.getX() &&
				aux.getY() < p.getY() &&
				aux.getX() + this.getAncho() > p.getX() &&
				aux.getY() + this.getAltura() >p.getY());
	}

	@Override
	public Vector<Estadistica> getEstadisticas() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
