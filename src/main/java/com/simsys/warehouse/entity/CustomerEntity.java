package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_customerid_seq", allocationSize = 1)
    @Column(name = "customerid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Boolean status;

    @Size(max = 20)
    @Column(name = "bankcard", length = 20)
    private String bankcard;

    @Column(name = "createddate")
    private LocalDate createddate;

    @Column(name = "updateddate")
    private LocalDate updateddate;

    @OneToMany(mappedBy = "customerid")
    private Set<OrderEntity> orderEntities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public LocalDate getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDate createddate) {
        this.createddate = createddate;
    }

    public LocalDate getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(LocalDate updateddate) {
        this.updateddate = updateddate;
    }

    public Set<OrderEntity> getOrders() {
        return orderEntities;
    }

    public void setOrders(Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

}