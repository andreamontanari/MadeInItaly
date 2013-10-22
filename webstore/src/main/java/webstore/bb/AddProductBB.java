package webstore.bb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import webstore.core.JPAStore;
import webstore.core.Product;

/**
 * Backing Bean for the Add Product Page
 *
 * @author Jonas Ha
 */
@Named("addProduct")
@RequestScoped
public class AddProductBB {

    @Inject
    private JPAStore jpa;
    @NotNull(message = "Required")
    private String name;
    @NotNull(message = "Required")
    private int quantity;
    @NotNull(message = "May not be null")
    @DecimalMin(value = "0.00", message = "Price must be 0 - 100000 (possible 2 decimals)")
    @DecimalMax(value = "100000.00", message = "Price must be 0 - 100000 (possible 2 decimals)")
    private String price;
   
    public String save() {
        Product p = new Product(name, quantity, Double.valueOf(price));
        jpa.getProductCatalogue().add(p);
        return Navigation.PRODUCT_SUCCESS.toString();  // TODO
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
}
