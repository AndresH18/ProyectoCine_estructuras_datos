package interfaces.login;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 8149364816260777422L;

	private final String usuario;
	private final String password;

	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

}
