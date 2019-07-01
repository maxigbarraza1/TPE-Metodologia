import java.util.ArrayList;

public class ONG {
	private ArrayList<Producto> productosentregados;
	private ArrayList<Producto> reciclables;
	
	public ONG() {
		productosentregados = new ArrayList<Producto>();
	}
	
	public ArrayList<Producto> getProductosEntregados() {
		return productosentregados;
	}
	
	public void setProductosEntregados(ArrayList<Producto> p) {
		productosentregados = p;
	}
	
	public void setListaReciclables(ArrayList<Producto> p) {
		reciclables = p;
	}
	
	public void venderProductos() {
		for (int i = 0; i < productosentregados.size(); i++) {
			if (reciclables.contains(productosentregados.get(i)))
				productosentregados.remove(i);
		}
	}
}
