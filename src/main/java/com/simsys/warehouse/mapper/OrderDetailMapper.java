package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.OrderDetailDTO;
import com.simsys.warehouse.entity.OrderDetailEntity;

public class OrderDetailMapper {

    public static OrderDetailDTO toDTO(OrderDetailEntity entity) {
        return new OrderDetailDTO(
                entity.getId(),
                entity.getQuantity(),
                entity.getUserinventoryid() != null ? entity.getUserinventoryid().getId() : null,
                entity.getSaleprice(),
                entity.getOrderid() != null ? entity.getOrderid().getId() : null
        );
    }

    public static OrderDetailEntity toEntity(OrderDetailDTO dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(dto.getId());
        entity.setQuantity(dto.getQuantity());
        entity.setSaleprice(dto.getSalePrice());
        // UserInventoryEntity and OrderEntity should be set separately in the service layer
        return entity;
    }
}
