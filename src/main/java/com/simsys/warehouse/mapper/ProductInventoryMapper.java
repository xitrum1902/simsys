package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.ProductInventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.ProductInventoryEntity;

public class ProductInventoryMapper {

    public static ProductInventoryDTO toDTO(ProductInventoryEntity entity) {
        return new ProductInventoryDTO(
                entity.getId(),
                entity.getInventoryid() != null ? entity.getInventoryid().getId() : null,
                entity.getTransferdate()
        );
    }

    public static ProductInventoryEntity toEntity(ProductInventoryDTO dto, InventoryEntity inventoryEntity) {
        ProductInventoryEntity entity = new ProductInventoryEntity();
        entity.setId(dto.getId());
        entity.setInventoryid(inventoryEntity);
        entity.setTransferdate(dto.getTransferDate());
        return entity;
    }
}
