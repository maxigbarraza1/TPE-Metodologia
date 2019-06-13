package actores;

public abstract class Usuario {
	private String nick;
	private String contrase�a;
	private String email;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Usuario user) {
		return ((this.email == user.getEmail()) && (this.nick == user.getNick())
				&& (this.contrase�a == user.getContrase�a()));
	}
}
