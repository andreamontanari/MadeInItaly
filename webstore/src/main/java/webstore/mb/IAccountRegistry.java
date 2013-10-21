package webstore.mb;

import webstore.utils.IDAO;
import java.util.List;

/**
 * Interface for AccountRegistry
 * 
 * @author Jonas Ha
 */
public interface IAccountRegistry extends IDAO<Account, Long> {

    public List<Account> getByName(String name);
    
}
