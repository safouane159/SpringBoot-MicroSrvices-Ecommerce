package com.course.client.beans;


import java.util.List;

public class CartBean {
    private Long id;

    private List<CartItemBean> products;

    private double prixCart;

    public CartBean(Long id,double prixCart) {
        this.id = id;
        this.prixCart=prixCart;
    }

    public CartBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemBean> getProducts() {
        return products;
    }
    public double getPrixCart() {
        return prixCart;
    }
    public void addProduct(CartItemBean product) {
        this.products.add(product);
    }
    public void setPrixOrder(double p) {
        prixCart = p ;
        //  this.products.forEach((n) ->  PrixOrder = PrixOrder + n.getPrixTotal());

    }

    public double getPrixOrder() {
        return prixCart;
    }
}
