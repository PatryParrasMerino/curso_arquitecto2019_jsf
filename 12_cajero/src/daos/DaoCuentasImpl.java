package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentas
 */
@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	@PersistenceContext(unitName="cajeroPU")
	EntityManager em;

	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		return em.find(Cuenta.class, numeroCuenta);
	}

	@Override
	public void updateCuenta(Cuenta c) {
		em.merge(c);		
	}

	@Override
	public List<Cuenta> findAllCuentas() {
		TypedQuery<Cuenta> tq=em.createNamedQuery("Cuenta.findAll",Cuenta.class);
		return tq.getResultList();
	}
	

    

}
