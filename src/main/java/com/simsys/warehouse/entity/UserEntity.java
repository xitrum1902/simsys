package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;

    @Column(name = "username", length = 255, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "contactinfo", columnDefinition = "TEXT")
    private String contactInfo;

    @Column(name = "createddate")
    private LocalDate createdDate;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private RoleEntity role;

    // Constructors
    public UserEntity() {
    }

    public UserEntity(Integer userId, String username, String password, String email, String contactInfo, LocalDate createdDate, Boolean status, RoleEntity role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactInfo = contactInfo;
        this.createdDate = createdDate;
        this.status = status;
        this.role = role;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
