package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.VariantValueDTO;
import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.entity.VariantValueEntity;

public class VariantValueMapper {

    public static VariantValueDTO toDTO(VariantValueEntity entity) {
        return new VariantValueDTO(
                entity.getVariantValueID(),
                entity.getValue(),
                entity.getVariant() != null ? entity.getVariant().getVariantID() : null
        );
    }

    public static VariantValueEntity toEntity(VariantValueDTO dto, VariantEntity variantEntity) {
        return new VariantValueEntity(
                dto.getVariantValueId(),
                dto.getValue(),
                variantEntity
        );
    }
}
