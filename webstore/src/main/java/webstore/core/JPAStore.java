package webstore.core;

import webstore.mb.AccountRegistry;
import webstore.mb.IAccountRegistry;
import java.io.Serializable;

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

    public JPAStore() {
        productCatalogue = ProductCatalogue.newInstance(persistenceUnitName);
        reservationRegistry = ReservationRegistry.newInstance(persistenceUnitName);
        accountRegistry = AccountRegistry.newInstance(persistenceUnitName);

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
}
