package funcionalidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;

import actores.Usuario;
import actores.Vecino;
import estadisticas.CalculoEstadisticas;
import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Punto;
import ubicaciones.Ubicacion;
import ubicaciones.Zona;

public class FuncionalidadEmpMunicipal {

//Estructura
	AccesoBaseDatos b;

//Constructor
	public FuncionalidadEmpMunicipal(AccesoBaseDatos b) {
		this.b = b;
	}

//Metodos
	public void cargarHorarios(Calendar inicio, Calendar fin) {
		b.cargarHorarios(inicio, fin);
	}

	//[Estadisticas]
	public HashMap<Producto, Integer> getEstadisticasHistoricas(Calendar inicio, Calendar fin) {
		ArrayList<Usuario> users = (ArrayList<Usuario>) b.getUsuarios().values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < users.size(); i++) {
			productos.addAll(((Vecino) users.get(i)).getProductos());
		}
		CalculoEstadisticas aux = new CalculoEstadisticas(inicio, fin);
		return (aux.getEstadisticasPorFecha(productos));
	}

	public HashMap<Producto, Integer> getEstadisticasGeolocalizadas(Zona z, Calendar inicio, Calendar fin) {
		ArrayList<Usuario> users = (ArrayList<Usuario>) b.getUsuarios().values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < users.size(); i++) {
			Punto aux = ((Vecino) users.get(i)).getUbicacion().getCoordenada();
			if (z.contains(aux)) {
				productos.addAll(((Vecino) users.get(i)).getProductos());
			}
		}
		CalculoEstadisticas retorno = new CalculoEstadisticas(inicio, fin);
		return (retorno.getEstadisticasPorFecha(productos));
	}

	public HashMap<Producto, Integer> getEstadisticasMensuales(AccesoBaseDatos bDatos, Calendar mes) {
		ArrayList<Usuario> users = (ArrayList<Usuario>) b.getUsuarios().values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < users.size(); i++) {
			if (((Vecino) users.get(i)).getProductos().get(i).getFecha().equals(mes)) {
				productos.addAll(((Vecino) users.get(i)).getProductos());
			}
		}
		CalculoEstadisticas retorno = new CalculoEstadisticas(mes, mes);
		return (retorno.getEstadisticasPorFecha(productos));
	}

	public double getVolumenCargaActual() {

	}

	public Hashtable<Producto, Integer> getProductosReciclados() {
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

	public ArrayList<Ubicacion> getUbicacionCamiones() {
		return null;
	}
}