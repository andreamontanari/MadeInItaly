
package webstore.mb;

import java.io.Serializable;

/**
 *
 * @author hajon
 */
public class User implements Serializable {

    private String username;
    private String password;
    
    public User(String username, String password) {
       this.username = username;
       this.password = password;
    }

    public String getName() {
        return username;
    }
    public String getPassword(){
        return password;
    }
}   
