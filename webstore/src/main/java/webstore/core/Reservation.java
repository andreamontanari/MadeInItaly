package webstore.core;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import webstore.utils.AbstractEntity;

/**
 * A Reservation
 *
 * @author Jonas Ha
 */
@Entity
@XmlRootElement
public class Reservation extends AbstractEntity {

    private String reserverName;
    private String reserverMail;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    public Reservation() {
    }

    public Reservation(String reserverName, String reserverMail, Product product) {
        this.reserverName = reserverName;
        this.reserverMail = reserverMail;
        this.product = product;
    }

    /**
     * Returns the product
     *
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the reservers name
     *
     * @return reserverName
     */
    public String getReserverName() {
        return reserverName;
    }

    /**
     * Sets the reservers name
     *
     * @param reserverName
     */
    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    /**
     * Returns the reservers email
     *
     * @return reserverMail
     */
    public String getReserverMail() {
        return reserverMail;
    }

    /**
     * Sets the reservers email
     *
     * @param reserverMail
     */
    public void setReserverMail(String reserverMail) {
        this.reserverMail = reserverMail;
    }
}
