/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.bb;

import webstore.core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import webstore.core.JPAStore;

/**
 * Must have in session scope, has state (in ContainerNavigator)!
 * @author hajo
 */
@Named("products")
@RequestScoped // NOTE enterprise package, else disaster!!!
public class ProductsBB implements Serializable{

    @Inject
    private JPAStore jpa;
    
    public List<Product> getAll(){
        jpa = new JPAStore();
        return jpa.getProductCatalogue().getAll(true, 0, 0);
    }

}
