import java.util.Calendar;
public class PuntoLimpio {

	private Direccion direccion;
	private Calendar h_apertura;
	private Calendar h_cierre;
	
	public PuntoLimpio() {
		// TODO Auto-generated constructor stub
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Calendar getH_apertura() {
		return h_apertura;
	}

	public void setH_apertura(Calendar h_apertura) {
		this.h_apertura = h_apertura;
	}

	public Calendar getH_cierre() {
		return h_cierre;
	}

	public void setH_cierre(Calendar h_cierre) {
		this.h_cierre = h_cierre;
	}

}
