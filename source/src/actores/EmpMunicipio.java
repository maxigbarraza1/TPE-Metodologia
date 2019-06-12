package actores;


public class EmpMunicipio extends Usuario{

	public EmpMunicipio(String n, String c, String e) {
		super(n,c,e);
	}

	public boolean notificarPLIVacio(PtoLimpioIt p) {
		return p.estaVacio();
	}
}
