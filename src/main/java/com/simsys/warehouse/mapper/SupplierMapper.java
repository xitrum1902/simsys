package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.SupplierDTO;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;

public class SupplierMapper {

    public static SupplierDTO toDTO(SupplierEntity entity) {
        return new SupplierDTO(
                entity.getSupplierId(),
                entity.getName(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getCreatedDate(),
                entity.getUpdatedDate(),
                entity.getRating(),
                entity.getUser().getUserId() // Lấy ID của UserEntity
        );
    }

    public static SupplierEntity toEntity(SupplierDTO dto, UserEntity user) {
        return new SupplierEntity(
                dto.getSupplierId(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getCreatedDate(),
                dto.getUpdatedDate(),
                dto.getRating(),
                user
        );
    }
}
