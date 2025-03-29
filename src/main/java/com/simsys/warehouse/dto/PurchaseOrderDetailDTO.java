package com.simsys.warehouse.dto;

import java.math.BigDecimal;

public class PurchaseOrderDetailDTO {
    private Integer id;
    private Integer purchaseOrderId; // Chỉ lấy ID của PurchaseOrderEntity
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal total;

    public PurchaseOrderDetailDTO() {
    }

    public PurchaseOrderDetailDTO(Integer id, Integer purchaseOrderId, BigDecimal price, Integer quantity, BigDecimal total) {
        this.id = id;
        this.purchaseOrderId = purchaseOrderId;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
