package com.simsys.warehouse.dto;

public class SupplierPerformanceDetailDTO {
    private Integer id;
    private Integer performanceId;
    private Boolean status;
    private Integer variantValueId;

    // Constructors
    public SupplierPerformanceDetailDTO() {
    }

    public SupplierPerformanceDetailDTO(Integer id, Integer performanceId, Boolean status, Integer variantValueId) {
        this.id = id;
        this.performanceId = performanceId;
        this.status = status;
        this.variantValueId = variantValueId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getVariantValueId() {
        return variantValueId;
    }

    public void setVariantValueId(Integer variantValueId) {
        this.variantValueId = variantValueId;
    }
}
