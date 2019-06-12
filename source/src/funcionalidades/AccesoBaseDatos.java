	package funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import actores.Camion;
import actores.EmpMunicipio;
import actores.PuntoLimpio;
import actores.PuntoLimpioItinerante;
import actores.Usuario;
import actores.Vecino;
import estadisticas.CalculoEstadisticas;
import productos.Producto;
import productos.ProductoRegistrado;
import ubicaciones.Direccion;
import ubicaciones.Ubicacion;
public class AccesoBaseDatos {

	private HashMap<String, Usuario> usuarios;
	private HashMap<Integer,Producto> prodReciclables;            //se cambio el tipo a hashtmap para facilitar las busquedas
	private ArrayList<PuntoLimpio> PLs;
	private ArrayList<PuntoLimpioItinerante> PLIs;
	private String infoONG;
	private HashMap<String,Camion> camiones; //guarda la patente y el camion
	
	public AccesoBaseDatos() {
		this.usuarios = new HashMap<String,Usuario>();
		this.prodReciclables = new HashMap<Integer,Producto>();
		this.PLs=new ArrayList<PuntoLimpio>();
		this.camiones = new HashMap<String,Camion>();
		this.PLIs = new ArrayList<PuntoLimpioItinerante>();	
	}
	
	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public HashMap<Integer,Producto> getProdReciclables() {
		return prodReciclables;
	}

	public void ProdReciclables(HashMap<Integer,Producto> prodreciclables) {
		this.prodReciclables = prodreciclables;
	}
	
	public void addProdReciclable(Producto p) {
		this.prodReciclables.put(p.getID(),p);
	}

	public ArrayList<PuntoLimpioItinerante> getPtosRecoleccion() {
		return this.PLIs;
	}

	public void setPLs(ArrayList<PuntoLimpio> pLs) {
		PLs = pLs;
	}

	public void setPLIs(ArrayList<PuntoLimpioItinerante> pLIs) {
		PLIs = pLIs;
	}

	public String getInfoONG() {
		return infoONG;
	}

	public void setInfoONG(String infoONG) {
		this.infoONG = infoONG;
	}


	public boolean loginUsuario(String nick, String contraseña) {
		if(this.verificarUsario(nick))
			if(this.usuarios.get(nick).getContraseña().equals(contraseña))
				return true;
		return false;
	}
	
	public boolean loginMunicipio(String nick, String contraseña) {
		if (this.usuarios.get(nick).getContraseña().equals(contraseña)) {
			//  Esto no se haria, no se guarda en Acceso Base Datos, nos quedamos con el nick en la funcionalidadempmunicipio
			//  sie es que se devuelve true
			//			this.user = new EmpMunicipio(nick, contraseña, usuarios.get(nick).getEmail());
			return true;
		}
		return false;
	}
	//
	public void registrarProducto(String nick,int id, int cantidad, Direccion direccion) {		
		//busco el vecino en la base de datos con el nick
		//Hago el casting -> busco que la ID sea correcta y que este en los productos reciclables
		//-> busco que el PLI exista -> agrego el producto al PLI y al vector de productos del vecino
		Usuario user= this.usuarios.get(nick);
		if ( user instanceof Vecino) {
				if (this.prodReciclables.containsKey(id)) {
					if((cantidad < 100)&&(cantidad>0)) {
						ProductoRegistrado producto = new ProductoRegistrado(this.prodReciclables.get(id), cantidad);
						
						for (int i=0; i<PLIs.size();i++) {
							if (PLIs.get(i).getDireccion().equals(direccion)) {                        
								PLIs.get(i).addProducto(producto);
								((Vecino)user).registrarProducto(producto);
								}					
							}							
					}
				}
		}
	}
	
	//Busca dentro del mapa de usuarios si el nick ya existe, para que al momento de registarse no 
	//se encuentren repetidos
	public boolean verificarUsario(String nick) {
		if (this.usuarios.containsKey(nick))
			return true;
		return false;
	}
	
	//RegistrarUsuario
	public void registrarUsuario(String nick,String contraseña,String email) {
		Vecino aux= new Vecino(nick, contraseña, email);
		this.usuarios.put(nick, aux);
	}
	
	//verifica la existencia de un producto reciclabe con el id ingresado
	public boolean verificarIdProducto(int iD) {
		return (this.prodReciclables.containsKey(iD));
	}
	
	public HashMap<Producto, Integer> getEstadisticasPersonales(String nick, Calendar ini, Calendar fin) {
		Usuario user= this.usuarios.get(nick);
		return ((Vecino)user).getEstadisticasPersonales(ini, fin);			
	}
	
	public HashMap<Producto, Integer> getEstadisticasCiudad(String nick, Calendar ini, Calendar fin) {
		ArrayList<Usuario> users = (ArrayList<Usuario>)this.usuarios.values();
		ArrayList<ProductoRegistrado> productos = new ArrayList<ProductoRegistrado>();
		for (int i=0;i<users.size();i++) {
			productos.addAll(((Vecino)users.get(i)).getProductos());
		}
		//Creamos una variable auxiliar de estadisticas con la finalidad de que calcule las estadisticas que se devolveran en las demas clases
		CalculoEstadisticas aux = new CalculoEstadisticas(ini, fin);
		return aux.getEstadisticasPorFecha(productos);
	}
	
	public ArrayList<Ubicacion> getUbicacionCamiones(){
		ArrayList<Ubicacion> ubicacioncamiones = new ArrayList<Ubicacion>();
		for (int i=0; i<((ArrayList<Camion>)this.camiones.values()).size();i++) {
			ubicacioncamiones.add(((ArrayList<Camion>)this.camiones.values()).get(i).getUbicacion());
		}
		return ubicacioncamiones;
	}
}