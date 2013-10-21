/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.bb;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import webstore.core.JPAStore;
import webstore.core.Reservation;

/**
 * ReservationBB for Reservation Page
 *
 * @author Jonas Ha
 */
@Named("reservations")
@RequestScoped
public class ReservationsBB implements Serializable{
  
    @Inject
    private JPAStore jpa;
    
     public List<Reservation> getAll(){
        return jpa.getReservationRegistry().getAll();
    }
     
    public String navigate(String target) {
        return target;
    }
    
    
}
