package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "purchaseorder")
public class PurchaseOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseorder_id_gen")
    @SequenceGenerator(name = "purchaseorder_id_gen", sequenceName = "purchaseorder_purchaseorderid_seq", allocationSize = 1)
    @Column(name = "purchaseorderid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierid")
    private SupplierEntity supplierid;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note", length = Integer.MAX_VALUE)
    private String note;

    @Column(name = "totalamount")
    private BigDecimal totalamount;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "orderdate")
    private LocalDate orderdate;

    @OneToMany(mappedBy = "purchaseorderid")
    private Set<PurchaseOrderDetailEntity> purchaseorderdetailEntities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplierEntity getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(SupplierEntity supplierid) {
        this.supplierid = supplierid;
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

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public Set<PurchaseOrderDetailEntity> getPurchaseorderdetails() {
        return purchaseorderdetailEntities;
    }

    public void setPurchaseorderdetails(Set<PurchaseOrderDetailEntity> purchaseorderdetailEntities) {
        this.purchaseorderdetailEntities = purchaseorderdetailEntities;
    }

}