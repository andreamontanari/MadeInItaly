package webstore.bb;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import webstore.core.JPAStore;
import webstore.core.Reservation;

/**
 * ReservationBB for Reservation Page
 *
 * @author Jonas Ha
 */
@Named("reservations")
@RequestScoped
public class ReservationsBB implements Serializable {

    @Inject
    private JPAStore jpa;

    /**
     * Method to get all reservations registry (database)
     *
     * @return A List of all the reservations from the database
     */
    public List<Reservation> getAll() {
        return jpa.getReservationRegistry().getAll();
    }

    /**
     * Returns a String value "target" used to redirecting to a specific JSF
     * page
     *
     * @param String target
     * @return String target
     */
    public String navigate(String target) {
        return target;
    }
}
