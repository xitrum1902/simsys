package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SupplierDTO {
    private Integer supplierId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private BigDecimal rating;
    private Integer userId; // Chỉ sử dụng ID của UserEntity

    public SupplierDTO() {
    }

    public SupplierDTO(Integer supplierId, String name, String phone, String email, String address, LocalDate createdDate, LocalDate updatedDate, BigDecimal rating, Integer userId) {
        this.supplierId = supplierId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.rating = rating;
        this.userId = userId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
