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
    @NotNull(message = "Required") // The annotations for the inputfield(not showing when using primeface)
    private String name;
    @NotNull(message = "Required")
    private int quantity;
    @NotNull(message = "May not be null")
    @DecimalMin(value = "0.00", message = "Price must be 0 - 100000 (possible 2 decimals)")
    @DecimalMax(value = "100000.00", message = "Price must be 0 - 100000 (possible 2 decimals)")
    private String price;

    /**
     * Saves the new product in database
     *
     * @return String for the outcome that is used to redirect you to a specific
     * jsf page
     */
    public String save() {
        Product p = new Product(name, quantity, Double.valueOf(price));
        jpa.getProductCatalogue().add(p);
        return "PRODUCT_SUCCESS";
    }

    /**
     * Returns the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity
     *
     * @return name
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity
     *
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the price
     *
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
