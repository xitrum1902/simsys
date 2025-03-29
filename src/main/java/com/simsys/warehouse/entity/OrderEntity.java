package com.simsys.warehouse.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "\"order\"")
public class OrderEntity {
    @Id
    @ColumnDefault("nextval('order_orderid_seq')")
    @Column(name = "orderid", nullable = false)
    private Integer id;

    @Column(name = "totalprice")
    private BigDecimal totalprice;

    @Column(name = "orderdate")
    private LocalDate orderdate;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private CustomerEntity customerid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CustomerEntity getCustomerid() {
        return customerid;
    }

    public void setCustomerid(CustomerEntity customerid) {
        this.customerid = customerid;
    }

}