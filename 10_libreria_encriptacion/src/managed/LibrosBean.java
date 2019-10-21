package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import daos.DaoLibros;
import model.Libro;
import utilidades.Contexto;

@ManagedBean(name="librosBean")
@RequestScoped
public class LibrosBean {
	@EJB
	DaoLibros daoLibros;

	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;
	
	private List<Libro> libros;	
	
	public List<Libro> getLibros() {
		//recuperamos el tema y despu�s los libros asociados
		//cuando se solicten los libros, no al principio
		if(temasBean.getTemaSel()==0) {
			libros=daoLibros.obtenerLibros();
		}else {
			libros=daoLibros.obtenerLibrosTema(temasBean.getTemaSel());
		}
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public TemasBean getTemasBean() {
		return temasBean;
	}

	public void setTemasBean(TemasBean temasBean) {
		this.temasBean = temasBean;
	}
	
	//controlador de acci�n para cerrar sesi�n
	public String finSesion() {
		Contexto.getSession().invalidate();
		return "login";
	}
	
}
