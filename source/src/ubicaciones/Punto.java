package ubicaciones;

public class Punto {
	
//Estructura
	private double x;
	private double y;
	
	
//Constructores
	public Punto(double CordX,double CordY) {
		this.x=CordX;
		this.y=CordY;
	}

//Metodos
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public boolean equals (Punto p) {
		return (p.getX()==this.x && p.getY()==this.y);
	}
	
	public double distancia(Punto p) {
		double a = (p.getX() - this.getX());
		double b = (p.getY() - this.getY());
		return Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2));
	}
}
