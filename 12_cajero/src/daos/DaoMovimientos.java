package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Movimiento;

@Local
public interface DaoMovimientos {
	void saveMovimiento(Movimiento m);
	
	List<Movimiento> findMovimientosByCuenta(int numeroCuenta, Date fechaini, Date fechafin);
}
