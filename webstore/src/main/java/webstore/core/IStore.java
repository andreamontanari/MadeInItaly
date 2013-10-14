package webstore.core;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Public interface for the shop
 * @author hajo
 */
@Named
@SessionScoped
public interface IStore {

    public IProductCatalogue getProductCatalogue();
}
