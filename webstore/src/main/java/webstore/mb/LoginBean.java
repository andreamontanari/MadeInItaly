package webstore.mb;

import webstore.utils.Util;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import webstore.core.JPAStore;

/**
 * Backing bean for Login
 *
 * @author Jonas Ha
 */
@Named("LoginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String message;
    @Inject
    private JPAStore jpa;

    /**
     * Returns the message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * Execute method when performing a login Returns a String value of the
     * outcome which redirects to a specific page after login or failed.
     *
     * @return String value for outcome
     */
    public String loginWebstore() {
        username = username.toLowerCase();
        password = password.toLowerCase();
        String login = checkAccount(username, password);
        String loginCustomer = checkCustomer(username, password);

        if (login.equals("LOGIN_ADMIN")) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", username);
            return "LOGIN_ADMIN";
        } 
        else if(loginCustomer.equals("LOGIN_CUSTOMER")){
            HttpSession session1 = Util.getSession();
            session1.setAttribute("username", username);
            return "LOGIN_CUSTOMER";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "LOGIN_FAIL";
        }
    }

    /**
     * Check if there is an existing user with a specific username and password
     *
     * @return boolean true or false
     */
    public String checkAccount(String uname, String pword) {
        List<Account> accounts = jpa.getAccountRegistry().getAll();
        for (Account element : accounts) {
            if (element.getUsername().equals(uname) && element.getPassword().equals(pword)) {
                return "LOGIN_ADMIN";
            }
        }
        return "LOGIN_FAIL";
    }
    
    
    public String checkCustomer(String uname, String pword) {
        List<Customer> customer = jpa.getCustomerRegistry().getAll();
        for (Customer element : customer) {
            if (element.getUsername().equals(uname) && element.getPassword().equals(pword)) {
                
                return "LOGIN_CUSTOMER";
            }
        }
        return "LOGIN_FAIL";
    }

    /**
     * Make the login session invalid and returns a String value for redirecting
     * to specific page
     *
     * @return String value for outcome
     */
    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "LOGOUT_SUCCESS";
    }
}