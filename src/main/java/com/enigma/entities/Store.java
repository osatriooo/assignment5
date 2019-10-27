package com.enigma.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String storeId;


    private String storeName;
    private String description;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "store", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public Store(String storeName, String description, String address, String phoneNumber) {
        this.storeName = storeName;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store() {
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Product> getProducts() {
        return this.products = products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
