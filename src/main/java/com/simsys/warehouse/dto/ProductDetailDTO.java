package com.simsys.warehouse.dto;

import java.util.List;

public class ProductDetailDTO {
    private Integer productDetailId;
    private Integer totalQuantity;
    private Integer productId; // Chỉ lấy ID của product
    private List<Integer> variantValueIds; // Chỉ lấy danh sách ID của variantValues

    public ProductDetailDTO() {
    }

    public ProductDetailDTO(Integer productDetailId, Integer totalQuantity, Integer productId, List<Integer> variantValueIds) {
        this.productDetailId = productDetailId;
        this.totalQuantity = totalQuantity;
        this.productId = productId;
        this.variantValueIds = variantValueIds;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public List<Integer> getVariantValueIds() {
        return variantValueIds;
    }

    public void setVariantValueIds(List<Integer> variantValueIds) {
        this.variantValueIds = variantValueIds;
    }
}
