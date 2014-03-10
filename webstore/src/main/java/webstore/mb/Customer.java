/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.mb;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import webstore.utils.AbstractEntity;

/**
 *
 * @author zozo
 */
@Entity
@XmlRootElement
public class Customer extends AbstractEntity {

    private String username;
    private String password;

    public Customer() {
    }

    public Customer(String username, String password) {
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
