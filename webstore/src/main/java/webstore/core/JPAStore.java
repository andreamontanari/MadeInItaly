package webstore.core;

/**
 *
 * Shop is a container for other containers NOTE: Uses Java 1.7
 *
 * @author hajo
 */

public class JPAStore implements IStore {

    private String persistenceUnitName = "store";
    private IProductCatalogue productCatalogue;


    public JPAStore() {
        productCatalogue = ProductCatalogue.newInstance(persistenceUnitName);
    }

    @Override
    public IProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }
}
