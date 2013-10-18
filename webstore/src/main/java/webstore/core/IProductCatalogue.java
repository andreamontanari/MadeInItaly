
package webstore.core;

import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface for the ReservationRegistry
 * @author Jonas Ha
 */
public interface IProductCatalogue extends IDAO<Product, Long> {

    public List<Product> getByName(String name);


     
}
