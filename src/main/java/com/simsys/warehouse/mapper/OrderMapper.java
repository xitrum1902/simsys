package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.OrderDTO;
import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.entity.OrderEntity;

public class OrderMapper {

    public static OrderDTO toDTO(OrderEntity entity) {
        return new OrderDTO(
                entity.getId(),
                entity.getTotalprice(),
                entity.getOrderdate(),
                entity.getStatus(),
                entity.getCustomerid() != null ? entity.getCustomerid().getId() : null
        );
    }

    public static OrderEntity toEntity(OrderDTO dto, CustomerEntity customerEntity) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setTotalprice(dto.getTotalPrice());
        entity.setOrderdate(dto.getOrderDate());
        entity.setStatus(dto.getStatus());
        entity.setCustomerid(customerEntity); // Gán thực thể khách hàng
        return entity;
    }
}
