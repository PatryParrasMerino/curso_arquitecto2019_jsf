package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class ServiceCajeroImpl
 */
@Stateless
public class ServiceCajeroImpl implements ServiceCajero {

	@EJB
	DaoClientes daoClientes;
	@EJB
	DaoCuentas daoCuentas;
	@EJB
	DaoMovimientos daoMovimientos;
	
	@Override
	public Cuenta obtenerCuenta(int IdCuenta) {
		return daoCuentas.findCuenta(IdCuenta);
	}

	@Override
	public void extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		if(cuenta.getSaldo()<=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.updateCuenta(cuenta);
			Movimiento m =new Movimiento(0, cantidad, new Date(), "extracción", cuenta);
			daoMovimientos.saveMovimiento(m);
		}
		
	}

	@Override
	public void ingreso(int idCuenta, double cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		// TODO Auto-generated method stub
		return 0;
	}


}
