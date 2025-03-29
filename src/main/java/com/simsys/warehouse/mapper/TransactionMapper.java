package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.TransactionDTO;
import com.simsys.warehouse.entity.TransactionEntity;

public class TransactionMapper {

    public static TransactionDTO toDTO(TransactionEntity entity) {
        return new TransactionDTO(
                entity.getId(),
                entity.getMoney(),
                entity.getNote(),
                entity.getDate(),
                entity.getUserid() != null ? entity.getUserid().getUserId() : null,
                entity.getOrderid() != null ? entity.getOrderid().getId() : null
        );
    }

    public static TransactionEntity toEntity(TransactionDTO dto) {
        TransactionEntity entity = new TransactionEntity();
        entity.setId(dto.getId());
        entity.setMoney(dto.getMoney());
        entity.setNote(dto.getNote());
        entity.setDate(dto.getDate());
        // Relationships (UserEntity and OrderEntity) will be set in the service layer
        return entity;
    }
}
