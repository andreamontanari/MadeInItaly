/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;

import javax.inject.Named;
import webstore.bb.ConversationalBase;

/**
 *
 * @author hajo
 */
@Named("delProduct")
@ConversationScoped
public class delProductBB extends ConversationalBase{
    
    @Override
    protected void execute() {
        getProductCatalogue().remove(getId());
    }
}
