package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosImpl
 */
@Stateless
public class DaoMovimientosImpl implements DaoMovimientos {

	@PersistenceContext(unitName = "bancabdPU")
	EntityManager em;
	
	@Override
	public List<Movimiento> dameMovimientosFecha(Date fecha) {
		String jpql="Select c from cuentas c join c.movimientos m Where m.fecha=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, fecha);
		return (List<Movimiento>)qr.getResultList();
	}


}
