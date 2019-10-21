package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Movimiento;

@Local
public interface DaoMovimientos {
	List<Movimiento> dameMovimientosFecha(Date fecha);
}
