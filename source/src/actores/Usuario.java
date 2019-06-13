package actores;

public abstract class Usuario {
	private String nick;
	private String contraseña;
	private String email;

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
		return ((this.email == user.getEmail()) && (this.nick == user.getNick())
				&& (this.contraseña == user.getContraseña()));
	}
}
