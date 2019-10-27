package com.enigma.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userId;
    private String userName;
    private String gender;

    @OneToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private List<Purchased> purchases = new ArrayList<>();


    public Users() {
    }

    public Users(String userName, String gender) {
        this.userName = userName;
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public List<Purchased> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchased> purchases) {
        this.purchases = purchases;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}

