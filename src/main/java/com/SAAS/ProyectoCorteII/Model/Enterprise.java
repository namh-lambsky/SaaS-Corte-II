package com.SAAS.ProyectoCorteII.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
@JsonIdentityInfo(scope= Enterprise.class ,generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Enterprise {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private String document;

    @Column(name = "phone")
    private long phone;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Enterprise() {
    }

    public Enterprise(int id, String name, String document, long phone, String address, Date created_at, Date updated_at, List<Employee> employees, List<Transaction> transactions) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.employees = employees;
        this.transactions = transactions;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", employees=" + employees +
                ", transactions=" + transactions +
                '}';
    }
}
