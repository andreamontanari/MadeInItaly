package webstore.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webstore.core.Reservation;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-17T20:49:07")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile ListAttribute<Product, Reservation> reservations;

}