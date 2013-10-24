package webstore.core;

import webstore.utils.AbstractEntity;
import javax.persistence.Entity;

/**
 * A Product
 *
 * @author Jonas Ha
 */
@Entity
public class Product extends AbstractEntity {

    private String name;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(Long id, String name, int quantity, double price) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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
     * Returns the quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }
}
