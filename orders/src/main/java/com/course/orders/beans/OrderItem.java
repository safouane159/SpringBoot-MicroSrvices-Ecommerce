package com.course.orders.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long orderItemId;

    private Long cartItemId;
    private Long productId;

    private Long prixTotal;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Long id,Long cartItemId, Long productId, Integer quantity) {
        this.orderItemId = id;
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.quantity = quantity;

    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setPrixTotal(Long prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public Long getPrixTotal() {
        return prixTotal;
    }

    public Long getOrderItemId() {
        return orderItemId;
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
        return "Cart Item :"+orderItemId+":"+productId+":"+quantity;
    }
}
