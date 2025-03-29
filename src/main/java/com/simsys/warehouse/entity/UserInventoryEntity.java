package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "user_inventory")
public class UserInventoryEntity {
    @Id
    @ColumnDefault("nextval('user_inventory_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventoryid")
    private InventoryEntity inventoryid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public InventoryEntity getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(InventoryEntity inventoryid) {
        this.inventoryid = inventoryid;
    }

}