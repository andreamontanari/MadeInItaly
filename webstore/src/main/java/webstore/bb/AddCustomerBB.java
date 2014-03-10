/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.bb;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.primefaces.context.RequestContext;
import webstore.core.JPAStore;
import webstore.mb.Customer;

/**
 *
 * @author zozo
 */
@Named("addCustomer")
@RequestScoped
public class AddCustomerBB {

    @Inject
    private JPAStore jpa;
    @NotNull(message = "Required")
    private String username;
    @NotNull(message = "Required")
    private String password;

    /**
     * Add user Customer method
     */
    public void add() {
        Customer c = new Customer(username.toLowerCase(), password);
        jpa.getCustomerRegistry().add(c);
        RequestContext.getCurrentInstance().reset("form-register:register");
    }

    /**
     * Method to get all user customers from the registry (database)
     *
     * @return A List of all the user customers from the database
     */
    public List<Customer> getAll() {
        return jpa.getCustomerRegistry().getAll();
    }

    /**
     * Removes user customer from registry (database)
     *
     * @param index for the Entity in database
     */
    public void remove(Long id) {
        jpa.getCustomerRegistry().remove(id);
    }

    /**
     * Returns the username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
