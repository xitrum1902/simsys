package com.simsys.warehouse.dto;

public class ProductDetailVariantValueDTO {
    private Integer id;
    private Integer productDetailId;
    private Integer variantValueId;

    public ProductDetailVariantValueDTO() {
    }

    public ProductDetailVariantValueDTO(Integer id, Integer productDetailId, Integer variantValueId) {
        this.id = id;
        this.productDetailId = productDetailId;
        this.variantValueId = variantValueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getVariantValueId() {
        return variantValueId;
    }

    public void setVariantValueId(Integer variantValueId) {
        this.variantValueId = variantValueId;
    }
}
