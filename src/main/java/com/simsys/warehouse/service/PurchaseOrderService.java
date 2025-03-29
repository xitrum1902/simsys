package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.PurchaseOrderDTO;
import com.simsys.warehouse.entity.PurchaseOrderEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.mapper.PurchaseOrderMapper;
import com.simsys.warehouse.repository.PurchaseOrderRepository;
import com.simsys.warehouse.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, SupplierRepository supplierRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.supplierRepository = supplierRepository;
    }

    public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO dto) {
        SupplierEntity supplierEntity = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + dto.getSupplierId()));

        PurchaseOrderEntity entity = PurchaseOrderMapper.toEntity(dto, supplierEntity);
        return PurchaseOrderMapper.toDTO(purchaseOrderRepository.save(entity));
    }

    public List<PurchaseOrderDTO> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll().stream()
                .map(PurchaseOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PurchaseOrderDTO getPurchaseOrderById(Integer id) {
        PurchaseOrderEntity entity = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found with ID: " + id));
        return PurchaseOrderMapper.toDTO(entity);
    }

    public PurchaseOrderDTO updatePurchaseOrder(Integer id, PurchaseOrderDTO dto) {
        PurchaseOrderEntity existingEntity = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found with ID: " + id));

        SupplierEntity supplierEntity = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + dto.getSupplierId()));

        existingEntity.setSupplierid(supplierEntity);
        existingEntity.setQuantity(dto.getQuantity());
        existingEntity.setNote(dto.getNote());
        existingEntity.setTotalamount(dto.getTotalAmount());
        existingEntity.setStatus(dto.getStatus());
        existingEntity.setOrderdate(dto.getOrderDate());

        return PurchaseOrderMapper.toDTO(purchaseOrderRepository.save(existingEntity));
    }

    public void deletePurchaseOrder(Integer id) {
        PurchaseOrderEntity existingEntity = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchaseOrder not found with ID: " + id));
        purchaseOrderRepository.delete(existingEntity);
    }
}
