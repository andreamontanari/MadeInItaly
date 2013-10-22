package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import webstore.core.Product;


/**
 * Backing Bean for the Edit Product Page
 * 
 * @author Jonas Ha
 */
@Named("editProduct")
@ConversationScoped
public class EditProductBB extends ConversationalBase{

    @Override
    protected String execute() {
        getProductCatalogue().update(new Product(getId(), getName(), getQuantity(), new Double(getPrice())));
        return "products";
    }
}
