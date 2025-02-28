package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Variant")
public class VariantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VariantID")
    private Integer variantID;

    @Column(name = "Name")
    private String name;

    public VariantEntity(Integer variantID, String name) {
        this.variantID = variantID;
        this.name = name;
    }

    public VariantEntity() {
    }

    public Integer getVariantID() {
        return variantID;
    }

    public void setVariantID(Integer variantID) {
        this.variantID = variantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
