package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "supplierperformance")
public class SupplierPerformanceEntity {
    @Id
    @ColumnDefault("nextval('supplierperformance_performanceid_seq')")
    @Column(name = "performanceid", nullable = false)
    private Integer id;

    @Column(name = "ontimedeliveryrate")
    private BigDecimal ontimedeliveryrate;

    @Column(name = "productqualityrating")
    private BigDecimal productqualityrating;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "rulescompletionrate")
    private BigDecimal rulescompletionrate;

    @Column(name = "lastevaluated")
    private LocalDate lastevaluated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consignmentid")
    private ConsignmentEntity consignmentid;

    @Column(name = "status")
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOntimedeliveryrate() {
        return ontimedeliveryrate;
    }

    public void setOntimedeliveryrate(BigDecimal ontimedeliveryrate) {
        this.ontimedeliveryrate = ontimedeliveryrate;
    }

    public BigDecimal getProductqualityrating() {
        return productqualityrating;
    }

    public void setProductqualityrating(BigDecimal productqualityrating) {
        this.productqualityrating = productqualityrating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getRulescompletionrate() {
        return rulescompletionrate;
    }

    public void setRulescompletionrate(BigDecimal rulescompletionrate) {
        this.rulescompletionrate = rulescompletionrate;
    }

    public LocalDate getLastevaluated() {
        return lastevaluated;
    }

    public void setLastevaluated(LocalDate lastevaluated) {
        this.lastevaluated = lastevaluated;
    }

    public ConsignmentEntity getConsignmentid() {
        return consignmentid;
    }

    public void setConsignmentid(ConsignmentEntity consignmentid) {
        this.consignmentid = consignmentid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}