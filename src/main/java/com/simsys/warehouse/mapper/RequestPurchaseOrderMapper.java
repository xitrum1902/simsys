package com.simsys.warehouse.mapper;

import com.simsys.warehouse.dto.RequestPurchaseOrderDTO;
import com.simsys.warehouse.entity.ProductDetailEntity;
import com.simsys.warehouse.entity.RequestPurchaseOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RequestPurchaseOrderMapper {

    public RequestPurchaseOrderDTO mapToDTO(RequestPurchaseOrderEntity entity) {
        RequestPurchaseOrderDTO dto = new RequestPurchaseOrderDTO();
        dto.setRequestOrderId(entity.getRequestOrderId());
        dto.setProductDetailId(entity.getProductDetail().getProductDetailId());
        dto.setQuantity(entity.getQuantity());
        dto.setSupplierId(entity.getSupplier().getSupplierId());
        dto.setColor(entity.getColor());
        dto.setSize(entity.getSize());
        dto.setSupplierId(entity.getSupplier().getSupplierId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setCostPrice(entity.getCostPrice());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setStatus(entity.getStatus());
        dto.setOrderDate(entity.getOrderDate());
        dto.setCreateDate(entity.getCreateDate());
        dto.setEnable(entity.getEnable());
        return dto;
    }

    public RequestPurchaseOrderEntity mapToEntity(RequestPurchaseOrderDTO dto, SupplierEntity supplier, UserEntity user, ProductDetailEntity productDetail) {
        RequestPurchaseOrderEntity entity = new RequestPurchaseOrderEntity();
        entity.setProductDetail(productDetail);
        entity.setSupplier(supplier);
        entity.setUser(user);
        entity.setQuantity(dto.getQuantity());
        entity.setCostPrice(dto.getCostPrice());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setStatus(dto.getStatus());
        entity.setOrderDate(dto.getOrderDate());
        entity.setCreateDate(LocalDate.now());
        entity.setEnable(dto.getEnable());
        entity.setDescription(entity.getDescription());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        return entity;
    }
}
