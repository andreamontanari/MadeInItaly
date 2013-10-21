package webstore.mb;


import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface to account registry
 * @author Jonas Ha
 */
public interface IAccountRegistry extends IDAO<Account, Long> {

    public List<Account> getByName(String name);
    
}
