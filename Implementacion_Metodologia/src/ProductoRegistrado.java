import java.util.Calendar;

public class ProductoRegistrado extends Producto {

	private Calendar fecha;
	
	public ProductoRegistrado(int ID, String nombre, double ancho, double alto, double largo) {
		// TODO Auto-generated constructor stub
		super(ID, nombre,ancho,alto,largo);
		this.fecha.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
	}
}
