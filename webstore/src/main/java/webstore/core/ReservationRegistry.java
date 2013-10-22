package webstore.core;

import webstore.utils.AbstractDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author Jonas Ha
 */
public final class ReservationRegistry extends AbstractDAO<Reservation, Long> implements IReservationRegistry {
    
    private ReservationRegistry(String puName) {
        super(Reservation.class, puName);
    }

    // Factory method
    public static ReservationRegistry newInstance(String puName) {
        return new ReservationRegistry(puName);
    }

    public Reservation getById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        List<Reservation> found = em.createQuery("SELECT m FROM Product m WHERE m.id =" + id).getResultList();
        em.close();
        return found.get(0);
    }
}
