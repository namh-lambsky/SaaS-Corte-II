package com.SAAS.ProyectoCorteII.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name = "transaction")
@JsonIdentityInfo(scope= Transaction.class, generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Transaction {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "concept")
    private String concept;

    @Column(name = "amount")
    private long amount;


    @Column(name = "created_at")
    private Date created_at;


    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    private Enterprise enterprise;

    public Transaction() {
    }

    public Transaction(int id, String concept, long amount, Date created_at, Date updated_at, Employee employee, Enterprise enterprise) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.employee = employee;
        this.enterprise = enterprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", employee=" + employee +
                ", enterprise=" + enterprise +
                '}';
    }
}
