package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "consignment")
public class ConsignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consignment_id_gen")
    @SequenceGenerator(name = "consignment_id_gen", sequenceName = "consignment_consignmentid_seq", allocationSize = 1)
    @Column(name = "consignmentid", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "sku")
    private String sku;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "totalquantity")
    private Integer totalquantity;

    @Column(name = "totalprice")
    private BigDecimal totalprice;

    @Column(name = "importdate")
    private LocalDate importdate;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplierid")
    private SupplierEntity supplierid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity userid;

    @OneToMany(mappedBy = "consignmentid")
    private Set<ProductEntity> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consignmentid")
    private Set<SupplierPerformanceEntity> supplierPerformanceEntities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(Integer totalquantity) {
        this.totalquantity = totalquantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public LocalDate getImportdate() {
        return importdate;
    }

    public void setImportdate(LocalDate importdate) {
        this.importdate = importdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SupplierEntity getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(SupplierEntity supplierid) {
        this.supplierid = supplierid;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public Set<SupplierPerformanceEntity> getSupplierperformances() {
        return supplierPerformanceEntities;
    }

    public void setSupplierperformances(Set<SupplierPerformanceEntity> supplierPerformanceEntities) {
        this.supplierPerformanceEntities = supplierPerformanceEntities;
    }

}