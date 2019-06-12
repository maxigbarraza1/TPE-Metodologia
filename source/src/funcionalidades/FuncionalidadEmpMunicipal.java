package funcionalidades;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import actores.Usuario;
import actores.Vecino;
import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Ubicacion;
import estadisticas.CalculoEstadisticas;


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

	public HashMap<Producto,Integer> getEstadisticasHistoricas(){
		Calendar fin;
		Calendar inicio;
		ArrayList<Usuario> users = (ArrayList<Usuario>)b.getUsuarios().values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i=0;i<users.size();i++) {
			productos.addAll(((Vecino)users.get(i)).getProductos());
		}
		CalculoEstadisticas aux=new CalculoEstadisticas(inicio,fin.getTime());
		
		return (aux.getEstadisticasPorFecha(productos));
		
	}

	public Hashtable<Producto,Integer> getEstadisticasGeolocalizadas(Zona z){
		ArrayList<Usuario> users = (ArrayList<Usuario>)b.getUsuarios().values();
		for (int i=0;i<users.size();i++) {
			if ((Vecino)users.get(i)i)
		}

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

public double getVolumenCargaActual() {
	
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