/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import webstore.core.Product;

/**
 *
 * @author Moe
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
