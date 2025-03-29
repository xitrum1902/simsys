package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.ProductInventoryDTO;
import com.simsys.warehouse.entity.InventoryEntity;
import com.simsys.warehouse.entity.ProductInventoryEntity;
import com.simsys.warehouse.mapper.ProductInventoryMapper;
import com.simsys.warehouse.repository.InventoryRepository;
import com.simsys.warehouse.repository.ProductInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<ProductInventoryDTO> findAll() {
        return productInventoryRepository.findAll().stream()
                .map(ProductInventoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductInventoryDTO findById(Integer id) {
        return productInventoryRepository.findById(id)
                .map(ProductInventoryMapper::toDTO)
                .orElse(null);
    }

    public ProductInventoryDTO create(ProductInventoryDTO dto) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        ProductInventoryEntity entity = ProductInventoryMapper.toEntity(dto, inventoryEntity);
        ProductInventoryEntity savedEntity = productInventoryRepository.save(entity);
        return ProductInventoryMapper.toDTO(savedEntity);
    }

    public ProductInventoryDTO update(Integer id, ProductInventoryDTO dto) {
        ProductInventoryEntity existingEntity = productInventoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product Inventory not found"));

        InventoryEntity inventoryEntity = inventoryRepository.findById(dto.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));

        existingEntity.setInventoryid(inventoryEntity);
        existingEntity.setTransferdate(dto.getTransferDate());

        ProductInventoryEntity updatedEntity = productInventoryRepository.save(existingEntity);
        return ProductInventoryMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        productInventoryRepository.deleteById(id);
    }
}
