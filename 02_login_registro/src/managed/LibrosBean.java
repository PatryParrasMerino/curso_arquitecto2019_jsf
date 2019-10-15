package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@EJB
	DaoLibros daoLibros;
	
	private List<Libro> libros;
	@PostConstruct  //se tiene que crear la instancia de libros despues de crear libros bean
	public void creado() {
		libros=daoLibros.obtenerLibros();
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
}
