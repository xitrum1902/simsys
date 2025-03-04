package com.simsys.warehouse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productdetail")
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private Integer productDetailId;

    @Column(name = "totalquantity")
    private Integer totalQuantity;

    @ManyToOne
    @JoinColumn(name = "productid")
    private ProductEntity product;

    @OneToMany(mappedBy = "productDetail")
    private List<ProductDetailVariantValueEntity> variantValues;

    public ProductDetailEntity() {
    }

    public ProductDetailEntity(Integer productDetailID, Integer totalQuantity, ProductEntity product, List<ProductDetailVariantValueEntity> variantValues) {
        this.productDetailId = productDetailID;
        this.totalQuantity = totalQuantity;
        this.product = product;
        this.variantValues = variantValues;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
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