package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientos
 */
@Stateless
public class DaoMovimientosImpl implements DaoMovimientos {
	@PersistenceContext(unitName="cajeroPU")
	EntityManager em;
	@EJB
	DaoCuentas daoCuentas;
	@Override
	public void saveMovimiento(Movimiento m) {
		em.persist(m);
		
	}

	

	

	@Override
	public List<Movimiento> findMovimientosByCuenta(int numeroCuenta, Date fechaini, Date fechafin) {
		TypedQuery<Movimiento> tq=em.createQuery("SELECT m FROM Movimiento m Where m.cuenta.numeroCuenta=?1 and m.fecha between ?2 and ?3",Movimiento.class);
		tq.setParameter(1, numeroCuenta);
		tq.setParameter(2, fechaini,TemporalType.TIMESTAMP);
		tq.setParameter(3, fechafin,TemporalType.TIMESTAMP);
		return tq.getResultList();
	}
	

    

}
