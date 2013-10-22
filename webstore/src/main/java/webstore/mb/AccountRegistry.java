/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.mb;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import webstore.utils.AbstractDAO;

/**
 *  AccountRegistry
 * 
 * @author Jonas Ha
 */
@Named
@RequestScoped
public final class AccountRegistry extends AbstractDAO<Account, Long> implements IAccountRegistry {
    
    private AccountRegistry(String puName) {
        super(Account.class, puName);
    }

    // Factory method
    public static AccountRegistry newInstance(String puName) {
        return new AccountRegistry(puName);
    } 
    
    @Override
    public List<Account> getByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        List<Account> found = em.createQuery("SELECT m FROM User m WHERE m.username =" + name).getResultList();
        em.close();
        return found;
    }

}
