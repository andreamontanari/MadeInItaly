package webstore.core;



/**
 * Interface for the Store
 * @author Jonas Ha
 */

public interface IStore {

    public IProductCatalogue getProductCatalogue();
    
    public IReservationRegistry getReservationRegistry();
   
}
