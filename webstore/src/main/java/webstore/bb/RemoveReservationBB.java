
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
public class RemoveReservationBB extends ConversationalBase{

    @Override
    protected String execute() {
        getReservationRegistry().remove(getId());
        getProductCatalogue().update(new Product(getProduct().getId(), getProduct().getName(), getProduct().getQuantity()+1, new Double(getProduct().getPrice())));
        return "RESERVATIONS_AUTH";
    }
}
