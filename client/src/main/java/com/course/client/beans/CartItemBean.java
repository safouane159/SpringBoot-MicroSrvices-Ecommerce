package com.course.client.beans;

public class CartItemBean {

    private Long id;

    private Long productId;

    private double prixTotal;
    private Integer quantity;

    public CartItemBean() {
    }

    public CartItemBean(Long id, Long productId,double prixTotal, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.prixTotal=prixTotal;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart Item :"+id+":"+productId+":"+quantity;
    }
}
