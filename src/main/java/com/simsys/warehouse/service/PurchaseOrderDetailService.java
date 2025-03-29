package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.PurchaseOrderDetailDTO;
import com.simsys.warehouse.entity.PurchaseOrderDetailEntity;
import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.mapper.PurchaseOrderDetailMapper;
import com.simsys.warehouse.repository.PurchaseOrderDetailRepository;
import com.simsys.warehouse.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderDetailService {

    private final PurchaseOrderDetailRepository purchaseOrderDetailRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderDetailService(PurchaseOrderDetailRepository purchaseOrderDetailRepository, PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderDetailRepository = purchaseOrderDetailRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrderDetailDTO createPurchaseOrderDetail(PurchaseOrderDetailDTO dto) {
        PurchaseOrderEntity purchaseOrderEntity = purchaseOrderRepository.findById(dto.getPurchaseOrderId())
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found with ID: " + dto.getPurchaseOrderId()));

        PurchaseOrderDetailEntity entity = PurchaseOrderDetailMapper.toEntity(dto, purchaseOrderEntity);
        return PurchaseOrderDetailMapper.toDTO(purchaseOrderDetailRepository.save(entity));
    }

    public List<PurchaseOrderDetailDTO> getAllPurchaseOrderDetails() {
        return purchaseOrderDetailRepository.findAll().stream()
                .map(PurchaseOrderDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PurchaseOrderDetailDTO getPurchaseOrderDetailById(Integer id) {
        PurchaseOrderDetailEntity entity = purchaseOrderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrderDetail not found with ID: " + id));
        return PurchaseOrderDetailMapper.toDTO(entity);
    }

    public PurchaseOrderDetailDTO updatePurchaseOrderDetail(Integer id, PurchaseOrderDetailDTO dto) {
        PurchaseOrderDetailEntity existingEntity = purchaseOrderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrderDetail not found with ID: " + id));

        PurchaseOrderEntity purchaseOrderEntity = purchaseOrderRepository.findById(dto.getPurchaseOrderId())
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found with ID: " + dto.getPurchaseOrderId()));

        existingEntity.setPurchaseorderid(purchaseOrderEntity);
        existingEntity.setPrice(dto.getPrice());
        existingEntity.setQuantity(dto.getQuantity());
        existingEntity.setTotal(dto.getTotal());

        return PurchaseOrderDetailMapper.toDTO(purchaseOrderDetailRepository.save(existingEntity));
    }

    public void deletePurchaseOrderDetail(Integer id) {
        PurchaseOrderDetailEntity existingEntity = purchaseOrderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrderDetail not found with ID: " + id));
        purchaseOrderDetailRepository.delete(existingEntity);
    }
}
