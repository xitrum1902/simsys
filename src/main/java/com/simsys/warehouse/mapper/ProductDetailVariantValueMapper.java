package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.ProductDetailVariantValueDTO;
import com.simsys.warehouse.entity.ProductDetailVariantValueEntity;

public class ProductDetailVariantValueMapper {

    public static ProductDetailVariantValueDTO toDTO(ProductDetailVariantValueEntity entity) {
        return new ProductDetailVariantValueDTO(
                entity.getId(),
                entity.getProductDetail() != null ? entity.getProductDetail().getProductDetailId() : null,
                entity.getVariantValue() != null ? entity.getVariantValue().getVariantValueID() : null
        );
    }

    public static ProductDetailVariantValueEntity toEntity(ProductDetailVariantValueDTO dto) {
        ProductDetailVariantValueEntity entity = new ProductDetailVariantValueEntity();
        entity.setId(dto.getId());
        // Associations (productDetail and variantValue) should be set in the service layer
        return entity;
    }
}
