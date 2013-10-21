
package webstore.core;

import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface to reservation registry
 * @author hajo
 */
public interface IReservationRegistry extends IDAO<Reservation, Long> {

    public List<Reservation> getByName(String name);


     
}
