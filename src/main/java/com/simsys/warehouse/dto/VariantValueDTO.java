package com.simsys.warehouse.dto;

public class VariantValueDTO {
    private Integer variantValueId;
    private String value;
    private Integer variantId;

    public VariantValueDTO() {
    }

    public VariantValueDTO(Integer variantValueId, String value, Integer variantId) {
        this.variantValueId = variantValueId;
        this.value = value;
        this.variantId = variantId;
    }

    public Integer getVariantValueId() {
        return variantValueId;
    }

    public void setVariantValueId(Integer variantValueId) {
        this.variantValueId = variantValueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getVariantId() {
        return variantId;
    }

    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }
}
