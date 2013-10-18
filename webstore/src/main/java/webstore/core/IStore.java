package webstore.core;



/**
 * Public interface for the shop
 * @author hajo
 */

public interface IStore {

    public IProductCatalogue getProductCatalogue();
    
    public IReservationRegistry getReservationRegistry();
   
}
