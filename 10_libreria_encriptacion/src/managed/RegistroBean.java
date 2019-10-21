package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean(name = "registroBean")
@RequestScoped
public class RegistroBean {
	Cliente cliente;
	private String repetirPassword;
	
	public String getRepetirPassword() {
		return repetirPassword;
	}

	public void setRepetirPassword(String repetirPassword) {
		this.repetirPassword = repetirPassword;
	}

	@EJB
	DaoClientes daoClientes;

	public RegistroBean() {
		cliente=new Cliente();  //instanciar objeto en el contructor, porque al estar vinculado vista y controlador 
	}							//hay que crear el objeto antes, no vale en el método
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String registrar(String email) {
        daoClientes.registrar(cliente);
        return "login";
	}
}
