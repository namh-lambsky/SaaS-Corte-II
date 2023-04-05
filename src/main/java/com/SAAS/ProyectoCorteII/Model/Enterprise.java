package com.SAAS.ProyectoCorteII.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class Enterprise {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "phone")
    private int phone;
    @Column(name = "address")
    private String address;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "transaction_id")
    private int transaction_id;
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private Date updatedAt;

    public Enterprise() {
    }

    public Enterprise(int id, String name, String document, int phone, String address, int user_id, int transaction_id) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.user_id = user_id;
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
