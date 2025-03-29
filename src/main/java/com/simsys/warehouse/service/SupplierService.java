package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.SupplierDTO;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.mapper.SupplierMapper;
import com.simsys.warehouse.repository.SupplierRepository;
import com.simsys.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    public SupplierService(SupplierRepository supplierRepository, UserRepository userRepository) {
        this.supplierRepository = supplierRepository;
        this.userRepository = userRepository;
    }

    public Optional<SupplierEntity> findSupplierById(Integer id) {
        return supplierRepository.findById(id);
    }

    public SupplierDTO createSupplier(SupplierDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        SupplierEntity entity = SupplierMapper.toEntity(dto, user);
        return SupplierMapper.toDTO(supplierRepository.save(entity));
    }

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(SupplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierDTO getSupplierById(Integer id) {
        SupplierEntity entity = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
        return SupplierMapper.toDTO(entity);
    }

    public SupplierDTO updateSupplier(Integer id, SupplierDTO dto) {
        SupplierEntity existingEntity = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));

        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        existingEntity.setName(dto.getName());
        existingEntity.setPhone(dto.getPhone());
        existingEntity.setEmail(dto.getEmail());
        existingEntity.setAddress(dto.getAddress());
        existingEntity.setCreatedDate(dto.getCreatedDate());
        existingEntity.setUpdatedDate(dto.getUpdatedDate());
        existingEntity.setRating(dto.getRating());
        existingEntity.setUser(user);

        return SupplierMapper.toDTO(supplierRepository.save(existingEntity));
    }

    public void deleteSupplier(Integer id) {
        SupplierEntity existingEntity = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
        supplierRepository.delete(existingEntity);
    }
}
