package com.course.client.beans;

import java.util.List;

public class OrderBean {
    private Long id;

    private List<CartItemBean> products;
    private double PrixOrder;


    public OrderBean(Long id) {
        this.id = id;
    }

    public OrderBean() {
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

    public void addProduct(CartItemBean product) {
        this.products.add(product);
    }
    public void setPrixOrder(double p) {
        PrixOrder = p ;
        //  this.products.forEach((n) ->  PrixOrder = PrixOrder + n.getPrixTotal());

    }

    public double getPrixOrder() {
        return PrixOrder;
    }
}
