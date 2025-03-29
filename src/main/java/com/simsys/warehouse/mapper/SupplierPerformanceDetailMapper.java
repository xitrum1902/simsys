package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.SupplierPerformanceDetailDTO;
import com.simsys.warehouse.entity.SupplierPerformanceDetailEntity;

public class SupplierPerformanceDetailMapper {

    public static SupplierPerformanceDetailDTO toDTO(SupplierPerformanceDetailEntity entity) {
        return new SupplierPerformanceDetailDTO(
                entity.getId(),
                entity.getPerformanceid() != null ? entity.getPerformanceid().getId() : null,
                entity.getStatus(),
                entity.getVariantvalueid() != null ? entity.getVariantvalueid().getVariantValueID(): null
        );
    }

    public static SupplierPerformanceDetailEntity toEntity(SupplierPerformanceDetailDTO dto) {
        SupplierPerformanceDetailEntity entity = new SupplierPerformanceDetailEntity();
        entity.setId(dto.getId());
        // Note: Setting associations like performanceid and variantvalueid requires fetching these entities from their respective repositories
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
