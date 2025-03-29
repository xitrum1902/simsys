package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ConsignmentDTO {
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private Integer totalQuantity;
    private BigDecimal totalPrice;
    private LocalDate importDate;
    private String status;
    private Integer supplierId; // ID của SupplierEntity
    private Integer userId; // ID của UserEntity
    private List<Integer> productIds; // Danh sách ID sản phẩm liên kết

    public ConsignmentDTO() {
    }

    public ConsignmentDTO(Integer id, String sku, String name, String description, Integer totalQuantity, BigDecimal totalPrice, LocalDate importDate, String status, Integer supplierId, Integer userId, List<Integer> productIds) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.importDate = importDate;
        this.status = status;
        this.supplierId = supplierId;
        this.userId = userId;
        this.productIds = productIds;
    }

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
