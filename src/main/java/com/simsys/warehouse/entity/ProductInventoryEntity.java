package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "product_inventory")
public class ProductInventoryEntity {
    @Id
    @ColumnDefault("nextval('product_inventory_productinventoryid_seq')")
    @Column(name = "productinventoryid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventoryid")
    private InventoryEntity inventoryid;

    @Column(name = "transferdate")
    private LocalDate transferdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventoryEntity getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(InventoryEntity inventoryid) {
        this.inventoryid = inventoryid;
    }

    public LocalDate getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(LocalDate transferdate) {
        this.transferdate = transferdate;
    }

}