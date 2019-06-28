public abstract class Usuario {
	private String nick;
	private String contraseña;
	private String email;

	protected Usuario(String n, String c, String e) {
		this.nick = n;
		this.contraseña = c;
		this.email = e;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean equals(Usuario user) {
		return ((this.email.equals(user.getEmail())) && (this.nick.equals(user.getNick())) && (this.contraseña.equals(user.getContraseña())));
	}
}