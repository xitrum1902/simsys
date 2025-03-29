package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.InventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.mapper.InventoryMapper;
import com.simsys.warehouse.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryDTO> findAll() {
        return inventoryRepository.findAll().stream()
                .map(InventoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InventoryDTO findById(Integer id) {
        return inventoryRepository.findById(id)
                .map(InventoryMapper::toDTO)
                .orElse(null);
    }

    public InventoryDTO create(InventoryDTO inventoryDTO) {
        InventoryEntity entity = InventoryMapper.toEntity(inventoryDTO);
        InventoryEntity savedEntity = inventoryRepository.save(entity);
        return InventoryMapper.toDTO(savedEntity);
    }

    public InventoryDTO update(Integer id, InventoryDTO inventoryDTO) {
        InventoryEntity existingEntity = inventoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        existingEntity.setName(inventoryDTO.getName());
        existingEntity.setAddress(inventoryDTO.getAddress());
        existingEntity.setQuantity(inventoryDTO.getQuantity());
        existingEntity.setDescription(inventoryDTO.getDescription());

        InventoryEntity updatedEntity = inventoryRepository.save(existingEntity);
        return InventoryMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        inventoryRepository.deleteById(id);
    }
}
