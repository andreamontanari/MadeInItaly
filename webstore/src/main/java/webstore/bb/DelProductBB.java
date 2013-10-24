package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * Backing Bean for the Delete Product Page
 *
 * @author Jonas Ha
 */
@Named("delProduct")
@ConversationScoped
public class DelProductBB extends ConversationalBase {

    /**
     * Execute method to del a product in the productCatalogue (database)
     *
     * @return String value "products" for the outcome that is used for
     * redirecting to a specific jsf page
     */
    @Override
    protected String execute() {
        getProductCatalogue().remove(getId());
        return "products";
    }
}
