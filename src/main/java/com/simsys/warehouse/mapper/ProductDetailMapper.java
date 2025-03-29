package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.ProductDetailDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.ProductDetailVariantValueEntity;
import com.simsys.warehouse.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailMapper {
    public static ProductDetailDTO toDTO(ProductDetailEntity entity) {
        return new ProductDetailDTO(
                entity.getProductDetailId(),
                entity.getTotalQuantity(),
                entity.getProduct() != null ? entity.getProduct().getProductid() : null,
                entity.getVariantValues() != null
                        ? entity.getVariantValues().stream()
                        .map(ProductDetailVariantValueEntity::getId) // Assuming `getId` exists in `ProductDetailVariantValueEntity`
                        .collect(Collectors.toList())
                        : null
        );
    }

    public static ProductDetailEntity toEntity(ProductDetailDTO dto) {
        ProductDetailEntity entity = new ProductDetailEntity();
        entity.setProductDetailId(dto.getProductDetailId());
        entity.setTotalQuantity(dto.getTotalQuantity());

        if (dto.getProductId() != null) {
            ProductEntity product = new ProductEntity();
            product.setProductid(dto.getProductId());
            entity.setProduct(product);
        }

        if (dto.getVariantValueIds() != null) {
            List<ProductDetailVariantValueEntity> variantValues = dto.getVariantValueIds().stream().map(id -> {
                ProductDetailVariantValueEntity variantValue = new ProductDetailVariantValueEntity();
                variantValue.setId(id); // Assuming `setId` exists in `ProductDetailVariantValueEntity`
                return variantValue;
            }).collect(Collectors.toList());
            entity.setVariantValues(variantValues);
        }

        return entity;
    }
}
