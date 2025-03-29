package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.ConsignmentDTO;
import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.entity.SupplierEntity;
import com.simsys.warehouse.entity.UserEntity;
import com.simsys.warehouse.mapper.ConsignmentMapper;
import com.simsys.warehouse.repository.ConsignmentRepository;
import com.simsys.warehouse.repository.SupplierRepository;
import com.simsys.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ConsignmentService {

    private final ConsignmentRepository consignmentRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;

    public ConsignmentService(ConsignmentRepository consignmentRepository, SupplierRepository supplierRepository, UserRepository userRepository) {
        this.consignmentRepository = consignmentRepository;
        this.supplierRepository = supplierRepository;
        this.userRepository = userRepository;
    }

    public ConsignmentDTO createConsignment(ConsignmentDTO dto) {
        SupplierEntity supplierEntity = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + dto.getSupplierId()));

        UserEntity userEntity = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        ConsignmentEntity entity = ConsignmentMapper.toEntity(dto, supplierEntity, userEntity);
        return ConsignmentMapper.toDTO(consignmentRepository.save(entity));
    }

    public List<ConsignmentDTO> getAllConsignments() {
        return consignmentRepository.findAll().stream()
                .map(ConsignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ConsignmentDTO getConsignmentById(Integer id) {
        ConsignmentEntity entity = consignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consignment not found with ID: " + id));
        return ConsignmentMapper.toDTO(entity);
    }

    public ConsignmentDTO updateConsignment(Integer id, ConsignmentDTO dto) {
        ConsignmentEntity existingEntity = consignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consignment not found with ID: " + id));

        SupplierEntity supplierEntity = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + dto.getSupplierId()));

        UserEntity userEntity = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));

        existingEntity.setSku(dto.getSku());
        existingEntity.setName(dto.getName());
        existingEntity.setDescription(dto.getDescription());
        existingEntity.setTotalquantity(dto.getTotalQuantity());
        existingEntity.setTotalprice(dto.getTotalPrice());
        existingEntity.setImportdate(dto.getImportDate());
        existingEntity.setStatus(dto.getStatus());
        existingEntity.setSupplierid(supplierEntity);
        existingEntity.setUserid(userEntity);

        return ConsignmentMapper.toDTO(consignmentRepository.save(existingEntity));
    }

    public void deleteConsignment(Integer id) {
        ConsignmentEntity existingEntity = consignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consignment not found with ID: " + id));
        consignmentRepository.delete(existingEntity);
    }
}
