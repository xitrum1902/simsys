package com.simsys.warehouse.service;

import com.simsys.warehouse.dto.SupplierPerformanceDetailDTO;
import com.simsys.warehouse.entity.SupplierPerformanceDetailEntity;
import com.simsys.warehouse.mapper.SupplierPerformanceDetailMapper;
import com.simsys.warehouse.repository.SupplierPerformanceDetailRepository;
import com.simsys.warehouse.repository.SupplierPerformanceRepository;
import com.simsys.warehouse.repository.VariantValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierPerformanceDetailService {

    @Autowired
    private SupplierPerformanceDetailRepository supplierPerformanceDetailRepository;

    @Autowired
    private SupplierPerformanceRepository supplierPerformanceRepository;

    @Autowired
    private VariantValueRepository variantValueRepository;

    public List<SupplierPerformanceDetailDTO> findAll() {
        return supplierPerformanceDetailRepository.findAll().stream()
                .map(SupplierPerformanceDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupplierPerformanceDetailDTO findById(Integer id) {
        return supplierPerformanceDetailRepository.findById(id)
                .map(SupplierPerformanceDetailMapper::toDTO)
                .orElse(null);
    }

    public SupplierPerformanceDetailDTO create(SupplierPerformanceDetailDTO dto) {
        SupplierPerformanceDetailEntity entity = SupplierPerformanceDetailMapper.toEntity(dto);
        entity.setPerformanceid(supplierPerformanceRepository.findById(dto.getPerformanceId()).orElse(null));
        entity.setVariantvalueid(variantValueRepository.findById(dto.getVariantValueId()).orElse(null));
        SupplierPerformanceDetailEntity savedEntity = supplierPerformanceDetailRepository.save(entity);
        return SupplierPerformanceDetailMapper.toDTO(savedEntity);
    }

    public SupplierPerformanceDetailDTO update(Integer id, SupplierPerformanceDetailDTO dto) {
        SupplierPerformanceDetailEntity entity = supplierPerformanceDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Performance Detail not found"));

        entity.setStatus(dto.getStatus());
        entity.setPerformanceid(supplierPerformanceRepository.findById(dto.getPerformanceId()).orElse(null));
        entity.setVariantvalueid(variantValueRepository.findById(dto.getVariantValueId()).orElse(null));

        SupplierPerformanceDetailEntity updatedEntity = supplierPerformanceDetailRepository.save(entity);
        return SupplierPerformanceDetailMapper.toDTO(updatedEntity);
    }

    public void delete(Integer id) {
        supplierPerformanceDetailRepository.deleteById(id);
    }
}
