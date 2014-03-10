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
public class EditProductBB extends ConversationalBase {

    /**
     * Execute method to edit a product in the productCatalogue (database)
     *
     * @return String value "products" for the outcome that is used for
     * redirecting to a specific jsf page
     */
    @Override
    protected String execute() {
        getProductCatalogue().update(new Product(getId(), getName(), getQuantity(), new Double(getPrice())));
        return "PRODUCTS_AUTH";
    }
}
