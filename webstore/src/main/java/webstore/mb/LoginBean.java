package webstore.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import webstore.core.JPAStore;


/**
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String loginWebstore() {
        boolean login = checkAccount(username, password);
        
        if (login) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", username);
            return "LOGIN_SUCCESS";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "LOGIN_FAIL";
        }
    }

    public boolean checkAccount(String uname, String pword) {
      List<Account> accounts = jpa.getAccountRegistry().getAll();
        for (Account element : accounts) {
            if (element.getUsername().equals(uname) && element.getPassword().equals(pword)) {
                return true;
            }
        }
        return false;
    }

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "LOGOUT_SUCCESS";
    }
}