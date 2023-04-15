package com.course.cart.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    private double prixCart;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> products;

    public void setPrixCart(double prixCart) {
        this.prixCart = prixCart;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }

    public double getPrixCart() {
        return prixCart;
    }
    public Cart(Long id,double prixCart) {
        this.id = id;
        this.prixCart=prixCart;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void addProduct(CartItem product) {
        this.products.add(product);
    }
    public void setPrixCart() {
        prixCart= 0;
        this.products.forEach((n) ->  prixCart = prixCart + n.getPrixTotal());

    }
}
