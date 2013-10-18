package webstore.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webstore.core.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-17T20:49:07")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, String> reserverName;
    public static volatile SingularAttribute<Reservation, Product> product;
    public static volatile SingularAttribute<Reservation, String> reserverMail;

}