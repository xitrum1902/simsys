package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.PurchaseOrderDetailDTO;
import com.simsys.warehouse.entity.PurchaseOrderDetailEntity;
import com.simsys.warehouse.entity.PurchaseOrderEntity;

public class PurchaseOrderDetailMapper {

    public static PurchaseOrderDetailDTO toDTO(PurchaseOrderDetailEntity entity) {
        return new PurchaseOrderDetailDTO(
                entity.getId(),
                entity.getPurchaseorderid() != null ? entity.getPurchaseorderid().getId() : null,
                entity.getPrice(),
                entity.getQuantity(),
                entity.getTotal()
        );
    }

    public static PurchaseOrderDetailEntity toEntity(PurchaseOrderDetailDTO dto, PurchaseOrderEntity purchaseOrderEntity) {
        PurchaseOrderDetailEntity entity = new PurchaseOrderDetailEntity();
        entity.setId(dto.getId());
        entity.setPurchaseorderid(purchaseOrderEntity);
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setTotal(dto.getTotal());
        return entity;
    }
}
