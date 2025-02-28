package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierid")
    private Integer supplierID;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "createddate")
    private LocalDate createdDate;

    @Column(name = "updateddate")
    private LocalDate updatedDate;

    @Column(name = "rating")
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userID")
    private UserEntity user;

    @OneToMany(mappedBy = "supplier")
    private List<RequestOrderEntity> requestOrders;

    // Constructors, Getters và Setters

    public SupplierEntity() {
    }

    public SupplierEntity(Integer supplierID, String name, String phone, String email, String address,
                          LocalDate createdDate, LocalDate updatedDate, BigDecimal rating, UserEntity user) {
        this.supplierID = supplierID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.rating = rating;
        this.user = user;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<RequestOrderEntity> getRequestOrders() {
        return requestOrders;
    }

    public void setRequestOrders(List<RequestOrderEntity> requestOrders) {
        this.requestOrders = requestOrders;
    }
}
