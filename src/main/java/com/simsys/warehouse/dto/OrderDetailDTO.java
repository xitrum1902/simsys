package com.simsys.warehouse.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {
    private Integer id;
    private Integer quantity;
    private Integer userInventoryId; // Reference to UserInventoryEntity
    private BigDecimal salePrice;
    private Integer orderId; // Reference to OrderEntity

    // Constructors
    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Integer id, Integer quantity, Integer userInventoryId, BigDecimal salePrice, Integer orderId) {
        this.id = id;
        this.quantity = quantity;
        this.userInventoryId = userInventoryId;
        this.salePrice = salePrice;
        this.orderId = orderId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUserInventoryId() {
        return userInventoryId;
    }

    public void setUserInventoryId(Integer userInventoryId) {
        this.userInventoryId = userInventoryId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
