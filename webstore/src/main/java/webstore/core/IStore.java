package webstore.core;

import webstore.mb.IAccountRegistry;
import webstore.mb.ICustomerRegistry;

/**
 * Interface for the Store
 *
 * @author Jonas Ha
 */
public interface IStore {

    public IProductCatalogue getProductCatalogue();

    public IReservationRegistry getReservationRegistry();

    public IAccountRegistry getAccountRegistry();
    
    public ICustomerRegistry getCustomerRegistry();
}
