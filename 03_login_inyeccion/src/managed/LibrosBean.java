package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@EJB
	DaoLibros daoLibros;
	
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	
	private List<Libro> libros;
	@PostConstruct       //se tiene que crear la instancia de libros despues de crear libros bean
	public void creado() {
		if(loginBean.getUsuario().equals("test1")) {  // al usuario test1 solo se le pasan los libros de tema 1
			libros=daoLibros.obtenerLibrosTema(1);
		}else {
			libros=daoLibros.obtenerLibros();
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
}
