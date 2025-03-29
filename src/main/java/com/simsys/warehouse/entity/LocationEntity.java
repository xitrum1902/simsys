package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_gen")
    @SequenceGenerator(name = "location_id_gen", sequenceName = "location_locationid_seq", allocationSize = 1)
    @Column(name = "locationid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "locationname")
    private String locationname;

    @Column(name = "address", length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Size(max = 20)
    @Column(name = "phonenumber", length = 20)
    private String phonenumber;

    @OneToMany(mappedBy = "locationid")
    private Set<InventoryEntity> inventories = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Set<InventoryEntity> getInventories() {
        return inventories;
    }

    public void setInventories(Set<InventoryEntity> inventories) {
        this.inventories = inventories;
    }

}