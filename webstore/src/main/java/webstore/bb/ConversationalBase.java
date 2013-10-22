package webstore.bb;

import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import webstore.core.IProductCatalogue;
import webstore.core.IReservationRegistry;
import webstore.core.JPAStore;
import webstore.core.Product;
import webstore.core.Reservation;

/**
 * Base class editproduct, delproduct etc
 *
 * @author hajon rewritten by Jonas Ha
 */
public abstract class ConversationalBase implements Serializable {

    private Product product;
    private Long id;
    private String name;
    private int quantity;
    private String price;
    
    @Inject
    private JPAStore jpa;
    
    @Inject
    private Conversation conversation;
    
    public void setSelected(String id) {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Product p = jpa.getProductCatalogue().find(Long.valueOf(id));
        this.product = p;   
        this.id = p.getId();
        this.name = p.getName();
        this.quantity = p.getQuantity();
        this.price = String.valueOf(p.getPrice());
    }

    public void setSelectedR(String id1, String id2) {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Reservation r  = jpa.getReservationRegistry().find(Long.valueOf(id1));
        Product p = jpa.getProductCatalogue().find(Long.valueOf(id2));

        this.id = r.getId();
        this.product = p;

    }

        
    @PreDestroy  // Must have for back button etc.
    public void destroy() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public String actOnSelected() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return execute();
    }

    // Implemented by subclasses
    protected abstract String execute();

    protected IProductCatalogue getProductCatalogue() {
        return jpa.getProductCatalogue();
    }

    protected IReservationRegistry getReservationRegistry() {
        return jpa.getReservationRegistry();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public Product getProduct() {
       return product;
    }
    
}
