package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.TransferRequestDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.TransferRequestEntity;
import com.simsys.warehouse.mapper.TransferRequestMapper;
import com.simsys.warehouse.repository.InventoryRepository;
import com.simsys.warehouse.repository.TransferRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferRequestService {

    @Autowired
    private TransferRequestRepository transferRequestRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<TransferRequestDTO> findAll() {
        return transferRequestRepository.findAll().stream()
                .map(TransferRequestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransferRequestDTO findById(Integer id) {
        return transferRequestRepository.findById(id)
                .map(TransferRequestMapper::toDTO)
                .orElse(null);
    }

    public TransferRequestDTO create(TransferRequestDTO dto) {
        InventoryEntity toInventory = inventoryRepository.findById(dto.getToInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        TransferRequestEntity entity = TransferRequestMapper.toEntity(dto, toInventory);
        TransferRequestEntity savedEntity = transferRequestRepository.save(entity);
        return TransferRequestMapper.toDTO(savedEntity);
    }

    public TransferRequestDTO update(Integer id, TransferRequestDTO dto) {
        TransferRequestEntity existingEntity = transferRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transfer Request not found"));

        InventoryEntity toInventory = inventoryRepository.findById(dto.getToInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        existingEntity.setNote(dto.getNote());
        existingEntity.setQuantity(dto.getQuantity());
        existingEntity.setTransferdate(dto.getTransferDate());
        existingEntity.setToinventoryid(toInventory);

        TransferRequestEntity updatedEntity = transferRequestRepository.save(existingEntity);
        return TransferRequestMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        transferRequestRepository.deleteById(id);
    }
}
