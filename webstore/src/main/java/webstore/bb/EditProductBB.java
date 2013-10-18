
package webstore.bb;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import webstore.core.JPAStore;
import webstore.core.Product;
import webstore.core.ProductCatalogue;

/**
 * 
 *
 * @author Jonas Ha
 */
@Named("editProduct")
@ConversationScoped
public class EditProductBB extends ConversationalBase{

    @Override
    protected void execute() {
        getProductCatalogue().update(new Product(getId(), getName(), getQuantity(), new Double(getPrice())));
    }
}
