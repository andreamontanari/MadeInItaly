
package webstore.core;

import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface to product catalogue
 * @author hajo
 */
public interface IReservationRegistry extends IDAO<Reservation, Long> {

    public List<Product> getByName(String name);


     
}
