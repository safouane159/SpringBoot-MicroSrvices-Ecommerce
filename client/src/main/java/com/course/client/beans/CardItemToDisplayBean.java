package com.course.client.beans;

import javafx.scene.control.IndexRange;

public class CardItemToDisplayBean {



    public   Long quantite ;



    public   double prixTotal ;
   private  ProductBean product ;

    public CardItemToDisplayBean() {
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

    public double getPrixTotal() {
        return prixTotal;
    }
    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
