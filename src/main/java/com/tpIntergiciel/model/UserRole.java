package com.tpIntergiciel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by a602259 on 19/12/2016.
 */
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userroleid;
    private long idClient;
    private String role;

    public long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(long userroleid) {
        this.userroleid = userroleid;
    }

    public long getUserid() {
        return idClient;
    }

    public void setUserid(long idClient) {
        this.idClient = idClient;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
