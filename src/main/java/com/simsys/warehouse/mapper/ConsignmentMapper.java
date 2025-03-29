package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.ConsignmentDTO;
import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;

import java.util.stream.Collectors;

public class ConsignmentMapper {

    public static ConsignmentDTO toDTO(ConsignmentEntity entity) {
        return new ConsignmentDTO(
                entity.getId(),
                entity.getSku(),
                entity.getName(),
                entity.getDescription(),
                entity.getTotalquantity(),
                entity.getTotalprice(),
                entity.getImportdate(),
                entity.getStatus(),
                entity.getSupplierid() != null ? entity.getSupplierid().getSupplierId() : null,
                entity.getUserid() != null ? entity.getUserid().getUserId() : null,
                entity.getProducts().stream().map(product -> product.getProductid()).collect(Collectors.toList())
        );
    }

    public static ConsignmentEntity toEntity(ConsignmentDTO dto, SupplierEntity supplierEntity, UserEntity userEntity) {
        ConsignmentEntity entity = new ConsignmentEntity();
        entity.setId(dto.getId());
        entity.setSku(dto.getSku());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTotalquantity(dto.getTotalQuantity());
        entity.setTotalprice(dto.getTotalPrice());
        entity.setImportdate(dto.getImportDate());
        entity.setStatus(dto.getStatus());
        entity.setSupplierid(supplierEntity);
        entity.setUserid(userEntity);
        return entity;
    }
}
