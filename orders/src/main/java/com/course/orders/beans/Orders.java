package com.course.orders.beans;



import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long orderId;

    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> products;

    private double prixCart;



    public Orders(Long orderId, Long id,double prixCart) {
        this.id = id;
        this.orderId =orderId;
        this.prixCart = prixCart;

    }

    public Orders() {

    }

    public void setOrderId(Long orderId) {
        this.id = orderId;
    }

    public void setCartId(Long cartId) {
        this.orderId = cartId;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;

    }

    public Long getOrderId() {
        return id;
    }

    public Long getCartId() {
        return orderId;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void addProduct(OrderItem product) {
        this.products.add(product);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrixOrder(double p) {
        prixCart = p ;
      //  this.products.forEach((n) ->  PrixOrder = PrixOrder + n.getPrixTotal());

    }

    public double getPrixOrder() {
        return prixCart;
    }
}
