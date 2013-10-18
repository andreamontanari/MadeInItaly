/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.core;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import webstore.utils.AbstractEntity;

/**
 *  A Reservation
 * @author Jonas Ha
 */
@Entity
public class Reservation extends AbstractEntity{
    
    private String reserverName;
    private String reserverMail;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Product product;
    
    public Reservation(){
    }
    public Reservation(String reserverName, String reserverMail, Product product) {
        this.reserverName = reserverName;
        this.reserverMail = reserverMail;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public String getReserverName() {
        return reserverName;
    }
    
    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }
    
    public String getReserverMail() {
        return reserverMail;
    }

    public void setReserverMail(String reserverMail) {
        this.reserverMail = reserverMail;
    }
}
