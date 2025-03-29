package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.SupplierPerformanceDTO;
import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.entity.SupplierPerformanceEntity;

public class SupplierPerformanceMapper {

    public static SupplierPerformanceDTO toDTO(SupplierPerformanceEntity entity) {
        return new SupplierPerformanceDTO(
                entity.getId(),
                entity.getOntimedeliveryrate(),
                entity.getProductqualityrating(),
                entity.getNotes(),
                entity.getRulescompletionrate(),
                entity.getLastevaluated(),
                entity.getConsignmentid() != null ? entity.getConsignmentid().getId() : null,
                entity.getStatus()
        );
    }

    public static SupplierPerformanceEntity toEntity(SupplierPerformanceDTO dto, ConsignmentEntity consignmentEntity) {
        SupplierPerformanceEntity entity = new SupplierPerformanceEntity();
        entity.setId(dto.getId());
        entity.setOntimedeliveryrate(dto.getOnTimeDeliveryRate());
        entity.setProductqualityrating(dto.getProductQualityRating());
        entity.setNotes(dto.getNotes());
        entity.setRulescompletionrate(dto.getRulesCompletionRate());
        entity.setLastevaluated(dto.getLastEvaluated());
        entity.setConsignmentid(consignmentEntity);
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
