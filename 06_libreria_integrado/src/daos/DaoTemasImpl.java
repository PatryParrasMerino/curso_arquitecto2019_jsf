package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Tema;

/**
 * Session Bean implementation class DaoTemasImpl
 */
@Stateless
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em; 
 
    @Override
	public List<Tema> obtenerTemas() {
		TypedQuery<Tema> tp=em.createNamedQuery("Tema.findAll",Tema.class);
		return tp.getResultList();
	}
    
    //utilización de join explícito
	@Override
	public Tema obtenerTemaDeLibro(String titulo) {
		String jpql="Select t From Tema t join t.libros l Where l.titulo=?1";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, titulo);
		Tema tm=null;
		try {
			tm=(Tema)qr.getSingleResult();
		}
		catch(NonUniqueResultException ex) {
			ex.printStackTrace();
		}
		return tm;
	}

}
