package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "requestorder")
public class RequestOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestorderid")
    private Integer requestOrderID;

    @ManyToOne
    @JoinColumn(name = "supplierid", referencedColumnName = "supplierID")
    private SupplierEntity supplier;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userID")
    private UserEntity user;

    @Column(name = "costprice")
    private BigDecimal costPrice;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "totalamount")
    private BigDecimal totalAmount;

    @Column(name = "orderdate")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "productdetailid", referencedColumnName = "productDetailID")
    private ProductDetailEntity productDetail;

    @Column(name = "createdate")
    private LocalDate createDate;

    @Column(name = "description")
    private String description;


    public RequestOrderEntity() {
    }

    public RequestOrderEntity(Integer requestOrderID, SupplierEntity supplier, Integer quantity, String note, UserEntity user, BigDecimal costPrice, Boolean status, BigDecimal totalAmount, LocalDate orderDate, ProductDetailEntity productDetail, LocalDate createDate, String description) {
        this.requestOrderID = requestOrderID;
        this.supplier = supplier;
        this.quantity = quantity;
        this.note = note;
        this.user = user;
        this.costPrice = costPrice;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.productDetail = productDetail;
        this.createDate = createDate;
        this.description = description;
    }

    public Integer getRequestOrderID() {
        return requestOrderID;
    }

    public void setRequestOrderID(Integer requestOrderID) {
        this.requestOrderID = requestOrderID;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
