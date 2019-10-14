package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Cliente;

@ManagedBean(name = "registroBean")
@RequestScoped
public class RegistroBean {
	Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String registrar() {
		
	}
}
