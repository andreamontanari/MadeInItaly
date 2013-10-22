package webstore.bb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import webstore.core.JPAStore;
import webstore.mb.Account;



/**
 * Backing Bean for the Add Product Page
 *
 * @author Jonas Ha
 */
@Named("addAccount")
@RequestScoped
public class AddAccountBB {
    @Inject
    private JPAStore jpa;
    @NotNull(message = "Required")
    private String username;
    @NotNull(message = "Required")
    private String password;
    
    public String add() {
        Account u = new Account(username, password);
        jpa.getAccountRegistry().add(u);
        return Navigation.ADD_USER.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
