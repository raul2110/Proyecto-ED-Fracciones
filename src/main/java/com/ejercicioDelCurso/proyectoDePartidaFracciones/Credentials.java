package objects;

import java.io.Serializable;

public class Credentials implements Serializable{

	private static final long serialVersionUID = -4236321772891901270L;
	private String email, password;
	private TypeOfUser tipoDeUsuario;
	
	public Credentials(String email, String password, TypeOfUser tipoDeUsuario) {
		super();
		this.email = email;
		this.password = password;
		this.tipoDeUsuario = tipoDeUsuario;
	}
	

	public TypeOfUser getTipoDeUsuario() {
		return tipoDeUsuario;
	}


	public void setTipoDeUsuario(TypeOfUser tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}


	@Override
	public String toString() {
		return "Credentials [email=" + email + ", password=" + password + ", tipoDeUsuario=" + tipoDeUsuario + "]";
	}


	public boolean equals(Object o) {
		
		if(!(o instanceof Credentials)) {
			return false;
		}
		
		if(!((Credentials)o).getEmail().equals(this.email)) {
			return false;
		}
		
		if(!((Credentials)o).getPassword().equals(this.password)) {
			return false;
		}
		return true;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}










