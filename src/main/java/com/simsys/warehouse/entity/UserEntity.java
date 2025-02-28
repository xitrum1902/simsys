package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID;

    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "contactinfo")
    private String contactInfo;

    @Column(name = "createddate")
    private LocalDate createdDate;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "roleID")
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    private List<SupplierEntity> suppliers;

    @OneToMany(mappedBy = "user")
    private List<RequestOrderEntity> requestOrders;

    // Constructors, Getters và Setters

    public UserEntity() {
    }

    public UserEntity(Integer userID, String username, String password, String email, String contactInfo,
                      LocalDate createdDate, Boolean status, RoleEntity role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactInfo = contactInfo;
        this.createdDate = createdDate;
        this.status = status;
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<SupplierEntity> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierEntity> suppliers) {
        this.suppliers = suppliers;
    }

    public List<RequestOrderEntity> getRequestOrders() {
        return requestOrders;
    }

    public void setRequestOrders(List<RequestOrderEntity> requestOrders) {
        this.requestOrders = requestOrders;
    }
}
