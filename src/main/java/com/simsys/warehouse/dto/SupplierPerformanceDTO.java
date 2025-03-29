package com.simsys.warehouse.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SupplierPerformanceDTO {
    private Integer id;
    private BigDecimal onTimeDeliveryRate;
    private BigDecimal productQualityRating;
    private String notes;
    private BigDecimal rulesCompletionRate;
    private LocalDate lastEvaluated;
    private Integer consignmentId;
    private Boolean status;

    // Constructors
    public SupplierPerformanceDTO() {}

    public SupplierPerformanceDTO(Integer id, BigDecimal onTimeDeliveryRate, BigDecimal productQualityRating, String notes,
                                  BigDecimal rulesCompletionRate, LocalDate lastEvaluated, Integer consignmentId, Boolean status) {
        this.id = id;
        this.onTimeDeliveryRate = onTimeDeliveryRate;
        this.productQualityRating = productQualityRating;
        this.notes = notes;
        this.rulesCompletionRate = rulesCompletionRate;
        this.lastEvaluated = lastEvaluated;
        this.consignmentId = consignmentId;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOnTimeDeliveryRate() {
        return onTimeDeliveryRate;
    }

    public void setOnTimeDeliveryRate(BigDecimal onTimeDeliveryRate) {
        this.onTimeDeliveryRate = onTimeDeliveryRate;
    }

    public BigDecimal getProductQualityRating() {
        return productQualityRating;
    }

    public void setProductQualityRating(BigDecimal productQualityRating) {
        this.productQualityRating = productQualityRating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getRulesCompletionRate() {
        return rulesCompletionRate;
    }

    public void setRulesCompletionRate(BigDecimal rulesCompletionRate) {
        this.rulesCompletionRate = rulesCompletionRate;
    }

    public LocalDate getLastEvaluated() {
        return lastEvaluated;
    }

    public void setLastEvaluated(LocalDate lastEvaluated) {
        this.lastEvaluated = lastEvaluated;
    }

    public Integer getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(Integer consignmentId) {
        this.consignmentId = consignmentId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
