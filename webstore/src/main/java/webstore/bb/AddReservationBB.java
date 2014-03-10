package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import webstore.core.JPAStore;
import webstore.core.Product;
import webstore.core.Reservation;

/**
 * Backing bean for Add Reservation page
 *
 * @author Jonas Ha
 */
@Named("addReservation")
@ConversationScoped
public class AddReservationBB extends ConversationalBase {

    @Inject
    private JPAStore jpa;
    @NotNull(message = "Required")
    private String reserverName;
    @NotNull(message = "Required")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Must be an email e.g. example@example.com")
    private String reserverMail;

    /**
     * Execute method to add an reservation to the registry (database)
     *
     * @return String value "RESERVATION_FAIL" or "RESERVATION_SUCCESS" for the outcome
     * that is used for redirecting to a specific jsf page
     */
    @Override
    protected String execute() {
        if (getProduct().getQuantity() <= 0) {
            return Navigation.RESERVATION_FAIL.toString();
        }
        
        Reservation r = new Reservation(reserverName, reserverMail, getProduct());
        jpa.getReservationRegistry().add(r);
        jpa.getProductCatalogue().update(new Product(getProduct().getId(), getProduct().getName(), (getProduct().getQuantity()) - 1, getProduct().getPrice()));
        return Navigation.RESERVATION_SUCCESS.toString();
    }

    /**
     * Returns the reservers name
     *
     * @return reserverName
     */
    public String getReserverName() {
        return reserverName;
    }

    /**
     * Sets the reservers name
     *
     * @param reserverName
     */
    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    /**
     * Returns the reservers mail
     *
     * @return reserverMail
     */
    public String getReserverMail() {
        return reserverMail;
    }

    /**
     * Sets the reservers mail
     *
     * @param reserverMail
     */
    public void setReserverMail(String reserverMail) {
        this.reserverMail = reserverMail;
    }
}
