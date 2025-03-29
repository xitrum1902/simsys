package com.simsys.warehouse.dto;

import java.time.LocalDate;

public class UserDTO {
    private Integer userId;
    private String username;
    private String email;
    private String contactInfo;
    private LocalDate createdDate;
    private Boolean status;
    private Integer roleId; // ID của Role thay vì trả cả RoleEntity

    public UserDTO() {
    }

    public UserDTO(Integer userId, String username, String email, String contactInfo, LocalDate createdDate, Boolean status, Integer roleId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.contactInfo = contactInfo;
        this.createdDate = createdDate;
        this.status = status;
        this.roleId = roleId;
    }

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
