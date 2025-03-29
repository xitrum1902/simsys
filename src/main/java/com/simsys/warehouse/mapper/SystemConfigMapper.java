package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.SystemConfigDTO;
import com.simsys.warehouse.entity.SystemConfigEntity;

public class SystemConfigMapper {

    public static SystemConfigDTO toDTO(SystemConfigEntity entity) {
        return new SystemConfigDTO(
                entity.getId(),
                entity.getName(),
                entity.getConfigvalue(),
                entity.getDescription()
        );
    }

    public static SystemConfigEntity toEntity(SystemConfigDTO dto) {
        SystemConfigEntity entity = new SystemConfigEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setConfigvalue(dto.getConfigValue());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
