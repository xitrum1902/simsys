package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderDTO {
    private Integer id;
    private Integer supplierId; // ID của SupplierEntity
    private Integer quantity;
    private String note;
    private BigDecimal totalAmount;
    private Boolean status;
    private LocalDate orderDate;
    private List<PurchaseOrderDetailDTO> purchaseOrderDetails; // Chi tiết đơn hàng

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(Integer id, Integer supplierId, Integer quantity, String note, BigDecimal totalAmount, Boolean status, LocalDate orderDate, List<PurchaseOrderDetailDTO> purchaseOrderDetails) {
        this.id = id;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.note = note;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.purchaseOrderDetails = purchaseOrderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public List<PurchaseOrderDetailDTO> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetailDTO> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
}
