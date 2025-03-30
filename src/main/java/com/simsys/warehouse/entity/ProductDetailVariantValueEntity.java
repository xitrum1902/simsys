package com.simsys.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productdetailvariantvalue")
public class ProductDetailVariantValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "productdetailid", nullable = false)
    private ProductDetailEntity productDetail;

    @ManyToOne
    @JoinColumn(name = "variantvalueid", nullable = false)
    private VariantValueEntity variantValue;

    public ProductDetailVariantValueEntity() {}

    public ProductDetailVariantValueEntity(Integer id, ProductDetailEntity productDetail, VariantValueEntity variantValue) {
        this.id = id;
        this.productDetail = productDetail;
        this.variantValue = variantValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDetailEntity getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailEntity productDetail) {
        this.productDetail = productDetail;
    }

    public VariantValueEntity getVariantValue() {
        return variantValue;
    }

    public void setVariantValue(VariantValueEntity variantValue) {
        this.variantValue = variantValue;
    }

    @Override
    public String toString() {
        return "ProductDetailVariantValueEntity{" +
                "id=" + id +
                ", productDetail=" + productDetail +
                ", variantValue=" + variantValue +
                '}';
    }
}
