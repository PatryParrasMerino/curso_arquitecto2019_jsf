package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {
	void altaClientes(Cliente cliente);
	List<Cliente> clientesDeCuenta(int numeroCuenta);
	void eliminarCliente(int idCliente);
	List<Cliente> clientesConMovimientosFecha(Date fecha); //que clientes realizaron movimientos en una fecha dada
}
