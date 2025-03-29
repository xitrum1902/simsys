package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.VariantDTO;
import com.simsys.warehouse.entity.VariantEntity;

public class VariantMapper {

    public static VariantDTO toDTO(VariantEntity entity) {
        return new VariantDTO(
                entity.getVariantID(),
                entity.getName()
        );
    }

    public static VariantEntity toEntity(VariantDTO dto) {
        return new VariantEntity(
                dto.getVariantId(),
                dto.getName()
        );
    }
}
