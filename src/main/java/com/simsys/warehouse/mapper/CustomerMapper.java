package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.CustomerDTO;
import com.simsys.warehouse.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerDTO toDTO(CustomerEntity entity) {
        return new CustomerDTO(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getStatus(),
                entity.getBankcard(),
                entity.getCreateddate(),
                entity.getUpdateddate()
        );
    }

    public static CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setStatus(dto.getStatus());
        entity.setBankcard(dto.getBankcard());
        entity.setCreateddate(dto.getCreatedDate());
        entity.setUpdateddate(dto.getUpdatedDate());
        return entity;
    }
}
