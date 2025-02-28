package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productdetail")
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private Integer productDetailID;

    @Column(name = "totalquantity")
    private Integer totalQuantity;

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private ProductEntity product;

    @OneToMany(mappedBy = "productDetail")
    private List<ProductDetailVariantValueEntity> variantValues;

    public ProductDetailEntity() {
    }

    public ProductDetailEntity(Integer productDetailID, Integer totalQuantity, ProductEntity product, List<ProductDetailVariantValueEntity> variantValues) {
        this.productDetailID = productDetailID;
        this.totalQuantity = totalQuantity;
        this.product = product;
        this.variantValues = variantValues;
    }

    public Integer getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(Integer productDetailID) {
        this.productDetailID = productDetailID;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<ProductDetailVariantValueEntity> getVariantValues() {
        return variantValues;
    }

    public void setVariantValues(List<ProductDetailVariantValueEntity> variantValues) {
        this.variantValues = variantValues;
    }
}
