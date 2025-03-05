package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestOrderDTO {
    private Integer requestOrderId;
    private Integer productDetailId;
    private Integer totalQuantity;
    private String productName;
    private String colorValues;
    private String sizeValues;
    private Integer supplierId;
    private Integer userId;
    private BigDecimal costPrice;
    private BigDecimal totalAmount;
    private Boolean status;
    private LocalDate orderDate;
    private LocalDate createDate;

    // Getters & Setters
    public Integer getRequestOrderId() {
        return requestOrderId;
    }

    public void setRequestOrderId(Integer requestOrderId) {
        this.requestOrderId = requestOrderId;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColorValues() {
        return colorValues;
    }

    public void setColorValues(String colorValues) {
        this.colorValues = colorValues;
    }

    public String getSizeValues() {
        return sizeValues;
    }

    public void setSizeValues(String sizeValues) {
        this.sizeValues = sizeValues;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
