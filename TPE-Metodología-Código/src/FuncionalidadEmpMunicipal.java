import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;

public class FuncionalidadEmpMunicipal {
	private AccesoBaseDatos b;

	public FuncionalidadEmpMunicipal(AccesoBaseDatos b) {
		this.b = b;
	}

	public void cargarHorarios(Calendar inicio, Calendar fin) {
		b.cargarHorarios(inicio, fin);
	}
	
	public void ingresarPLINuevo(double cargaMax, int x, int y, String c, int a) {
		b.ingresarPLINuevo(cargaMax, x, y, c, a);
	}
	
	public void ingresarCamionNuevo(String conductor, String patente, int x, int y) {
		
	}

	public HashMap<Producto, Integer> getEstadisticasHistoricas() {
		return b.getEstadisticasHistoricas();
	}

	public HashMap<Producto, Integer> getEstadisticasGeolocalizadas(Zona z, Calendar inicio, Calendar fin) {
		return b.getEstadisticasGeolocalizadas(z, inicio, fin);
	}

	public HashMap<Producto, Integer> getEstadisticasMensuales(Calendar mes) {
		return b.getEstadisticasMensuales(mes);
	}

	public double getVolumenCargaActual(int keyPLI) {
		return b.getVolumenCargaActual(keyPLI);
	}

	public HashMap<PtoLimpioIt, HashMap<Producto,Integer>> getProductosReciclados() {
		return b.getProductosReciclados();
	}

	public boolean preguntarPLIVacio(int keyPLI) {
		return b.preguntarPLIVacio(keyPLI);
	}

	public boolean preguntarPLILleno(int keyPLI) {
		return b.preguntarPLILleno(keyPLI);
	}

	public HashMap<Integer,Direccion> getDireccionPLs() {
		return b.getDireccionPLs();
	}

	public HashMap<Integer,Direccion> getDireccionPLIs() {
		return b.getDireccionPLIs();
	}

	public HashMap<String,Ubicacion> getUbicacionCamiones() {
		return b.getUbicacionCamiones();
	}
}