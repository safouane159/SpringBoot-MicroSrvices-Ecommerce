package com.course.client.beans;

public class OrderItemToDisplayBean {



    public   Long quantite ;



    public   double prixTotal ;
   private  ProductBean product ;

    public OrderItemToDisplayBean() {
    }

    public void setProduct(ProductBean product) {

        this.prixTotal = product.getPrice() * quantite;
        this.product = product;
    }

    public ProductBean getProduct() {
        return product;
    }


    public Long getQuantite() {
        return quantite;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public double getPrixTotal() {
        return prixTotal;
    }
    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
