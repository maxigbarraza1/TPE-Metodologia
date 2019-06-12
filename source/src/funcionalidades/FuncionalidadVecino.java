package funcionalidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import actores.PuntoLimpioItinerante;
import ubicaciones.Direccion;
import productos.Producto;

public class FuncionalidadVecino {
	private AccesoBaseDatos b;
	private String nick;
	
	public FuncionalidadVecino(AccesoBaseDatos b) {
		this.b=b;
	}
	
	public void registrar(String nick,String contraseña,String email) {
		if (!b.verificarUsario(nick))
			b.registrarUsuario(nick, contraseña, email);
	}
	
	public boolean login(String nick,String contraseña) {             //Verifica con la base de datos que los 
		if (b.loginUsuario(nick, contraseña)) {						  //datos suministrados son correspondientes
			this.nick=nick;											  // a un usuario, de ser asi guarda el nick 
			return true;											  //y asi poder hacer las consultas proximas sobre ese nick
		}
		return false;
	}
	
	public void registrarProducto(int id,int cantidad) {
		if (b.verificarIdProducto(id)) {
			//interfaz.elegirPLI(b.getPtosRecoleccion()); //La interfaz se dedica a buscar y devolver el PLI donde se depositara la carga
			Direccion direccionelegida;//= interfaz.getDireccionElegida(); //Creamos una direccion simulando la funcionalidad de la interfaz
			b.registrarProducto(this.nick, id, cantidad, direccionelegida); //direccion elegida lo otorga la interfaz
		}
	}
	
	public HashMap<Producto, Integer> getEstadisticasPersonales() {
		return b.getEstadisticasPersonales(this.nick);
	}
	
	public HashMap<Integer, Producto> getProductosReciclables(){
		return b.getProdReciclables();
	}
	
	public String getEstadisticasONG() {
		return b.getInfoONG(); 
	}
	
	public HashMap<Producto, Integer> getEstadisticasDeLaCiudad() {
		
		Calendar inicio;
		Calendar fin;
		//interfaz.getFechas(inicio, fin)
		return b.getEstadisticasCiudad(this.nick, inicio, fin);
	}
	
	public List<Ubicacion> getPtosDeRecoleccion(){
		return b.getPtosRecoleccion();
	}
	
	public List<Ubicacion> getUbicacionCamiones(){
		
	}
}
