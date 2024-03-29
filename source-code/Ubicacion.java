public class Ubicacion {

	private Punto coordenada;
	
	public Ubicacion(double x, double y) {
		coordenada.setX(x);
		coordenada.setY(y);
	}

	public Punto getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Punto coordenada) {
		this.coordenada = coordenada;
	}
	
	public boolean equals(Object o) {
		Ubicacion u = (Ubicacion)o;
		return (this.coordenada.equals(u.coordenada));
	}
}