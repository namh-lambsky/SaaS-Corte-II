package com.SAAS.ProyectoCorteII.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    @Column(name = "image",nullable = false)
    private String image;
    @Column(name = "phone",nullable = false)
    private int phone;
    @OneToOne(mappedBy = "profile")
    private Employee employee;
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private Date updatedAt;

    public Profile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
