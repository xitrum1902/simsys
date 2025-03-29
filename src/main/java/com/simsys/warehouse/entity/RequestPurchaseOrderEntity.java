package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "requestpurchaseorder")
public class RequestPurchaseOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requestorderid")
    private Integer requestOrderId;

    @ManyToOne
    @JoinColumn(name = "supplierid", nullable = false)
    private SupplierEntity supplier;

    @ManyToOne
    @JoinColumn(name = "productdetailid", nullable = false)
    private ProductDetailEntity productDetail;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "costprice")
    private BigDecimal costPrice;

    @Column(name = "totalamount")
    private BigDecimal totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "isenable")
    private Boolean isEnable;

    @Column(name = "orderdate")
    @Temporal(TemporalType.DATE)
    private LocalDate orderDate;

    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private LocalDate createDate;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "size", columnDefinition = "TEXT")
    private String size;

    @Column(name = "color", columnDefinition = "TEXT")
    private String color;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Constructors
    public RequestPurchaseOrderEntity() {
    }

    public RequestPurchaseOrderEntity(Integer requestOrderId, SupplierEntity supplier, ProductDetailEntity productDetail, UserEntity user, Integer quantity, BigDecimal costPrice, BigDecimal totalAmount, String status,Boolean isEnable, LocalDate orderDate, LocalDate createDate, String note, String size, String color, String description) {
        this.requestOrderId = requestOrderId;
        this.supplier = supplier;
        this.productDetail = productDetail;
        this.user = user;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.totalAmount = totalAmount;
        this.status = status;
        this.isEnable = isEnable;
        this.orderDate = orderDate;
        this.createDate = createDate;
        this.note = note;
        this.size = size;
        this.color = color;
        this.description = description;
    }

    // Getters and Setters
    public Integer getRequestOrderId() {
        return requestOrderId;
    }

    public void setRequestOrderId(Integer requestOrderId) {
        this.requestOrderId = requestOrderId;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
