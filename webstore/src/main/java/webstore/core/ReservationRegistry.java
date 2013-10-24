package webstore.core;

import webstore.utils.AbstractDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * Registry for reservations
 *
 * @author Jonas Ha
 */
public final class ReservationRegistry extends AbstractDAO<Reservation, Long> implements IReservationRegistry {

    private ReservationRegistry(String puName) {
        super(Reservation.class, puName);
    }

    // new instance method
    public static ReservationRegistry newInstance(String puName) {
        return new ReservationRegistry(puName);
    }
}
