package com.SAAS.ProyectoCorteII.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Column(name = "email")
    private String email;
    @Column(name = "profile_id")
    private int profile_id;
    @Column(name = "role")
    private int role;
    @Column(name = "enterprise_id")
    private int enterprise_id;
    @Column(name = "transaction_id")
    private int transaction_id;
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private Date updatedAt;

    public Employee() {
    }

    public Employee(int id, String email, int profile_id, int role, int enterprise_id, int transaction_id) {
        this.id = id;
        this.email = email;
        this.profile_id = profile_id;
        this.role = role;
        this.enterprise_id = enterprise_id;
        this.transaction_id = transaction_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(int enterprise_id) {
        this.enterprise_id = enterprise_id;
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
