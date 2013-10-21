package webstore.bb;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import webstore.core.JPAStore;
import webstore.core.Product;
import webstore.core.Reservation;

/**
 * Backing bean for Add Reservation page
 *
 * @author Jonas Ha
 */
@Named("addReservation")
@ConversationScoped
public class AddReservationBB extends ConversationalBase {

    @Inject
    private JPAStore jpa;
    @NotNull(message = "Required")
    private String reserverName;
    @NotNull(message = "Required")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Must be an email e.g. example@example.com")
    private String reserverMail;

   @Override
    protected String execute() {
       Reservation r = new Reservation(reserverName, reserverMail, getProduct());
       jpa.getReservationRegistry().add(r);
       if(getProduct().getQuantity() <= 0){
          return Navigation.RESERVATION_FAIL.toString();
       }
       jpa.getProductCatalogue().update(new Product(getProduct().getId(), getProduct().getName(), (getProduct().getQuantity())-1, getProduct().getPrice()));
       return Navigation.RESERVATION_SUCCESS.toString();
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
