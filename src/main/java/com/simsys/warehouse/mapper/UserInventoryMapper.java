package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.UserInventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.UserInventoryEntity;

public class UserInventoryMapper {

    public static UserInventoryDTO toDTO(UserInventoryEntity entity) {
        return new UserInventoryDTO(
                entity.getId(),
                entity.getStatus(),
                entity.getInventoryid() != null ? entity.getInventoryid().getId() : null
        );
    }

    public static UserInventoryEntity toEntity(UserInventoryDTO dto, InventoryEntity inventory) {
        UserInventoryEntity entity = new UserInventoryEntity();
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setInventoryid(inventory);
        return entity;
    }
}
