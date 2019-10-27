package com.enigma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchased_detail")
public class PurchaseDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String detailId;

    private Integer quantity;
    private BigDecimal subTotalPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    Product product;

    @Transient
    private String productId;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    @JsonIgnore
    private Purchased purchased;

    public PurchaseDetail() {
    }

    public PurchaseDetail(String productId, Integer quantity, BigDecimal subTotalPrice, Product product, Purchased purchased) {
        this.quantity = quantity;
        this.subTotalPrice = subTotalPrice;
        this.product = product;
        this.purchased = purchased;
    }



    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(BigDecimal subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public Purchased getPurchased() {
        return purchased;
    }

    public void setPurchased(Purchased purchased) {
        this.purchased = purchased;
    }

    public void setPurchasePrice(BigDecimal price){
        this.subTotalPrice = price.multiply(new BigDecimal(this.quantity));
    }

    public  BigDecimal getPurchasePrice(){
        return subTotalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
