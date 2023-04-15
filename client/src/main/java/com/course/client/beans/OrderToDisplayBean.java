package com.course.client.beans;

import java.util.List;

public class OrderToDisplayBean {


    private Long id;
    
    private List<OrderItemToDisplayBean> orderItemToDisplayBean;

    private double PrixOrder;

    public OrderToDisplayBean(Long id) {
        this.id = id;
    }

    public OrderToDisplayBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemToDisplayBean> getProducts() {
        return orderItemToDisplayBean;
    }

    public void addProduct(OrderItemToDisplayBean product) {
        this.orderItemToDisplayBean.add(product);
    }
    public void setOrderItemToDisplayBean(List<OrderItemToDisplayBean> orderItemToDisplayBean) {
        this.orderItemToDisplayBean = orderItemToDisplayBean;
    }

    public void setPrixOrder(double p) {
        PrixOrder = p ;
        //  this.products.forEach((n) ->  PrixOrder = PrixOrder + n.getPrixTotal());

    }

    public double getPrixOrder() {
        return PrixOrder;
    }
}
