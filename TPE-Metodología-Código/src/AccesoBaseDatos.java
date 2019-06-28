import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AccesoBaseDatos {
	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Vecino> vecinos;
	private HashMap<Integer, Producto> prodReciclables; //HashMap con <id,Producto> para facilitar la búsqueda
	private HashMap<Integer,PuntoLimpio> PLs;
	private HashMap<Integer,PtoLimpioIt> PLIs;
	private ArrayList<String> infoONG;
	private HashMap<Integer, Camion> camiones;
	private Calendar hapertura;
	private Calendar hcierre;
	private int keyPLIS; //Variable para ir controlando y actualizando la key de los PLIS
	private int keyCAMIONES;

	public AccesoBaseDatos() {
		this.usuarios = new HashMap<String, Usuario>();
		this.vecinos = new HashMap<String,Vecino>();
		this.prodReciclables = new HashMap<Integer, Producto>();
		this.PLs = new HashMap<Integer,PuntoLimpio>();
		this.PLIs = new HashMap<Integer,PtoLimpioIt>();
		this.infoONG = new ArrayList<String>();
		this.camiones = new HashMap<Integer, Camion>();
		this.keyPLIS = 0;
		this.keyCAMIONES = 0;
	}

	public void cargarHorarios(Calendar inicio, Calendar fin) {
		this.hapertura = inicio;
		this.hcierre = fin;
	}

	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public HashMap<Integer, Producto> getProdReciclables() {
		return prodReciclables;
	}

	public void ProdReciclables(HashMap<Integer, Producto> prodreciclables) {
		this.prodReciclables = prodreciclables;
	}

	public void addProdReciclable(Producto p) {
		this.prodReciclables.put(p.getID(), p);
	}

	public HashMap<Integer,PtoLimpioIt> getPtosRecoleccion() {
		return this.PLIs;
	}

	public void setPLs(HashMap<Integer,PuntoLimpio> pLs) {
		PLs = pLs;
	}

	public void setPLIs(HashMap<Integer,PtoLimpioIt> pLIs) {
		PLIs = pLIs;
	}
	
	public void ingresarPLINuevo(double cargaMax, int x, int y, String c, int a) {
		Direccion d = new Direccion(x,y,c,a);
		PtoLimpioIt p = new PtoLimpioIt(cargaMax,d);
		this.PLIs.put(keyPLIS, p);
		this.keyPLIS++;
	}

	public ArrayList<String> getInfoONG() {
		return infoONG;
	}

	public void setInfoONG(ArrayList<String> infoONG) {
		this.infoONG = infoONG;
	}

	public boolean loginUsuario(String nick, String contraseña) {
		if (this.verificarUsuario(nick))
			return (this.usuarios.get(nick).getContraseña().equals(contraseña));
		return false;
	}
	
	public Vecino getVecino(String nick) {
		return vecinos.get(nick);
	}
	
	public void registrarProducto(String nick, int id, int cantidad, int keyPLI) {
		Vecino vecino = this.vecinos.get(nick); //Busco el vecino con el nick
		if (this.verificarIdProducto(id))
			if ((cantidad < 100) && (cantidad > 0)) { //Acoto la cantidad del producto a registrar
				ProductoRegistrado pregistrado = new ProductoRegistrado(this.prodReciclables.get(id), cantidad);
				PLIs.get(keyPLI).addProducto(pregistrado);
				vecino.registrarProducto(pregistrado);
			}
	}

	// Verifica si el nick ha sido registrado
	
	public boolean verificarUsuario(String nick) {
		return this.usuarios.containsKey(nick);
	}

	public void registrarUsuario(String n, String c, String e, Ubicacion u) {
		Vecino aux = new Vecino(n,c,e,u);
		this.usuarios.put(n,aux);
		this.vecinos.put(n,aux);
	}

	// Verifica la existencia de un producto reciclabe con el id ingresado
	
	public boolean verificarIdProducto(int iD) {
		return (this.prodReciclables.containsKey(iD));
	}

	public HashMap<Producto,Integer> getEstadisticasPersonales(String nick, Calendar ini, Calendar fin) {
		Usuario user = this.usuarios.get(nick);
		return ((Vecino)user).getEstadisticasPersonales(ini, fin);
	}

	public HashMap<Producto, Integer> getEstadisticasCiudad(Calendar ini, Calendar fin) {
		ArrayList<Vecino> vecinos = (ArrayList<Vecino>)this.vecinos.values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < vecinos.size(); i++) {
			productos.addAll((vecinos.get(i)).getProductos());
		}
		CalculoEstadisticas aux = new CalculoEstadisticas(ini, fin); //Variable aux de estadísticas para calcular las estadísticas que se devolverán en lase demas clases.
		return aux.getEstadisticasPorFecha(productos);
	}
	
	public HashMap<Producto, Integer> getEstadisticasHistoricas() {
		ArrayList<Vecino> vecinos = (ArrayList<Vecino>)this.vecinos.values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < vecinos.size(); i++) {
			productos.addAll((vecinos.get(i)).getProductos());
		}
		CalculoEstadisticas aux = new CalculoEstadisticas();
		return aux.getEstadisticasPorFecha(productos);
	}
	
	public HashMap<Producto, Integer> getEstadisticasGeolocalizadas(Zona z, Calendar inicio, Calendar fin) {
		ArrayList<Usuario> users = (ArrayList<Usuario>)this.getUsuarios().values();
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
	
	public HashMap<Producto, Integer> getEstadisticasMensuales(Calendar mes) {
		ArrayList<Usuario> users = (ArrayList<Usuario>)this.getUsuarios().values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i = 0; i < users.size(); i++) {
			if (((Vecino) users.get(i)).getProductos().get(i).getFecha().equals(mes)) {
				productos.addAll(((Vecino) users.get(i)).getProductos());
			}
		}
		CalculoEstadisticas retorno = new CalculoEstadisticas(mes, mes);
		return (retorno.getEstadisticasPorFecha(productos));
	}
	
	public HashMap<PtoLimpioIt,HashMap<Producto, Integer>> getProductosReciclados() {
		HashMap<PtoLimpioIt,HashMap<Producto, Integer>> p = new HashMap<PtoLimpioIt,HashMap<Producto, Integer>>();
		for(int i = 0; i<this.PLIs.size(); i++) {
			p.put(this.PLIs.get(i), this.PLIs.get(i).getProductosReciclados());
		}
		return p;
	}

	public HashMap<String,Ubicacion> getUbicacionCamiones() {
		HashMap<String,Ubicacion> u = new HashMap<String,Ubicacion>();
		for (int i = 0; i < this.camiones.size(); i++) {
			u.put(this.camiones.get(i).getPatente(), this.camiones.get(i).getUbicacion());
		}
		return u;
	}

	public HashMap<Integer, Direccion> getDireccionPLIs() {
		HashMap<Integer, Direccion> d = new HashMap<Integer,Direccion>();
		for (int i=0;i<PLIs.size();i++) {
			d.put(i, this.PLIs.get(i).getDireccion());
		}
		return d;
	}

	public double getVolumenCargaActual(int key) {
		return this.PLIs.get(key).getVolumenActual();
	}

	public boolean preguntarPLIVacio(int key) {
		return this.PLIs.get(key).estaVacio();
	}

	public boolean preguntarPLILleno(int key) {
		return this.PLIs.get(key).estaLleno();
	}
	
	public HashMap<Integer, Direccion> getDireccionPLs() {
		HashMap<Integer, Direccion> d = new HashMap<Integer, Direccion>();
		for(int i = 0; i<this.PLs.size(); i++) {
			d.put(i, this.PLs.get(i).getDireccion());
		}
		return d;
	}
	
	public void ingresarCamionNuevo(String conductor, String patente, int x, int y) {
		Ubicacion u = new Ubicacion(x,y);
		Camion c = new Camion(conductor,patente,u);
		this.camiones.put(keyCAMIONES,c);
		this.keyCAMIONES++;
	}
}