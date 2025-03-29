package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.dto.ProductDTO;

public class ProductMapper {

    // Chuyển từ ProductEntity sang ProductDTO
    public static ProductDTO toDTO(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProductDTO(
                entity.getProductid(),
                entity.getName(),
                entity.getSaleprice(),
                entity.getQuantity(),
                entity.getDescription(),
                entity.isStatus(),
                entity.getConsignmentid()
        );
    }

    // Chuyển từ ProductDTO sang ProductEntity
    public static ProductEntity toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        return new ProductEntity(
                dto.getProductid(),
                dto.getName(),
                dto.getSaleprice(),
                dto.getQuantity(),
                dto.getDescription(),
                dto.isStatus(),
                dto.getConsignmentid()
        );
    }
}
