
package webstore.core;

import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface to product catalogue
 * @author hajo
 */
public interface IProductCatalogue extends IDAO<Product, Long> {

    public List<Product> getByName(String name);


     
}
