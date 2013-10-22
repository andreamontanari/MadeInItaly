package webstore.bb;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.primefaces.context.RequestContext;
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

    public void add() {
        Account u = new Account(username, password);
        jpa.getAccountRegistry().add(u);
        RequestContext.getCurrentInstance().reset("form-addUser:addUser");
        //return "ADD_USER_CONFIRM";
    }

    public List<Account> getAll() {
        return jpa.getAccountRegistry().getAll();
    }

    public void remove(Long id) {
        jpa.getAccountRegistry().remove(id);
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

    public String target(String target) {
        return target;
    }
}
