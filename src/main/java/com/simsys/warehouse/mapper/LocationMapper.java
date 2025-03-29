package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.LocationDTO;
import com.simsys.warehouse.entity.LocationEntity;

public class LocationMapper {

    public static LocationDTO toDTO(LocationEntity entity) {
        return new LocationDTO(
                entity.getId(),
                entity.getLocationname(),
                entity.getAddress(),
                entity.getDescription(),
                entity.getPhonenumber()
        );
    }

    public static LocationEntity toEntity(LocationDTO dto) {
        LocationEntity entity = new LocationEntity();
        entity.setId(dto.getId());
        entity.setLocationname(dto.getLocationName());
        entity.setAddress(dto.getAddress());
        entity.setDescription(dto.getDescription());
        entity.setPhonenumber(dto.getPhoneNumber());
        return entity;
    }
}
