package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.SupplierPerformanceDTO;
import com.simsys.warehouse.entity.SupplierPerformanceEntity;
import com.simsys.warehouse.entity.ConsignmentEntity;
import com.simsys.warehouse.mapper.SupplierPerformanceMapper;
import com.simsys.warehouse.repository.SupplierPerformanceRepository;
import com.simsys.warehouse.repository.ConsignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierPerformanceService {

    @Autowired
    private SupplierPerformanceRepository repository;

    @Autowired
    private ConsignmentRepository consignmentRepository;

    public List<SupplierPerformanceDTO> findAll() {
        return repository.findAll().stream()
                .map(SupplierPerformanceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierPerformanceDTO findById(Integer id) {
        return repository.findById(id)
                .map(SupplierPerformanceMapper::toDTO)
                .orElse(null);
    }

    public SupplierPerformanceDTO create(SupplierPerformanceDTO dto) {
        Optional<ConsignmentEntity> consignment = consignmentRepository.findById(dto.getConsignmentId());
        if (consignment.isEmpty()) {
            throw new IllegalArgumentException("Consignment not found");
        }
        SupplierPerformanceEntity entity = SupplierPerformanceMapper.toEntity(dto, consignment.get());
        return SupplierPerformanceMapper.toDTO(repository.save(entity));
    }

    public SupplierPerformanceDTO update(Integer id, SupplierPerformanceDTO dto) {
        SupplierPerformanceEntity entity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Performance not found"));
        Optional<ConsignmentEntity> consignment = consignmentRepository.findById(dto.getConsignmentId());
        if (consignment.isEmpty()) {
            throw new IllegalArgumentException("Consignment not found");
        }
        entity.setOntimedeliveryrate(dto.getOnTimeDeliveryRate());
        entity.setProductqualityrating(dto.getProductQualityRating());
        entity.setNotes(dto.getNotes());
        entity.setRulescompletionrate(dto.getRulesCompletionRate());
        entity.setLastevaluated(dto.getLastEvaluated());
        entity.setConsignmentid(consignment.get());
        entity.setStatus(dto.getStatus());
        return SupplierPerformanceMapper.toDTO(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
