package funcionalidades;

import java.util.ArrayList;
import java.util.HashMap;

import actores.EmpMunicipio;
import actores.PuntoLimpio;
import actores.PuntoLimpioItinerante;
import actores.Usuario;
import actores.Vecino;
import productos.ProductoRegistrado;
public class AccesoBaseDatos {

	private HashMap<String, Usuario> usuarios;
	private ArrayList <ProductoRegistrado> prodReciclables;
	private ArrayList<PuntoLimpio> PLs;
	private ArrayList<PuntoLimpioItinerante> PLIs;
	private String infoONG;
	private Usuario user;
	
	public AccesoBaseDatos() {
		// TODO Auto-generated constructor stub
	}
	
	public HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<ProductoRegistrado> getProdReciclables() {
		return prodReciclables;
	}

	public void setProdReciclables(ArrayList<ProductoRegistrado> prodreciclables) {
		this.prodReciclables = prodreciclables;
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

	public Usuario getUser() {
		return user;
	}

	public boolean loginUsuario(String nick, String contraseña) {
		if (this.usuarios.get(nick).getContraseña().equals(contraseña)) {
			this.user = new Vecino(nick, contraseña, usuarios.get(nick).getEmail());
			return true;
		}
		return false;
	}
	
	public boolean loginMunicipio(String nick, String contraseña) {
		if (this.usuarios.get(nick).getContraseña().equals(contraseña)) {
			this.user = new EmpMunicipio(nick, contraseña, usuarios.get(nick).getEmail());
			return true;
		}
		return false;
	}
	
	public void registrarProducto(int id, int cantidad, String direccion) {		
		//Codded by Juancho 2k19
		//Hago el casting -> busco que la ID sea correcta y que este en los productos reciclables
		//-> busco que el PLI exista -> agrego el producto al PLI y al vector de productos del vecino
		if ( user instanceof Vecino) {
			for (int j=0; j<this.prodReciclables.size();j++) {
				if (this.prodReciclables.get(j).getProducto().getID()==id) {
					ProductoRegistrado producto = new ProductoRegistrado(this.prodReciclables.get(j).getProducto(), cantidad);
					
					for (int i=0; i<PLIs.size();i++) {
						if (PLIs.get(i).getDireccion().getUbicacion().equals(direccion)) {
							if (PLIs.get(i).entraProducto(producto.getVolumen())) {
								PLIs.get(i).addProducto(producto);
								((Vecino)this.user).registrarProducto(producto, cantidad);
			
								}					
							}	
					}
				}
			}
		}
	}
}
