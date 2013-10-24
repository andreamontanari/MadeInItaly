package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * Backing Bean for the Confirm Reservation Page
 *
 * @author Jonas Ha
 */
@Named("confirmReservation")
@ConversationScoped
public class ConfirmReservationBB extends ConversationalBase {

    /**
     * Execute method to confirm a reservation, which deletes the specific
     * entity in the Reservation Registry (database)
     *
     * @return String value "RESERVATIONS_AUTH" for the outcome that is used for
     * redirecting to a specific jsf page
     */
    @Override
    protected String execute() {
        getReservationRegistry().remove(getId());
        return "RESERVATIONS_AUTH";
    }
}
