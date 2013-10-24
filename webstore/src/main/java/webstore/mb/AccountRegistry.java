package webstore.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import webstore.utils.AbstractDAO;

/**
 * AccountRegistry
 *
 * @author Jonas Ha
 */
@Named
@RequestScoped
public final class AccountRegistry extends AbstractDAO<Account, Long> implements IAccountRegistry {

    private AccountRegistry(String puName) {
        super(Account.class, puName);
    }

    // new instance method
    public static AccountRegistry newInstance(String puName) {
        return new AccountRegistry(puName);
    }
}
