package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "purchaseorderdetail")
public class PurchaseOrderDetailEntity {
    @Id
    @ColumnDefault("nextval('purchaseorderdetail_purchaseorderdetailid_seq')")
    @Column(name = "purchaseorderdetailid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseorderid")
    private PurchaseOrderEntity purchaseorderid;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PurchaseOrderEntity getPurchaseorderid() {
        return purchaseorderid;
    }

    public void setPurchaseorderid(PurchaseOrderEntity purchaseorderid) {
        this.purchaseorderid = purchaseorderid;
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