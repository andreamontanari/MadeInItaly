/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 *
 * @author Moe
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
