package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "variantvalue")
public class VariantValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variantvalueid")
    private Integer variantValueID;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "variantid", referencedColumnName = "variantid")
    private VariantEntity variant;

    public VariantValueEntity() {
    }

    public VariantValueEntity(Integer variantValueID, String value, VariantEntity variant) {
        this.variantValueID = variantValueID;
        this.value = value;
        this.variant = variant;
    }

    public Integer getVariantValueID() {
        return variantValueID;
    }

    public void setVariantValueID(Integer variantValueID) {
        this.variantValueID = variantValueID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public VariantEntity getVariant() {
        return variant;
    }

    public void setVariant(VariantEntity variant) {
        this.variant = variant;
    }
}
