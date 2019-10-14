package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "loginBean") // identificador de la instancia, nombre de la clase pero la primera en minúscula
@RequestScoped
public class LoginBean {
	private String usuario;
	private String password;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/////////////
	public String login() {
		if(usuario.equals("curso")&&password.equals("curso")) {
			return "bienvenida";
		}else {
			return "error";
		}
	}
}
