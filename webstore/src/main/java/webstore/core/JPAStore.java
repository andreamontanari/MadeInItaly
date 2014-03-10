package webstore.core;

import webstore.mb.AccountRegistry;
import webstore.mb.IAccountRegistry;
import java.io.Serializable;
import webstore.mb.CustomerRegistry;
import webstore.mb.ICustomerRegistry;

/**
 *
 * JPAStore
 *
 * @author Jonas Ha
 */
public class JPAStore implements IStore, Serializable {

    private String persistenceUnitName = "store";
    private IProductCatalogue productCatalogue;
    private IReservationRegistry reservationRegistry;
    private IAccountRegistry accountRegistry;
    private ICustomerRegistry customerRegistry;
    
    public JPAStore() {
        productCatalogue = ProductCatalogue.newInstance(persistenceUnitName);
        reservationRegistry = ReservationRegistry.newInstance(persistenceUnitName);
        accountRegistry = AccountRegistry.newInstance(persistenceUnitName);
        customerRegistry = CustomerRegistry.newInstance(persistenceUnitName);

    }

    @Override
    public IProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }

    @Override
    public IReservationRegistry getReservationRegistry() {
        return reservationRegistry;
    }

    @Override
    public IAccountRegistry getAccountRegistry() {
        return accountRegistry;
    }
    
    @Override
    public ICustomerRegistry getCustomerRegistry() {
        return customerRegistry;
    }
}
