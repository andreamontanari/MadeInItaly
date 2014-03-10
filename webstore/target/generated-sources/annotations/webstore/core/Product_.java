package webstore.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import webstore.utils.AbstractEntity_;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T15:51:39")
@StaticMetamodel(Product.class)
public class Product_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> quantity;

}