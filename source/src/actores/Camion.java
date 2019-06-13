package actores;

import ubicaciones.Ubicacion;

public class Camion {
	private String patente;
	private String conductor;
	private Ubicacion ubicacion;

	public Camion(String patente, String conductor, Ubicacion ubicacion) {
		this.conductor = conductor;
		this.patente = patente;
		this.ubicacion = ubicacion;
	}

	// GETS y SETS
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	// Se actualizaria en tiempo real .la ubicacion
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

}
