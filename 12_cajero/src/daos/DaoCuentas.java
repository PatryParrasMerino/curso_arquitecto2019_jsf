package daos;

import java.util.List;

import javax.ejb.Local;

import model.Cuenta;

@Local
public interface DaoCuentas {
	Cuenta findCuenta(int numeroCuenta);
	void updateCuenta(Cuenta c);
	List<Cuenta> findAllCuentas();
}
