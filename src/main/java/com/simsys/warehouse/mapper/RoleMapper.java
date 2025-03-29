package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.RoleDTO;
import com.simsys.warehouse.entity.RoleEntity;

public class RoleMapper {

    public static RoleDTO toDTO(RoleEntity entity) {
        return new RoleDTO(
                entity.getRoleId(),
                entity.getRoleName(),
                entity.getDescription()
        );
    }

    public static RoleEntity toEntity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setRoleName(dto.getRoleName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
