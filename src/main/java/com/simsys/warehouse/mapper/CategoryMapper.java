package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.CategoryDTO;
import com.simsys.warehouse.entity.CategoryEntity;
import com.simsys.warehouse.entity.ProductEntity;

public class CategoryMapper {

    public static CategoryDTO toDTO(CategoryEntity entity) {
        return new CategoryDTO(
                entity.getId(),
                entity.getName(),
                entity.getProductid() != null ? entity.getProductid().getProductid() : null
        );
    }

    public static CategoryEntity toEntity(CategoryDTO dto, ProductEntity productEntity) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setProductid(productEntity);
        return entity;
    }
}
