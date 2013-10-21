package webstore.core;

import webstore.utils.AbstractDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * ProductCatalogue
 * @author Jonas Ha
 */
@Named
@RequestScoped
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {
    
    private ProductCatalogue(String puName) {
        super(Product.class, puName);
    }

    // Factory method
    public static IProductCatalogue newInstance(String puName) {
        return new ProductCatalogue(puName);
    }
}
