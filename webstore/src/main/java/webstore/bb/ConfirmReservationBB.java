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
public class ConfirmReservationBB extends ConversationalBase{

    @Override
    protected String execute() {
        getReservationRegistry().remove(getId());
        return "RESERVATIONS_AUTH";
    }
}
