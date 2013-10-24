package webstore.mb;

import javax.persistence.Entity;
import webstore.utils.AbstractEntity;

/**
 * An Account
 *
 * @author Jonas Ha
 */
@Entity
public class Account extends AbstractEntity {

    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
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
     * Returns the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
