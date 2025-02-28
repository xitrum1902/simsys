package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int saleprice;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private int consignmentid;

    public ProductEntity(int productid, String name, int saleprice, int quantity, String description, boolean status, int consignmentid) {
        this.productid = productid;
        this.name = name;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
        this.consignmentid = consignmentid;
    }

    public ProductEntity() {

    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(int saleprice) {
        this.saleprice = saleprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getConsignmentid() {
        return consignmentid;
    }

    public void setConsignmentid(int consignmentid) {
        this.consignmentid = consignmentid;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", saleprice=" + saleprice +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", consignmentid=" + consignmentid +
                '}';
    }
}
