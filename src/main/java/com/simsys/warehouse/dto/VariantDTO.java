package com.simsys.warehouse.dto;

public class VariantDTO {
    private Integer variantId;
    private String name;

    public VariantDTO() {
    }

    public VariantDTO(Integer variantId, String name) {
        this.variantId = variantId;
        this.name = name;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
