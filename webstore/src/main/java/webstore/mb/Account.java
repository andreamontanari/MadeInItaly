
package webstore.mb;

import javax.persistence.Entity;
import webstore.utils.AbstractEntity;

/**
 *  An Account
 * 
 * @author Jonas Ha
 */
@Entity
public class Account extends AbstractEntity {

    private String username;
    private String password;
    
    public Account(){
        
    }
    public Account(String username, String password) {
       this.username = username;
       this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }
}   
