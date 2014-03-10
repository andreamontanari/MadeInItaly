package webstore.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webstore.core.Product;
import webstore.utils.AbstractEntity_;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T14:25:31")
@StaticMetamodel(Reservation.class)
public class Reservation_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Reservation, String> reserverName;
    public static volatile SingularAttribute<Reservation, Product> product;
    public static volatile SingularAttribute<Reservation, String> reserverMail;

}