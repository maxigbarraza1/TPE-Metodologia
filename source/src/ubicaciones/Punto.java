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

}
