package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import webstore.core.Product;

/**
 * Backing Bean for the Remove Reservation Page
 *
 * @author Jonas Ha
 */
@Named("removeReservation")
@ConversationScoped
public class RemoveReservationBB extends ConversationalBase {

    /**
     * Execute method to remove a reservation in the reservation registry
     * (database) and updating a products quantity
     *
     * @return String value "RESERVATION_AUTH"
     *
     */
    @Override
    protected String execute() {
        getReservationRegistry().remove(getId());
        getProductCatalogue().update(new Product(getProduct().getId(), getProduct().getName(), getProduct().getQuantity() + 1, new Double(getProduct().getPrice())));
        return "RESERVATIONS_AUTH";
    }
}
