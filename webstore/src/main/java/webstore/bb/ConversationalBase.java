package webstore.bb;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import webstore.core.IProductCatalogue;
import webstore.core.JPAStore;
import webstore.core.Product;

/**
 * 
 *
 * @author Jonas Ha
 */
public abstract class ConversationalBase implements Serializable {

    private Long id;
    private String name;
    private String price;
    
    @Inject
    private JPAStore jpa;
    
    
    @Inject
    private Conversation conversation;

    // Must have String???
    public void setSelected(String id) {
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected id={0}", id);
        if (conversation.isTransient()) {
            conversation.begin();
        }
        Product p = jpa.getProductCatalogue().find(Long.valueOf(id));
        Logger.getAnonymousLogger().log(Level.INFO, "setSelected p={0}", p);
        this.id = p.getId();
        this.name = p.getName();
        this.price = String.valueOf(p.getPrice());
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

        execute();
        return "products";
    }

    // Implemented by subclasses
    protected abstract void execute();

    protected IProductCatalogue getProductCatalogue() {
        return jpa.getProductCatalogue();
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
