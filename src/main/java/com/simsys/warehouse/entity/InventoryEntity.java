package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @ColumnDefault("nextval('inventory_inventoryid_seq')")
    @Column(name = "inventoryid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locationid")
    private com.simsys.warehouse.entity.LocationEntity locationid;

    public com.simsys.warehouse.entity.LocationEntity getLocationid() {
        return locationid;
    }

    public void setLocationid(com.simsys.warehouse.entity.LocationEntity locationid) {
        this.locationid = locationid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}