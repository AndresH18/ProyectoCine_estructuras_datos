package interfaces.login;

import java.io.Serializable;

public class Usuario implements Serializable {

	private final String usuario;
	private final String password;

	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

}
