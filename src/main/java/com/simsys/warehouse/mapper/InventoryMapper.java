package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.InventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;

public class InventoryMapper {

    public static InventoryDTO toDTO(InventoryEntity entity) {
        return new InventoryDTO(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getQuantity(),
                entity.getDescription()
        );
    }

    public static InventoryEntity toEntity(InventoryDTO dto) {
        InventoryEntity entity = new InventoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setQuantity(dto.getQuantity());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
