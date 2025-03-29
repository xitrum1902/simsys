package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.UserDTO;
import com.simsys.warehouse.entity.RoleEntity;
import com.simsys.warehouse.entity.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity entity) {
        return new UserDTO(
                entity.getUserId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getContactInfo(),
                entity.getCreatedDate(),
                entity.getStatus(),
                entity.getRole().getRoleId() // Lấy ID của Role
        );
    }

    public static UserEntity toEntity(UserDTO dto, RoleEntity role) {
        return new UserEntity(
                dto.getUserId(),
                dto.getUsername(),
                null, // Không map password để bảo mật
                dto.getEmail(),
                dto.getContactInfo(),
                dto.getCreatedDate(),
                dto.getStatus(),
                role
        );
    }
}
