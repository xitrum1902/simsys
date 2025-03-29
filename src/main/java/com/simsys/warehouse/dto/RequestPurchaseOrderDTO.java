package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestPurchaseOrderDTO {

    private Integer requestOrderId;
    private Integer supplierId;
    private Integer productDetailId;
    private Integer userId;
    private Integer quantity;
    private BigDecimal costPrice;
    private BigDecimal totalAmount;
    private String status;
    private Boolean isEnable;
    private LocalDate orderDate;
    private LocalDate createDate;
    private String note;
    private String size;
    private String color;
    private String description;
    private String ProductName;

    // Constructors
    public RequestPurchaseOrderDTO() {
    }

    public RequestPurchaseOrderDTO(Integer requestOrderId, Integer supplierId, Integer productDetailId, Integer userId,
                                   Integer quantity, BigDecimal costPrice, BigDecimal totalAmount, String status,
                                   Boolean isEnable, LocalDate orderDate, LocalDate createDate, String note,
                                   String size, String color, String description) {
        this.requestOrderId = requestOrderId;
        this.supplierId = supplierId;
        this.productDetailId = productDetailId;
        this.userId = userId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.totalAmount = totalAmount;
        this.status = status;
        this.isEnable = isEnable;
        this.orderDate = orderDate;
        this.createDate = createDate;
        this.note = note;
        this.size = size;
        this.color = color;
        this.description = description;
    }

    public RequestPurchaseOrderDTO(Integer requestOrderId, Integer supplierId, Integer productDetailId, Integer userId, Integer quantity, BigDecimal costPrice, BigDecimal totalAmount, String status, LocalDate orderDate, LocalDate createDate, String note, String size, String color, String description) {
        this.requestOrderId = requestOrderId;
        this.supplierId = supplierId;
        this.productDetailId = productDetailId;
        this.userId = userId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.createDate = createDate;
        this.note = note;
        this.size = size;
        this.color = color;
        this.description = description;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    // Getters and Setters
    public Integer getRequestOrderId() {
        return requestOrderId;
    }

    public void setRequestOrderId(Integer requestOrderId) {
        this.requestOrderId = requestOrderId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
