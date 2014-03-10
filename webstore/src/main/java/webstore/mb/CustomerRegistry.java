/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import webstore.utils.AbstractDAO;

/**
 *
 * @author zozo
 */
@Named
@RequestScoped
public final class CustomerRegistry extends AbstractDAO<Customer, Long> implements ICustomerRegistry {
    private CustomerRegistry(String puName) {
        super(Customer.class, puName);
    }

    // new instance method
    public static CustomerRegistry newInstance(String puName) {
        return new CustomerRegistry(puName);
    }
}
