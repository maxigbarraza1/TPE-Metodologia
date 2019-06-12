package funcionalidades;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Ubicacion;

public class FuncionalidadEmpMunicipal {
	
//Estructura
	
//Constructor
	public FuncionalidadEmpMunicipal() {
		// TODO Auto-generated constructor stub
	}
	
//Metodos
	public void cargarHorarios(Calendar inicio,Calendar fin) {
		
	}	
	
	public ArrayList<ProductoRegistrado> getEstadisticasHistoricas(){
		return null;
		
	}
	
	public Hashtable<Producto,Integer> getEstadisticasGeolocalizadas(){
		return null;
	}
	
	public Hashtable<Producto,Integer> getEstadisticasMensuales(){
		return null;
	}
	
	public double getVolumenCargaActual() {
		return 1;
	}
	
	
	public Hashtable<Producto,Integer> getProductosReciclados(){
		return null;
	}
	
	public void notificarPLIVacio() {
		
	}
	
	public void notificarPLILleno() {

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
