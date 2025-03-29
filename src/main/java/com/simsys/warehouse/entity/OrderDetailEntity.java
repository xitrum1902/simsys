package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderdetail")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderdetail_id_gen")
    @SequenceGenerator(name = "orderdetail_id_gen", sequenceName = "orderdetail_orderdetailid_seq", allocationSize = 1)
    @Column(name = "orderdetailid", nullable = false)
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userinventoryid")
    private UserInventoryEntity userinventoryid;

    @Column(name = "saleprice")
    private BigDecimal saleprice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private OrderEntity orderid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserInventoryEntity getUserinventoryid() {
        return userinventoryid;
    }

    public void setUserinventoryid(UserInventoryEntity userinventoryid) {
        this.userinventoryid = userinventoryid;
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public OrderEntity getOrderid() {
        return orderid;
    }

    public void setOrderid(OrderEntity orderid) {
        this.orderid = orderid;
    }

}