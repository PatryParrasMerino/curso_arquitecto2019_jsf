package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoTemas;
import model.Tema;

@ManagedBean(name="temasBean")
@RequestScoped
public class TemasBean {

	@EJB
	DaoTemas daoTemas;
	
	private List<Tema> temas;
	private int temaSel;
	
	@PostConstruct       //se tiene que crear la instancia de temas despues de crear temas bean
	public void inicio() {
			temas=daoTemas.obtenerTemas();
		
	}
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public int getTemaSel() {
		return temaSel;
	}
	public void setTemaSel(int t) {
		this.temaSel = t;
	}
	
	//método controlador de acción
	/*public String libros() {
		return "libros";
	}*/
	
}
