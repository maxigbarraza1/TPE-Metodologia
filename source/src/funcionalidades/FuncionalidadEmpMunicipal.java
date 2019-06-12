package funcionalidades;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import estadisticas.Estadistica;
import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Ubicacion;


public class FuncionalidadEmpMunicipal {
	//Estructura

	AccesoBaseDatos b;

	//Constructor

	public FuncionalidadEmpMunicipal(AccesoBaseDatos b) {		
		this.b=b;
	}

	//Metodos

	public void cargarHorarios(Calendar inicio,Calendar fin) {
		b.cargarHorarios(inicio, fin);
	}	

	public ArrayList<Estadistica> getEstadisticasHistoricas(AccesoBaseDatos bDatos){
		return (bDatos.getEstadisticas());
	}

	public Hashtable<Producto,Integer> getEstadisticasGeolocalizadas(){
		return null;
	}

	
	public ArrayList<Estadistica> getEstadisticasMensuales(AccesoBaseDatos bDatos,Calendar walter ){
		ArrayList<Estadistica> aux= new ArrayList<Estadistica>();
		if (bDatos.getEstadisticas().isEmpty()) {
			return null;
		}
		else {

			
		}

	return aux;
}

	public double getVolumenCargaActual(PtoLimpioIt p) {
		return p.
	}

public Hashtable<Producto,Integer> getProductosReciclados(){
	return null;
}

	

	public void notificarPLIVacio() {

		

	}

	

	public void notificarPLILleno() {

		asd



	}

	

	public Ubicacion getUbicacionPL() {

		return null;

	}

	

	public Ubicacion getUbicacionPLI() {

		return null;

	}

	

	public ArrayList<Ubicacion> getUbicacionCamiones(){
		return null;
	}
}