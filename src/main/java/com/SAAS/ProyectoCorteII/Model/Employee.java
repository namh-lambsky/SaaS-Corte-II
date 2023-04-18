package com.SAAS.ProyectoCorteII.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;


import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@JsonIdentityInfo( scope = Employee.class ,generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Employee {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private Role role;


    @Column(name = "created_at")
    private Date created_at;


    @Column(name = "updated_at")
    private Date updated_at;

    @OneToOne
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Transaction> transactions;


    public Employee() {
    }

    public Employee(int id, String email, Role role, Date created_at, Date updated_at, Profile profile, Enterprise enterprise, List<Transaction> transactions) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.profile = profile;
        this.enterprise = enterprise;
        this.transactions = transactions;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", profile=" + profile.getId() +
                ", enterprise=" + enterprise.getId() +
                ", transactions=" + transactions +
                '}';
    }
}
