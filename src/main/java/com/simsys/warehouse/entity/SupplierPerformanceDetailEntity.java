package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supplierperformancedetail")
public class SupplierPerformanceDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierperformancedetail_id_gen")
    @SequenceGenerator(name = "supplierperformancedetail_id_gen", sequenceName = "supplierperformancedetail_performancedetailid_seq", allocationSize = 1)
    @Column(name = "performancedetailid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performanceid")
    private SupplierPerformanceEntity performanceid;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variantvalueid")
    private VariantValueEntity variantvalueid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplierPerformanceEntity getPerformanceid() {
        return performanceid;
    }

    public void setPerformanceid(SupplierPerformanceEntity performanceid) {
        this.performanceid = performanceid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public VariantValueEntity getVariantvalueid() {
        return variantvalueid;
    }

    public void setVariantvalueid(VariantValueEntity variantvalueid) {
        this.variantvalueid = variantvalueid;
    }

}