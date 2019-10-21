package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentasImpl
 */
@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	
	@PersistenceContext(unitName = "bancabdPU")
	EntityManager em;

	@Override
	public List<Cuenta> dameCuentas() {
		Cuenta cuentas=em.find(Cuenta.class, "Cuenta.findAll");
		return cuentas.getCuentas();
	}


}
