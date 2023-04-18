package com.SAAS.ProyectoCorteII.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "profile")
@JsonIdentityInfo(scope =Profile.class , generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Profile {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "phone")
    private long phone;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private Employee employee;

    public Profile() {
    }

    public Profile(int id, String image, long phone, Date created_at, Date updated_at, Employee employee) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.employee = employee;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", phone=" + phone +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", employee=" + employee.getId() +
                '}';
    }

}
