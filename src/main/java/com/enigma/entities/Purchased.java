package com.enigma.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchased")
public class Purchased {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String purchasedId;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users users;

    @Transient
    private String userId;

    @OneToMany(mappedBy = "purchased",cascade = CascadeType.PERSIST)
    private List<PurchaseDetail> purchaseDetailList = new ArrayList<>();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public Purchased() {
    }

    public Purchased(BigDecimal totalPrice, Users users, String userId) {
        this.totalPrice = totalPrice;
        this.users = users;
        this.userId = userId;
    }

    public Purchased(List<PurchaseDetail> purchaseDetailList) {
        this.purchaseDetailList = purchaseDetailList;
    }

    public List<PurchaseDetail> getPurchaseDetailList() {
        return purchaseDetailList;
    }

    public void setPurchaseDetailList(List<PurchaseDetail> purchaseDetailList) {
        this.purchaseDetailList = purchaseDetailList;
    }

    public String getPurchasedId() {
        return purchasedId;
    }

    public void setPurchasedId(String purchasedId) {
        this.purchasedId = purchasedId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetailList;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetailList = purchaseDetails;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal setTotalPricePurchased(BigDecimal total){
        return this.totalPrice= this.totalPrice.add(total);
    }
}
