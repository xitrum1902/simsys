package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.TransferRequestDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.TransferRequestEntity;

public class TransferRequestMapper {

    public static TransferRequestDTO toDTO(TransferRequestEntity entity) {
        return new TransferRequestDTO(
                entity.getId(),
                entity.getNote(),
                entity.getQuantity(),
                entity.getTransferdate(),
                entity.getToinventoryid() != null ? entity.getToinventoryid().getId() : null
        );
    }

    public static TransferRequestEntity toEntity(TransferRequestDTO dto, InventoryEntity toInventory) {
        TransferRequestEntity entity = new TransferRequestEntity();
        entity.setId(dto.getId());
        entity.setNote(dto.getNote());
        entity.setQuantity(dto.getQuantity());
        entity.setTransferdate(dto.getTransferDate());
        entity.setToinventoryid(toInventory);
        return entity;
    }
}
