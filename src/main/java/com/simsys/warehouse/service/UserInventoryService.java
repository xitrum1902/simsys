package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.UserInventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.UserInventoryEntity;
import com.simsys.warehouse.mapper.UserInventoryMapper;
import com.simsys.warehouse.repository.InventoryRepository;
import com.simsys.warehouse.repository.UserInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInventoryService {

    @Autowired
    private UserInventoryRepository userInventoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<UserInventoryDTO> findAll() {
        return userInventoryRepository.findAll().stream()
                .map(UserInventoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserInventoryDTO findById(Integer id) {
        return userInventoryRepository.findById(id)
                .map(UserInventoryMapper::toDTO)
                .orElse(null);
    }

    public UserInventoryDTO create(UserInventoryDTO dto) {
        InventoryEntity inventory = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        UserInventoryEntity entity = UserInventoryMapper.toEntity(dto, inventory);
        UserInventoryEntity savedEntity = userInventoryRepository.save(entity);
        return UserInventoryMapper.toDTO(savedEntity);
    }

    public UserInventoryDTO update(Integer id, UserInventoryDTO dto) {
        UserInventoryEntity existingEntity = userInventoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User Inventory not found"));

        InventoryEntity inventory = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        existingEntity.setStatus(dto.getStatus());
        existingEntity.setInventoryid(inventory);

        UserInventoryEntity updatedEntity = userInventoryRepository.save(existingEntity);
        return UserInventoryMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        userInventoryRepository.deleteById(id);
    }
}
