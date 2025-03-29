package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {
    private Integer id;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
    private Boolean status;
    private Integer customerId; // ID của khách hàng

    // Constructors
    public OrderDTO() {
    }

    public OrderDTO(Integer id, BigDecimal totalPrice, LocalDate orderDate, Boolean status, Integer customerId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        this.customerId = customerId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
