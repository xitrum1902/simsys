package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.PurchaseOrderDTO;
import com.simsys.warehouse.dto.PurchaseOrderDetailDTO;
import com.simsys.warehouse.entity.PurchaseOrderDetailEntity;
import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;

import java.util.stream.Collectors;

public class PurchaseOrderMapper {

    public static PurchaseOrderDTO toDTO(PurchaseOrderEntity entity) {
        return new PurchaseOrderDTO(
                entity.getId(),
                entity.getSupplierid() != null ? entity.getSupplierid().getSupplierId() : null,
                entity.getQuantity(),
                entity.getNote(),
                entity.getTotalamount(),
                entity.getStatus(),
                entity.getOrderdate(),
                entity.getPurchaseorderdetails().stream()
                        .map(PurchaseOrderDetailMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }

    public static PurchaseOrderEntity toEntity(PurchaseOrderDTO dto, SupplierEntity supplierEntity) {
        PurchaseOrderEntity entity = new PurchaseOrderEntity();
        entity.setId(dto.getId());
        entity.setSupplierid(supplierEntity);
        entity.setQuantity(dto.getQuantity());
        entity.setNote(dto.getNote());
        entity.setTotalamount(dto.getTotalAmount());
        entity.setStatus(dto.getStatus());
        entity.setOrderdate(dto.getOrderDate());
        return entity;
    }
}
